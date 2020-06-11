package mate.academy.cinema.controller;

import mate.academy.cinema.model.dto.ShoppingCartResponseDto;
import mate.academy.cinema.model.mapper.ShoppingCartMapper;
import mate.academy.cinema.service.MovieSessionService;
import mate.academy.cinema.service.ShoppingCartService;
import mate.academy.cinema.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping_carts")
public class ShoppingCartController {
    private final MovieSessionService movieSessionService;
    private final ShoppingCartService shoppingCartService;
    private final UserService userService;
    private final ShoppingCartMapper shoppingCartMapper;

    public ShoppingCartController(MovieSessionService movieSessionService,
                                  ShoppingCartService shoppingCartService,
                                  UserService userService,
                                  ShoppingCartMapper shoppingCartMapper) {
        this.movieSessionService = movieSessionService;
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
        this.shoppingCartMapper = shoppingCartMapper;
    }

    @PostMapping
    public void addMovieSession(@RequestParam Long userId, @RequestParam Long sessionId) {
        shoppingCartService.addSession(movieSessionService.getById(sessionId),
                userService.getById(userId));
    }

    @GetMapping("/byuser")
    public ShoppingCartResponseDto getShoppingCart(@RequestParam Long userId) {
        return shoppingCartMapper
                .convertToDto(shoppingCartService.getByUser(userService.getById(userId)));
    }
}
