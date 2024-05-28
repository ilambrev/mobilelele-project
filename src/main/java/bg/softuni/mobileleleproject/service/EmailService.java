package bg.softuni.mobileleleproject.service;

public interface EmailService {

    void sendRegistrationEmail(String userEmail, String userName);
}