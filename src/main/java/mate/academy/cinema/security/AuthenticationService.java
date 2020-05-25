package mate.academy.cinema.security;

import mate.academy.cinema.exceptions.AuthenticationException;
import mate.academy.cinema.model.User;

public interface AuthenticationService {
    User login(String email, String password) throws AuthenticationException;

    User register(String email, String password);
}
