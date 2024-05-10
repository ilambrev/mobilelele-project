package bg.softuni.mobileleleproject.service.impl;

import bg.softuni.mobileleleproject.exceptions.UserNotFoundException;
import bg.softuni.mobileleleproject.model.dto.UserLoginDTO;
import bg.softuni.mobileleleproject.model.dto.UserRegistrationDTO;
import bg.softuni.mobileleleproject.model.entity.UserEntity;
import bg.softuni.mobileleleproject.repository.UserRepository;
import bg.softuni.mobileleleproject.service.UserService;
import bg.softuni.mobileleleproject.util.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserRoleServiceImpl userRoleService;
    private final PasswordEncoder passwordEncoder;
    private final CurrentUser currentUser;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserRoleServiceImpl userRoleService, PasswordEncoder passwordEncoder, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.userRoleService = userRoleService;
        this.passwordEncoder = passwordEncoder;
        this.currentUser = currentUser;
    }

    @Override
    public Boolean registerUser(UserRegistrationDTO userRegistrationDTO) {

        UserEntity user = new UserEntity()
                .setEmail(userRegistrationDTO.getEmail())
                .setPassword(this.passwordEncoder.encode(userRegistrationDTO.getPassword()))
                .setFirstName(userRegistrationDTO.getFirstName())
                .setLastName(userRegistrationDTO.getLastName())
                .setActive(true)
                .setCreated(LocalDateTime.now())
                .setRole(this.userRoleService.getRole("USER"));

        this.userRepository.save(user);

        return true;
    }

    @Override
    public Boolean loginUser(UserLoginDTO userLoginDTO) {

        Optional<UserEntity> optionalUser = this.userRepository.findByEmail(userLoginDTO.getEmail());

        if (optionalUser.isEmpty()) {
            return false;
        }

        UserEntity user = optionalUser.get();

        if (!this.passwordEncoder.matches(userLoginDTO.getPassword(), user.getPassword())) {
            return false;
        }

        this.currentUser.setId(user.getId())
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setRole(user.getRole())
                .setLogged(true);

        return true;
    }

    @Override
    public void logOutUser() {
        this.currentUser.logout();
    }

    @Override
    public UserEntity getUserById(Long id) {
        return this.userRepository
                .findById(id).orElseThrow(() -> new UserNotFoundException("User with id: " + id + " not found!"));
    }

}