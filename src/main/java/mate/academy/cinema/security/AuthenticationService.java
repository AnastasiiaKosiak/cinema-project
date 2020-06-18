package mate.academy.cinema.security;

import java.util.Set;
import mate.academy.cinema.exceptions.AuthenticationException;
import mate.academy.cinema.model.Role;
import mate.academy.cinema.model.User;

public interface AuthenticationService {
    User login(String email, String password) throws AuthenticationException;

    User register(String email, String password, Set<Role> roles);
}
