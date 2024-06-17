package bg.softuni.mobileleleproject.service;

import bg.softuni.mobileleleproject.model.dto.OfferCreateDTO;
import bg.softuni.mobileleleproject.model.dto.OfferDTO;
import bg.softuni.mobileleleproject.model.dto.OfferEditDTO;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.UUID;

public interface OfferService {

    List<OfferDTO> getAllOffers();

    OfferDTO getOfferDTOByUUID(UUID uuid);

    OfferEditDTO getOfferEditDTOByUUID(UUID uuid);

    boolean addOffer(OfferCreateDTO offerCreateDTO, UserDetails currentUser);

    boolean editOffer(OfferEditDTO offerEditDTO);

    void deleteOffer(UUID uuid);

    boolean isOwner(UUID uuid, String username);
}