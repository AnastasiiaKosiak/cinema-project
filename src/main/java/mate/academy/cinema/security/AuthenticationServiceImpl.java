package mate.academy.cinema.security;

import mate.academy.cinema.exceptions.AuthenticationException;
import mate.academy.cinema.model.User;
import mate.academy.cinema.service.ShoppingCartService;
import mate.academy.cinema.service.UserService;
import mate.academy.cinema.util.HashUtil;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final HashUtil hashUtil;
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;

    public AuthenticationServiceImpl(HashUtil hashUtil, UserService userService,
                                     ShoppingCartService shoppingCartService) {
        this.hashUtil = hashUtil;
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
    }

    @Override
    public User login(String email, String password) throws AuthenticationException {
        User user = userService.findByEmail(email).get();
        if (user.getPassword().equals(hashUtil.hashPassword(password, user.getSalt()))) {
            return user;
        } else {
            throw new AuthenticationException("Incorrect email or password");
        }
    }

    @Override
    public User register(String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setSalt(hashUtil.getSalt());
        user.setPassword(hashUtil.hashPassword(password, user.getSalt()));
        User registeredUser = userService.add(user);
        shoppingCartService.registerNewShoppingCart(registeredUser);
        return registeredUser;
    }
}
