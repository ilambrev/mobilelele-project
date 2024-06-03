package bg.softuni.mobileleleproject.config;

import bg.softuni.mobileleleproject.model.enums.RoleEnum;
import bg.softuni.mobileleleproject.repository.UserRepository;
import bg.softuni.mobileleleproject.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    private final AuthPropertiesConfiguration authPropertiesConfiguration;

    @Autowired
    public SecurityConfiguration(AuthPropertiesConfiguration authPropertiesConfiguration) {
        this.authPropertiesConfiguration = authPropertiesConfiguration;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(
                authorizeRequests -> authorizeRequests
                        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                        .requestMatchers("/", "/users/login", "/users/login-error", "users/register", "/users/activate").permitAll()
                        .requestMatchers("/offers/all", "/offer/details/**").permitAll()
                        .requestMatchers("/error").permitAll()
                        .requestMatchers("/brands/**").hasRole(RoleEnum.ADMIN.name())
                        .anyRequest().authenticated()
        ).formLogin(formLogin -> formLogin
                .loginPage("/users/login")
                .usernameParameter("email")
                .passwordParameter("password")
                .defaultSuccessUrl("/")
                .failureForwardUrl("/users/login-error")
        ).logout(logout -> logout
                .logoutUrl("/users/logout")
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
        ).rememberMe(rememberMe -> rememberMe
                .key(authPropertiesConfiguration.getRememberMeKey())
                .rememberMeParameter("rememberMe")
                .rememberMeCookieName("rememberMe")
        );

        return httpSecurity.build();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository) {
        return new UserDetailsServiceImpl(userRepository);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_8();
    }
}