package bg.softuni.mobileleleproject.model.validation;

import bg.softuni.mobileleleproject.repository.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class UniqueUserEmailValidator implements ConstraintValidator<UniqueUserEmail, String> {

    private final UserRepository userRepository;

    @Autowired
    public UniqueUserEmailValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        return this.userRepository.findByEmail(value).isEmpty();
    }
}