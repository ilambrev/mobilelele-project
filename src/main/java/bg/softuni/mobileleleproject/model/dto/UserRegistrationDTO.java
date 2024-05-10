package bg.softuni.mobileleleproject.model.dto;

import bg.softuni.mobileleleproject.model.validation.UniqueUserEmail;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class UserRegistrationDTO {

    @NotNull
    @NotBlank
    @Length(min = 2, max = 20)
    private String firstName;

    @NotNull
    @NotBlank
    @Length(min = 2, max = 20)
    private String lastName;

    @NotNull
    @NotBlank
    @Length(min = 6)
    @Email
    @UniqueUserEmail
    private String email;

    @NotNull
    @NotBlank
    @Length(min = 2, max = 20)
    private String password;

    @NotNull
    @NotBlank
    private String confirmPassword;

    public UserRegistrationDTO() {

    }

    public String getFirstName() {
        return firstName;
    }

    public UserRegistrationDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserRegistrationDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegistrationDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegistrationDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegistrationDTO setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

}