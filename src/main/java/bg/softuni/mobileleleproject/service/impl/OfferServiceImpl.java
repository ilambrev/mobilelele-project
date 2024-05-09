package bg.softuni.mobileleleproject.service.impl;

import bg.softuni.mobileleleproject.model.dto.OfferCreateDTO;
import bg.softuni.mobileleleproject.model.dto.OfferDTO;
import bg.softuni.mobileleleproject.model.entity.ModelEntity;
import bg.softuni.mobileleleproject.model.entity.OfferEntity;
import bg.softuni.mobileleleproject.model.entity.UserEntity;
import bg.softuni.mobileleleproject.repository.OfferRepository;
import bg.softuni.mobileleleproject.service.ModelService;
import bg.softuni.mobileleleproject.service.OfferService;
import bg.softuni.mobileleleproject.service.UserService;
import bg.softuni.mobileleleproject.util.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final ModelService modelService;
    private final UserService userService;
    private final CurrentUser currentUser;

    @Autowired
    public OfferServiceImpl(OfferRepository offerRepository, ModelService modelService, UserService userService, CurrentUser currentUser) {
        this.offerRepository = offerRepository;
        this.modelService = modelService;
        this.userService = userService;
        this.currentUser = currentUser;
    }

    @Override
    public List<OfferDTO> getAllOffers() {
        return this.offerRepository.findAllByOrderByIdDesc()
                .stream()
                .map(offer -> new OfferDTO(
                        offer.getUuid().toString(),
                        offer.getDescription(),
                        offer.getEngine().name(),
                        offer.getImageUrl(),
                        offer.getMileage(),
                        offer.getPrice(),
                        offer.getTransmission().name(),
                        offer.getYear(),
                        offer.getCreated(),
                        offer.getModified(),
                        offer.getModel().getBrand().getName(),
                        offer.getModel().getName(),
                        offer.getSeller().getFirstName() + ' ' + offer.getSeller().getLastName())
                ).toList();

    }

    @Override
    public OfferDTO getOfferByUUID(UUID uuid) {
        OfferEntity offer = this.offerRepository.getByUuid(uuid);

        return new OfferDTO(
                offer.getUuid().toString(),
                offer.getDescription(),
                offer.getEngine().name(),
                offer.getImageUrl(),
                offer.getMileage(),
                offer.getPrice(),
                offer.getTransmission().name(),
                offer.getYear(),
                offer.getCreated(),
                offer.getModified(),
                offer.getModel().getBrand().getName(),
                offer.getModel().getName(),
                offer.getSeller().getFirstName() + ' ' + offer.getSeller().getLastName()
        );
    }

    @Override
    public boolean addOffer(OfferCreateDTO offerCreateDTO) {
        ModelEntity model = this.modelService.getModelById(offerCreateDTO.getModelId());
        UserEntity seller = this.userService.getUserById(this.currentUser.getId());
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

}