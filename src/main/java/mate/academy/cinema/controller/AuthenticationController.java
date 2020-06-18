package mate.academy.cinema.controller;

import java.util.Set;
import javax.validation.Valid;
import mate.academy.cinema.model.dto.UserRequestDto;
import mate.academy.cinema.security.AuthenticationService;
import mate.academy.cinema.service.RoleService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final RoleService roleService;

    public AuthenticationController(AuthenticationService authenticationService,
                                    RoleService roleService) {
        this.authenticationService = authenticationService;
        this.roleService = roleService;
    }

    @PostMapping("/registration")
    public void register(@RequestBody @Valid UserRequestDto requestDto) {
        authenticationService.register(requestDto.getEmail(),
                requestDto.getPassword(), Set.of(roleService.getRoleByName("USER")));
    }
}
