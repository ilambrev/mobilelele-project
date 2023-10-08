package bg.softuni.mobileleleproject.service;

import bg.softuni.mobileleleproject.model.dto.UserRegistrationDTO;

public interface UserService {

    Boolean registerUser(UserRegistrationDTO userRegistrationDTO);

}