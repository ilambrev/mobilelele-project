package bg.softuni.mobileleleproject.service;

import bg.softuni.mobileleleproject.model.dto.OfferDTO;

import java.util.List;
import java.util.UUID;

public interface OfferService {

    List<OfferDTO> getAllOffers();

    OfferDTO getOfferByUUID(UUID uuid);

}