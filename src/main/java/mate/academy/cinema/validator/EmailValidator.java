package mate.academy.cinema.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<EmailValidation, String> {
    public static final String REGEX = "^.+@.*";

    @Override
    public void initialize(EmailValidation constraintAnnotation) {
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s.matches(REGEX);
    }
}
