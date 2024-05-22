package bg.softuni.mobileleleproject.service;

import bg.softuni.mobileleleproject.model.dto.OfferCreateDTO;
import bg.softuni.mobileleleproject.model.dto.OfferDTO;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.UUID;

public interface OfferService {

    List<OfferDTO> getAllOffers();

    OfferDTO getOfferByUUID(UUID uuid);

    boolean addOffer(OfferCreateDTO offerCreateDTO, UserDetails currentUser);
}