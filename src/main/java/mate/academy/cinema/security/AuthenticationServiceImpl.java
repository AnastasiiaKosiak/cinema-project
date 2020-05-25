package mate.academy.cinema.security;

import mate.academy.cinema.exceptions.AuthenticationException;
import mate.academy.cinema.lib.Injector;
import mate.academy.cinema.model.User;
import mate.academy.cinema.service.UserService;
import mate.academy.cinema.util.HashUtil;

public class AuthenticationServiceImpl implements AuthenticationService {
    private static final Injector injector = Injector.getInstance("mate.academy.cinema");
    private static final UserService userService =
            (UserService)injector.getInstance(UserService.class);

    @Override
    public User login(String email, String password) throws AuthenticationException {
        User user = userService.findByEmail(email).get();
        if (user.getPassword().equals(HashUtil.hashPassword(password, user.getSalt()))) {
            return user;
        } else {
            throw new AuthenticationException("Incorrect email or password");
        }
    }

    @Override
    public User register(String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setSalt(HashUtil.getSalt());
        user.setPassword(HashUtil.hashPassword(user.getPassword(), user.getSalt()));
        return userService.add(user);
    }
}
