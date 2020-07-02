package mate.academy.cinema.mapper;

import mate.academy.cinema.model.Order;
import mate.academy.cinema.model.dto.OrderResponseDto;
import mate.academy.cinema.service.ShoppingCartService;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    private final ShoppingCartService shoppingCartService;

    public OrderMapper(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    public OrderResponseDto convertToDto(Order order) {
        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setShoppingCartId(shoppingCartService.getByUser(order.getUser()).getId());
        orderResponseDto.setUserId(order.getUser().getId());
        orderResponseDto.setDate(order.getOrderDate());
        return orderResponseDto;
    }
}
