package mate.academy.cinema.dao;

import java.time.LocalDate;
import java.util.List;
import mate.academy.cinema.model.MovieSession;

public interface MovieSessionDao {
    List<MovieSession> findAvailableSessions(Long movieId, LocalDate date);

    MovieSession add(MovieSession session);

    MovieSession getById(Long id);
}
