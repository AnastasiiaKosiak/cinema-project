package mate.academy.cinema.model.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import mate.academy.cinema.validator.EmailValidation;
import mate.academy.cinema.validator.PasswordValidation;

@PasswordValidation
public class UserRequestDto {
    @EmailValidation(message = "email format is invalid")
    @NotNull(message = "email can't be empty")
    private String email;
    @NotNull(message = "password can't be empty")
    @Size(min = 8, message = "password must have at least 8 characters")
    private String password;
    private String repeatPassword;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }
}
