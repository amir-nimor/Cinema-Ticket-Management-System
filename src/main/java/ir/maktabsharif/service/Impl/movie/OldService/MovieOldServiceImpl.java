package ir.maktabsharif.service.Impl.movie.OldService;

import ir.maktabsharif.model.Movie;
import ir.maktabsharif.repository.Movie.proxy.MovieRepositoryProxyImpl;

public class MovieOldServiceImpl implements MovieOldService<Movie ,Long> {

    private final MovieRepositoryProxyImpl movieRepositoryProxy;

    public MovieOldServiceImpl() {
        this.movieRepositoryProxy = new MovieRepositoryProxyImpl();
    }

    @Override
    public Movie getMovie(Long id ) {
        return movieRepositoryProxy.read(id);
    }
}
