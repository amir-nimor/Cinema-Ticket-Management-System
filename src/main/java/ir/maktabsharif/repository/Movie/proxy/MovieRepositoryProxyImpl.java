package ir.maktabsharif.repository.Movie.proxy;

import ir.maktabsharif.exception.HibernateConnectionException;
import ir.maktabsharif.exception.ProxyOperationException;
import ir.maktabsharif.exception.RepositoryOperationException;
import ir.maktabsharif.model.Movie;
import ir.maktabsharif.repository.Movie.MovieRepository;
import ir.maktabsharif.repository.Movie.MovieRepositoryImpl;
import ir.maktabsharif.util.HibernateUtil;

import java.math.BigDecimal;
import java.util.List;

public class MovieRepositoryProxyImpl implements MovieRepository {

    private MovieRepositoryImpl movieRepository;


    public MovieRepositoryProxyImpl() {
        this.movieRepository = new MovieRepositoryImpl();
    }

    @Override
    public Movie findByTitle(String title) {
        try {
            if (title != null) {
                return movieRepository.findByTitle(title);
            }
        } catch (RepositoryOperationException e) {
            throw new ProxyOperationException("Proxy operation is failed => " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Movie> findAvailable() {
        return movieRepository.findAvailable();
    }

    @Override
    public Long create(Movie movie) {
        try {
            if (movie.getTitle() != null) {
                return movieRepository.create(movie);
            }
        } catch (RepositoryOperationException e) {
            throw new ProxyOperationException("Proxy operation is failed => " + e.getMessage());
        }
        return null;
    }

    @Override
    public Movie read(Long aLong) {
        try {
            Movie movie = movieRepository.read(aLong);
            if (movie != null) {
                return movie;
            }
            return null;
        } catch (RepositoryOperationException e) {
            throw new ProxyOperationException("Proxy operation is failed => " + e.getMessage());
        }
    }

    @Override
    public Movie update(Movie movie) {
        try {
            if (movie.getTitle() != null && movie.getPrice().compareTo(BigDecimal.ZERO) > 0) {
                return movieRepository.update(movie);
            }
        }catch (RepositoryOperationException e){
            throw new ProxyOperationException("Proxy operation is failed => " + e.getMessage());
        }
        return null;
    }

    @Override
    public Long delete(Long aLong) {
        try {
            HibernateUtil.InTxReturn(em -> {
                em.remove(em.find(Movie.class,aLong));
                return aLong;
            });
        }catch (RepositoryOperationException e){
            throw new ProxyOperationException("Proxy operation is failed => " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }
}
