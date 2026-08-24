package ir.maktabsharif.service.Impl.movie;

import ir.maktabsharif.exception.ValidationException;
import ir.maktabsharif.model.Movie;
import ir.maktabsharif.repository.Movie.MovieRepository;
import ir.maktabsharif.repository.Movie.proxy.MovieRepositoryProxyImpl;
import ir.maktabsharif.service.Base.BaseServiceImpl;

import java.math.BigDecimal;
import java.util.List;

public class MovieServiceImpl extends BaseServiceImpl<Movie,Long, MovieRepository> implements MovieService {


    MovieRepositoryProxyImpl movieRepositoryProxy = new MovieRepositoryProxyImpl();

    //proxy
    public MovieServiceImpl() {

        super(new MovieRepositoryProxyImpl());
    }


    @Override
    protected void validation(Movie movie) throws ValidationException {
        if (movie.getTitle() == null || movie.getTitle().isBlank())throw new ValidationException("movie title is empty...");
        if (movie.getStatus() == null)throw new ValidationException("movie status is empty...");
        if (movie.getPrice().compareTo(BigDecimal.ZERO) < 0)throw new ValidationException("movie price is negative...");
    }

    @Override
    public Movie findByTitle(String title) {
        return movieRepositoryProxy.findByTitle(title);
    }

    @Override
    public List<Movie> findAvailable() {
        return movieRepositoryProxy.findAvailable();
    }
}
