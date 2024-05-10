package bg.softuni.mobileleleproject.model.dto;

import bg.softuni.mobileleleproject.model.validation.FieldMatch;
import bg.softuni.mobileleleproject.model.validation.UniqueUserEmail;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

@FieldMatch(
        first = "password",
        second = "confirmPassword",
        message = "Passwords should match."
)
public class UserRegistrationDTO {

    @NotEmpty(message = "First name is required.")
    @Length(min = 2, max = 20, message = "First name must be between 2 and 20 symbols.")
    private String firstName;

    @NotEmpty(message = "Last name is required.")
    @Length(min = 2, max = 20, message = "Last name must be between 2 and 20 symbols.")
    private String lastName;

    @NotEmpty(message = "Email is required.")
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",
            flags = Pattern.Flag.CASE_INSENSITIVE,
            message = "Invalid email format.")
    @UniqueUserEmail
    private String email;

    @NotEmpty(message = "Password is required.")
    @Length(min = 2, max = 20, message = "Password must be between 2 and 20 symbols.")
    private String password;

    @NotEmpty(message = "Password confirmation is required.")
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