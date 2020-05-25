package mate.academy.cinema.service;

import java.util.Optional;
import mate.academy.cinema.model.User;

public interface UserService {
    User add(User user);

    Optional<User> findByEmail(String email);
}
