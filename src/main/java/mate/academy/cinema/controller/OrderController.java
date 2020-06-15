package mate.academy.cinema.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.cinema.model.User;
import mate.academy.cinema.model.dto.OrderResponseDto;
import mate.academy.cinema.model.mapper.OrderMapper;
import mate.academy.cinema.service.OrderService;
import mate.academy.cinema.service.ShoppingCartService;
import mate.academy.cinema.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final UserService userService;
    private final OrderService orderService;
    private final ShoppingCartService shoppingCartService;
    private final OrderMapper orderMapper;

    public OrderController(UserService userService,
                           OrderService orderService,
                           ShoppingCartService shoppingCartService,
                           OrderMapper orderMapper) {
        this.userService = userService;
        this.orderService = orderService;
        this.shoppingCartService = shoppingCartService;
        this.orderMapper = orderMapper;
    }

    @PostMapping
    public void completeOrder(Authentication authentication) {
        User user = userService
                .findByEmail(((UserDetails)authentication.getPrincipal())
                        .getUsername()).get();
        orderService.completeOrder(shoppingCartService.getByUser(user).getTickets(), user);
    }

    @GetMapping
    public List<OrderResponseDto> getOrdersHistory(Authentication authentication) {
        User user = userService
                .findByEmail(((UserDetails)authentication.getPrincipal()).getUsername()).get();
        return orderService.getOrderHistory(user)
                .stream()
                .map(orderMapper::convertToDto)
                .collect(Collectors.toList());
    }
}
