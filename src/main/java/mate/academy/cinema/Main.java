package mate.academy.cinema;

import java.time.LocalDateTime;
import mate.academy.cinema.lib.Injector;
import mate.academy.cinema.model.CinemaHall;
import mate.academy.cinema.model.Movie;
import mate.academy.cinema.model.MovieSession;
import mate.academy.cinema.model.User;
import mate.academy.cinema.security.AuthenticationService;
import mate.academy.cinema.security.AuthenticationServiceImpl;
import mate.academy.cinema.service.CinemaHallService;
import mate.academy.cinema.service.MovieService;
import mate.academy.cinema.service.MovieSessionService;
import mate.academy.cinema.service.ShoppingCartService;
import mate.academy.cinema.service.UserService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.academy.cinema");

    public static void main(String[] args) {
        MovieService movieService = (MovieService)injector.getInstance(MovieService.class);
        Movie movie = new Movie();
        movie.setTitle("Forrest Gump");
        movieService.add(movie);
        movieService.getAll().forEach(System.out::println);
        CinemaHallService cinemaHallService =
                (CinemaHallService)injector.getInstance(CinemaHallService.class);
        CinemaHall cinemaHall = new CinemaHall(100);
        cinemaHallService.add(cinemaHall);
        cinemaHallService.getAll().forEach(System.out::println);
        MovieSessionService movieSessionService =
                (MovieSessionService) injector.getInstance(MovieSessionService.class);
        MovieSession movieSession = new MovieSession();
        movieSessionService.add(movieSession);
        movieSessionService.findAvailableSessions(movie.getId(), LocalDateTime.now().toLocalDate())
                .forEach(System.out::println);
        UserService userService = (UserService) injector.getInstance(UserService.class);
        AuthenticationService authenticationService = new AuthenticationServiceImpl();
        authenticationService.register("ccc", "123");
        System.out.println(userService.findByEmail("ccc"));
        ShoppingCartService shoppingCartService =
                (ShoppingCartService)injector.getInstance(ShoppingCartService.class);
        User user = userService.findByEmail("ccc").get();
        shoppingCartService.addSession(movieSession, user);
        System.out.println(shoppingCartService.getByUser(user));
    }
}
