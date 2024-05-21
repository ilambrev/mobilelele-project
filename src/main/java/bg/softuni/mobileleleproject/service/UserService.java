package bg.softuni.mobileleleproject.service;

import bg.softuni.mobileleleproject.model.dto.UserLoginDTO;
import bg.softuni.mobileleleproject.model.dto.UserRegistrationDTO;
import bg.softuni.mobileleleproject.model.entity.UserEntity;

public interface UserService {

    Boolean registerUser(UserRegistrationDTO userRegistrationDTO);

    UserEntity getUserById(Long id);

}