package bg.softuni.mobileleleproject.service;

import bg.softuni.mobileleleproject.model.dto.UserRegistrationDTO;
import bg.softuni.mobileleleproject.model.entity.UserEntity;

public interface UserService {

    Boolean registerUser(UserRegistrationDTO userRegistrationDTO, String appURL);

    UserEntity getUserById(Long id);

    UserEntity getUserByEmail(String email);
}