package bg.softuni.mobileleleproject.service;

import bg.softuni.mobileleleproject.model.events.UserRegisteredEvent;

public interface UserActivationService {

    void userRegistered(UserRegisteredEvent event);

    void cleanUpObsoleteActivationLinks();

    String createActivationCode(String userEmail);
}