package bg.softuni.mobileleleproject.service.impl;

import bg.softuni.mobileleleproject.model.events.UserRegisteredEvent;
import bg.softuni.mobileleleproject.service.EmailService;
import bg.softuni.mobileleleproject.service.UserActivationService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class UserActivationServiceImpl implements UserActivationService {

    private final EmailService emailService;

    public UserActivationServiceImpl(EmailService emailService) {
        this.emailService = emailService;
    }

    @Override
    @EventListener(UserRegisteredEvent.class)
    public void userRegistered(UserRegisteredEvent event) {
        this.emailService.sendRegistrationEmail(event.getUserEmail(), event.getUserName());
    }
}