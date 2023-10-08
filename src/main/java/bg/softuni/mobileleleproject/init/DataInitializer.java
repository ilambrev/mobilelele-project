package bg.softuni.mobileleleproject.init;

import bg.softuni.mobileleleproject.model.entity.UserEntity;
import bg.softuni.mobileleleproject.model.entity.UserRoleEntity;
import bg.softuni.mobileleleproject.model.enums.RoleEnum;
import bg.softuni.mobileleleproject.repository.UserRepository;
import bg.softuni.mobileleleproject.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRoleRepository userRoleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public DataInitializer(UserRoleRepository userRoleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRoleRepository = userRoleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {

        if (this.userRoleRepository.count() == 0) {

            List<UserRoleEntity> roles = Arrays.stream(RoleEnum.values())
                    .map(UserRoleEntity::new).toList();

            this.userRoleRepository.saveAll(roles);

        }

        if (this.userRepository.count() == 0) {

            UserEntity administrator = new UserEntity()
                    .setEmail("admin@mobilelele.bg")
                    .setPassword(this.passwordEncoder.encode("secret"))
                    .setFirstName("Bruce")
                    .setLastName("Dickinson")
                    .setCreated(LocalDateTime.now())
                    .setImageUrl("https://www.expertimpact.com/wp-content/uploads/2023/07/speaker-profile-web-11-2.png")
                    .setActive(true);

            this.userRepository.save(administrator);

        }

    }

}