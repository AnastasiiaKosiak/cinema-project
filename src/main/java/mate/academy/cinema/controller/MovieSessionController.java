package mate.academy.cinema.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import mate.academy.cinema.mapper.MovieSessionMapper;
import mate.academy.cinema.model.MovieSession;
import mate.academy.cinema.model.dto.MovieSessionRequestDto;
import mate.academy.cinema.model.dto.MovieSessionResponseDto;
import mate.academy.cinema.service.MovieSessionService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie-sessions")
public class MovieSessionController {
    private final MovieSessionService movieSessionService;
    private final MovieSessionMapper movieSessionMapper;

    public MovieSessionController(MovieSessionService movieSessionService,
                                  MovieSessionMapper movieSessionMapper) {
        this.movieSessionService = movieSessionService;
        this.movieSessionMapper = movieSessionMapper;
    }

    @GetMapping("/available")
    public List<MovieSessionResponseDto> getAll(@RequestParam Long id,
                                     @RequestParam("date") @DateTimeFormat(iso =
                                             DateTimeFormat.ISO.DATE)LocalDate date) {
        return movieSessionService.findAvailableSessions(id, date)
                .stream()
                .map(movieSessionMapper::convertToDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public MovieSession add(@RequestBody @Valid MovieSessionRequestDto requestDto) {
        return movieSessionService.add(movieSessionMapper.convertToMovieSession(requestDto));
    }
}
