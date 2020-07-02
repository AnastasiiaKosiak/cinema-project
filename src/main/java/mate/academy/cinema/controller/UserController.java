package mate.academy.cinema.controller;

import mate.academy.cinema.mapper.UserMapper;
import mate.academy.cinema.model.dto.UserResponseDto;
import mate.academy.cinema.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping("/byemail")
    public UserResponseDto getUser(@RequestParam String email) {
        return userMapper.convertToDto(userService.findByEmail(email).get());
    }
}
