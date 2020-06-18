package mate.academy.cinema.controller;

import java.util.Set;
import javax.annotation.PostConstruct;
import mate.academy.cinema.model.Role;
import mate.academy.cinema.security.AuthenticationService;
import mate.academy.cinema.service.RoleService;
import org.springframework.stereotype.Component;

@Component
public class InjectDataController {
    private final RoleService roleService;
    private final AuthenticationService authService;

    public InjectDataController(RoleService roleService, AuthenticationService authService) {
        this.roleService = roleService;
        this.authService = authService;
    }

    @PostConstruct
    public void injectDatabase() {
        Role user = Role.of("USER");
        roleService.add(user);
        Role admin = Role.of("ADMIN");
        roleService.add(admin);
        authService.register("mymail@gmail.com", "123", Set.of(admin));
    }
}
