package bg.softuni.mobileleleproject.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

public class UserRegistrationDTO {

    @NotBlank
    @Length(min = 2, max = 20)
    private String firstName;

    @NotBlank
    @Length(min = 2, max = 20)
    private String lastName;

    @NotBlank
    @Length(min = 6)
    @Pattern(regexp = "^(.+)@(.+)$")
    private String email;

    @NotBlank
    @Length(min = 2, max = 20)
    private String password;

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