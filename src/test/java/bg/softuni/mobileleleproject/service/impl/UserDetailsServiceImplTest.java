package bg.softuni.mobileleleproject.service.impl;

import bg.softuni.mobileleleproject.model.entity.UserEntity;
import bg.softuni.mobileleleproject.model.entity.UserRoleEntity;
import bg.softuni.mobileleleproject.model.enums.RoleEnum;
import bg.softuni.mobileleleproject.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
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
    void testUserNotFoundException() {
        assertThrows(UsernameNotFoundException.class,
                () -> serviceToTest.loadUserByUsername("john@mobilelele.bg"));
    }

    @Test
    void testUserFound() {
        UserEntity testUserEntity = createTestUser();
        when(mockUserRepository.findByEmail(testUserEntity.getEmail()))
                .thenReturn(Optional.of(testUserEntity));

        UserDetails userDetails = serviceToTest.loadUserByUsername(testUserEntity.getEmail());

        assertNotNull(userDetails);
        assertEquals(
                testUserEntity.getEmail(),
                userDetails.getUsername(),
                "Username is not mapped to email.");
        assertEquals(1, userDetails.getAuthorities().size());
        assertTrue(
                containsAuthority(userDetails,
                        "ROLE_" + RoleEnum.ADMIN),
                "The user is not admin.");
    }

    private boolean containsAuthority(UserDetails userDetails, String expectedAuthority) {
        return userDetails
                .getAuthorities()
                .stream()
                .anyMatch(a -> expectedAuthority.equals(a.getAuthority()));
    }

    private static UserEntity createTestUser() {
        return new UserEntity()
                .setFirstName("John")
                .setLastName("Doe")
                .setEmail("john@mobilele.bg")
                .setPassword("password")
                .setActive(false)
                .setRole(new UserRoleEntity().setName(RoleEnum.ADMIN));
    }
}