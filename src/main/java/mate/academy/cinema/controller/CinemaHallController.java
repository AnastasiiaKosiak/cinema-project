package mate.academy.cinema.controller;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import mate.academy.cinema.mapper.CinemaHallMapper;
import mate.academy.cinema.model.CinemaHall;
import mate.academy.cinema.model.dto.CinemaHallRequestDto;
import mate.academy.cinema.model.dto.CinemaHallResponseDto;
import mate.academy.cinema.service.CinemaHallService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cinema-halls")
public class CinemaHallController {
    private final CinemaHallMapper cinemaHallMapper;
    private final CinemaHallService cinemaHallService;

    public CinemaHallController(CinemaHallMapper cinemaHallMapper,
                                CinemaHallService cinemaHallService) {
        this.cinemaHallMapper = cinemaHallMapper;
        this.cinemaHallService = cinemaHallService;
    }

    @PostMapping
    public CinemaHall add(@RequestBody @Valid CinemaHallRequestDto requestDto) {
        return cinemaHallService.add(cinemaHallMapper.convertToCinemaHall(requestDto));
    }

    @GetMapping
    public List<CinemaHallResponseDto> getAll() {
        return cinemaHallService.getAll()
                .stream()
                .map(cinemaHallMapper::convertToDto)
                .collect(Collectors.toList());
    }
}
