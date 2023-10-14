package bg.softuni.mobileleleproject.service.impl;

import bg.softuni.mobileleleproject.model.dto.OfferDTO;
import bg.softuni.mobileleleproject.repository.OfferRepository;
import bg.softuni.mobileleleproject.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;

    @Autowired
    public OfferServiceImpl(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @Override
    public List<OfferDTO> getAllOffers() {
        return this.offerRepository.findAll()
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

}