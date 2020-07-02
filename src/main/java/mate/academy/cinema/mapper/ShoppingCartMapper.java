package mate.academy.cinema.mapper;

import java.util.stream.Collectors;
import mate.academy.cinema.model.ShoppingCart;
import mate.academy.cinema.model.dto.ShoppingCartResponseDto;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartMapper {
    private final TicketMapper ticketMapper;

    public ShoppingCartMapper(TicketMapper ticketMapper) {
        this.ticketMapper = ticketMapper;
    }

    public ShoppingCartResponseDto convertToDto(ShoppingCart shoppingCart) {
        ShoppingCartResponseDto shoppingCartResponseDto = new ShoppingCartResponseDto();
        shoppingCartResponseDto.setUserId(shoppingCart.getUser().getId());
        shoppingCartResponseDto.setTickets(shoppingCart.getTickets()
                .stream()
                .map(ticketMapper::convertToDto)
                .collect(Collectors.toList()));
        return shoppingCartResponseDto;
    }
}
