package mate.academy.cinema.model.mapper;

import mate.academy.cinema.model.Ticket;
import mate.academy.cinema.model.dto.TicketResponseDto;
import org.springframework.stereotype.Component;

@Component
public class TicketMapper {
    public TicketResponseDto convertToDto(Ticket ticket) {
        TicketResponseDto ticketResponseDto = new TicketResponseDto();
        ticketResponseDto.setTitle(ticket.getMovieSession().getMovie().getTitle());
        ticketResponseDto.setShowTime(ticket.getMovieSession().getShowTime());
        return ticketResponseDto;
    }
}
