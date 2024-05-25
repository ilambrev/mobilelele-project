package bg.softuni.mobileleleproject.service.impl;

import bg.softuni.mobileleleproject.model.dto.OfferCreateDTO;
import bg.softuni.mobileleleproject.model.dto.OfferDTO;
import bg.softuni.mobileleleproject.model.dto.OfferEditDTO;
import bg.softuni.mobileleleproject.model.entity.ModelEntity;
import bg.softuni.mobileleleproject.model.entity.OfferEntity;
import bg.softuni.mobileleleproject.model.entity.UserEntity;
import bg.softuni.mobileleleproject.repository.OfferRepository;
import bg.softuni.mobileleleproject.service.ModelService;
import bg.softuni.mobileleleproject.service.OfferService;
import bg.softuni.mobileleleproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final ModelService modelService;
    private final UserService userService;

    @Autowired
    public OfferServiceImpl(OfferRepository offerRepository, ModelService modelService, UserService userService) {
        this.offerRepository = offerRepository;
        this.modelService = modelService;
        this.userService = userService;
    }

    @Override
    public List<OfferDTO> getAllOffers() {
        return this.offerRepository.findAllByOrderByIdDesc()
                .stream()
                .map(this::map)
                .toList();
    }

    @Override
    public OfferDTO getOfferDTOByUUID(UUID uuid) {
        OfferEntity offer = getOfferByUUID(uuid);

        return map(offer);
    }

    @Override
    public OfferEditDTO getOfferEditDTOByUUID(UUID uuid) {
        OfferEntity offer = getOfferByUUID(uuid);

        return new OfferEditDTO()
                .setUuid(offer.getUuid())
                .setModelId(offer.getModel().getId())
                .setPrice(offer.getPrice())
                .setEngine(offer.getEngine())
                .setTransmission(offer.getTransmission())
                .setYear(offer.getYear())
                .setMileage(offer.getMileage())
                .setDescription(offer.getDescription())
                .setImageUrl(offer.getImageUrl());
    }

    @Override
    public boolean addOffer(OfferCreateDTO offerCreateDTO, UserDetails currentUser) {
        ModelEntity model = this.modelService.getModelById(offerCreateDTO.getModelId());
        UserEntity seller = this.userService.getUserByEmail(currentUser.getUsername());
        LocalDateTime currentDateTime = LocalDateTime.now();
        OfferEntity offer = new OfferEntity()
                .setDescription(offerCreateDTO.getDescription())
                .setEngine(offerCreateDTO.getEngine())
                .setImageUrl(offerCreateDTO.getImageUrl())
                .setMileage(offerCreateDTO.getMileage())
                .setPrice(offerCreateDTO.getPrice())
                .setTransmission(offerCreateDTO.getTransmission())
                .setYear(offerCreateDTO.getYear())
                .setCreated(currentDateTime)
                .setModified(currentDateTime)
                .setModel(model)
                .setSeller(seller);

        this.offerRepository.save(offer);

        return true;
    }

    @Override
    public boolean editOffer(OfferEditDTO offerEditDTO) {
        OfferEntity offer = getOfferByUUID(offerEditDTO.getUuid());
        ModelEntity model = this.modelService.getModelById(offerEditDTO.getModelId());
        LocalDateTime currentDateTime = LocalDateTime.now();

        offer.setModel(model)
                .setPrice(offerEditDTO.getPrice())
                .setEngine(offerEditDTO.getEngine())
                .setTransmission(offerEditDTO.getTransmission())
                .setYear(offerEditDTO.getYear())
                .setMileage(offer.getMileage())
                .setDescription(offer.getDescription())
                .setImageUrl(offerEditDTO.getImageUrl())
                .setModified(currentDateTime);

        this.offerRepository.save(offer);

        return true;
    }

    private OfferEntity getOfferByUUID(UUID uuid) {
        return this.offerRepository.getByUuid(uuid);
    }

    private OfferDTO map(OfferEntity offer) {
        return new OfferDTO()
                .setUuid(offer.getUuid().toString())
                .setDescription(offer.getDescription())
                .setEngine(offer.getEngine().name())
                .setImageUrl(offer.getImageUrl())
                .setMileage(offer.getMileage())
                .setPrice(offer.getPrice())
                .setTransmission(offer.getTransmission().name())
                .setYear(offer.getYear())
                .setCreated(offer.getCreated())
                .setModified(offer.getModified())
                .setBrand(offer.getModel().getBrand().getName())
                .setModel(offer.getModel().getName())
                .setSeller(offer.getSeller().getFirstName() + ' ' + offer.getSeller().getLastName())
                .setSellerEmail(offer.getSeller().getEmail());
    }
}