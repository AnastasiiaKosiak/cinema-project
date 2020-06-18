package mate.academy.cinema.security;

import mate.academy.cinema.model.User;
import mate.academy.cinema.service.UserService;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserService userService;

    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userService.findByEmail(email).get();
        UserBuilder userBuilder = org.springframework.security.core.userdetails
                .User.withUsername(user.getEmail());
        userBuilder.roles(user.getRoles()
                .stream().map(r -> r.getRoleName().name())
                .toArray(String[]::new));
        userBuilder.password(user.getPassword());
        return userBuilder.build();
    }
}
