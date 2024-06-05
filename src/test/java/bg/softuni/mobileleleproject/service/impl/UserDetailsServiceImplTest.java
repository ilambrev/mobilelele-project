package bg.softuni.mobileleleproject.service.impl;

import bg.softuni.mobileleleproject.model.entity.UserEntity;
import bg.softuni.mobileleleproject.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserDetailsServiceImplTest {

    private UserDetailsServiceImpl serviceToTest;

    @Mock
    private UserRepository mockUserRepository;

    @BeforeEach
    void setUp() {
        serviceToTest = new UserDetailsServiceImpl(mockUserRepository);
    }

    @Test
    void testUserNotFound() {
        Assertions.assertThrows(UsernameNotFoundException.class,
                () -> serviceToTest.loadUserByUsername("john@mobilelele.bg"));
    }

    @Test
    void testMock() {

        UserEntity userEntity = new UserEntity().setFirstName("John");

        when(mockUserRepository.findByEmail("john@mobilelele.bg")).thenReturn(Optional.of(userEntity));

        Optional<UserEntity> userOptional = mockUserRepository.findByEmail("john@mobilelele.bg");

        UserEntity user = userOptional.orElseGet(UserEntity::new);

        Assertions.assertEquals("John", user.getFirstName());
    }
}