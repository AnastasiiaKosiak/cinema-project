package mate.academy.cinema.validator;

import java.util.Objects;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import mate.academy.cinema.model.dto.UserRequestDto;

public class PasswordValidator implements ConstraintValidator<PasswordValidation, UserRequestDto> {
    @Override
    public boolean isValid(UserRequestDto requestDto,
                           ConstraintValidatorContext constraintValidatorContext) {
        return Objects.equals(requestDto.getPassword(), requestDto.getRepeatPassword());
    }
}
