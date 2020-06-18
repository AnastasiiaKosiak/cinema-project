package mate.academy.cinema.security;

import java.util.Set;
import mate.academy.cinema.exceptions.AuthenticationException;
import mate.academy.cinema.model.Role;
import mate.academy.cinema.model.User;
import mate.academy.cinema.service.ShoppingCartService;
import mate.academy.cinema.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;

    public AuthenticationServiceImpl(PasswordEncoder passwordEncoder, UserService userService,
                                     ShoppingCartService shoppingCartService) {
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
    }

    @Override
    public User login(String email, String password) throws AuthenticationException {
        User user = userService.findByEmail(email).get();
        if (passwordEncoder.matches(password, user.getPassword())) {
            return user;
        } else {
            throw new AuthenticationException("Incorrect email or password");
        }
    }

    @Override
    public User register(String email, String password, Set<Role> roles) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setRoles(roles);
        User registeredUser = userService.add(user);
        shoppingCartService.registerNewShoppingCart(registeredUser);
        return registeredUser;
    }
}
