package mate.academy.cinema.dao;

import java.util.Optional;
import mate.academy.cinema.model.User;

public interface UserDao {
    User add(User user);

    Optional<User> findByEmail(String email);
}
