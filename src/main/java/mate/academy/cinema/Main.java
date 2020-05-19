package mate.academy.cinema;

import mate.academy.cinema.lib.Injector;
import mate.academy.cinema.model.Movie;
import mate.academy.cinema.service.MovieService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.academy.cinema");

    public static void main(String[] args) {
        MovieService movieService = (MovieService)injector.getInstance(MovieService.class);
        Movie movie = new Movie();
        movie.setTitle("Forrest Gump");
        movieService.add(movie);
        movieService.getAll().forEach(System.out::println);
    }
}
