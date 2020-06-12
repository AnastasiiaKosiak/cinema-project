package mate.academy.cinema.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.cinema.model.Movie;
import mate.academy.cinema.model.dto.MovieRequestDto;
import mate.academy.cinema.model.dto.MovieResponseDto;
import mate.academy.cinema.model.mapper.MovieMapper;
import mate.academy.cinema.service.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;
    private final MovieMapper movieMapper;

    public MovieController(MovieService movieService, MovieMapper movieMapper) {
        this.movieService = movieService;
        this.movieMapper = movieMapper;
    }

    @GetMapping
    public List<MovieResponseDto> getAll() {
        return movieService.getAll()
                .stream()
                .map(movieMapper::convertToDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public Movie add(MovieRequestDto requestDto) {
        return movieService.add(movieMapper.convertToMovie(requestDto));
    }
}
