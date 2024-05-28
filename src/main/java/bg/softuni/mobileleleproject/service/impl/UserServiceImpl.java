package bg.softuni.mobileleleproject.service.impl;

import bg.softuni.mobileleleproject.exceptions.UserNotFoundException;
import bg.softuni.mobileleleproject.model.dto.UserRegistrationDTO;
import bg.softuni.mobileleleproject.model.entity.UserEntity;
import bg.softuni.mobileleleproject.model.events.UserRegisteredEvent;
import bg.softuni.mobileleleproject.repository.UserRepository;
import bg.softuni.mobileleleproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Locale;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserRoleServiceImpl userRoleService;
    private final PasswordEncoder passwordEncoder;
    private final ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserRoleServiceImpl userRoleService, PasswordEncoder passwordEncoder, ApplicationEventPublisher applicationEventPublisher) {
        this.userRepository = userRepository;
        this.userRoleService = userRoleService;
        this.passwordEncoder = passwordEncoder;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public Boolean registerUser(UserRegistrationDTO userRegistrationDTO) {

        UserEntity user = new UserEntity()
                .setEmail(userRegistrationDTO.getEmail().toLowerCase(Locale.ENGLISH))
                .setPassword(this.passwordEncoder.encode(userRegistrationDTO.getPassword()))
                .setFirstName(userRegistrationDTO.getFirstName())
                .setLastName(userRegistrationDTO.getLastName())
                .setActive(false)
                .setCreated(LocalDateTime.now())
                .setRole(this.userRoleService.getRole("USER"));

        this.userRepository.save(user);

        this.applicationEventPublisher.publishEvent(new UserRegisteredEvent("UserService",
                userRegistrationDTO.getEmail(), userRegistrationDTO.getFullName()));

        return true;
    }

    @Override
    public UserEntity getUserById(Long id) {
        return this.userRepository
                .findById(id).orElseThrow(() -> new UserNotFoundException("User with id: " + id + " not found!"));
    }

    @Override
    public UserEntity getUserByEmail(String email) {
        return this.userRepository
                .findByEmail(email).orElseThrow(() -> new UserNotFoundException("User with email: " + email + " not found!"));
    }
}