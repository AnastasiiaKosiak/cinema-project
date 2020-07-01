package mate.academy.cinema.security;

import java.util.Set;
import mate.academy.cinema.model.Role;
import mate.academy.cinema.model.User;

public interface AuthenticationService {
    User register(String email, String password, Set<Role> roles);
}
