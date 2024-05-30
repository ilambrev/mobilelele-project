package bg.softuni.mobileleleproject.service.impl;

import bg.softuni.mobileleleproject.model.entity.UserActivationCodeEntity;
import bg.softuni.mobileleleproject.model.events.UserRegisteredEvent;
import bg.softuni.mobileleleproject.repository.UserActivationCodeRepository;
import bg.softuni.mobileleleproject.service.EmailService;
import bg.softuni.mobileleleproject.service.UserActivationService;
import bg.softuni.mobileleleproject.service.UserService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.Instant;
import java.util.Random;

@Service
public class UserActivationServiceImpl implements UserActivationService {

    private static final String ACTIVATION_CODE_SYMBOLS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int ACTIVATION_CODE_LENGTH = 20;

    private final EmailService emailService;
    private final UserService userService;
    private final UserActivationCodeRepository userActivationCodeRepository;

    public UserActivationServiceImpl(EmailService emailService, UserService userService,
                                     UserActivationCodeRepository userActivationCodeRepository) {
        this.emailService = emailService;
        this.userService = userService;
        this.userActivationCodeRepository = userActivationCodeRepository;
    }

    @Override
    @EventListener(UserRegisteredEvent.class)
    public void userRegistered(UserRegisteredEvent event) {
        String activationCode = createActivationCode(event.getUserEmail());

        this.emailService.sendRegistrationEmail(event.getUserEmail(), event.getUserName(), event.getAppURL(), activationCode);
    }

    @Override
    public void cleanUpObsoleteActivationLinks() {

    }

    @Override
    public String createActivationCode(String userEmail) {
        String activationCode = generateActivationCode();

        UserActivationCodeEntity userActivationCodeEntity = new UserActivationCodeEntity()
                .setActivationCode(activationCode)
                .setCreated(Instant.now())
                .setUser(this.userService.getUserByEmail(userEmail));

        this.userActivationCodeRepository.save(userActivationCodeEntity);

        return activationCode;
    }

    private static String generateActivationCode() {
        StringBuilder activationCode = new StringBuilder();
        Random random = new SecureRandom();

        for (int i = 0; i < ACTIVATION_CODE_LENGTH; i++) {
            int randIndex = random.nextInt(ACTIVATION_CODE_SYMBOLS.length());
            activationCode.append(ACTIVATION_CODE_SYMBOLS.charAt(randIndex));
        }

        return activationCode.toString();
    }
}