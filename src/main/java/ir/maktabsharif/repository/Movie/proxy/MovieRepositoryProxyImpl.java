package ir.maktabsharif.repository.Movie.proxy;

import ir.maktabsharif.model.Movie;
import ir.maktabsharif.repository.Movie.MovieRepository;
import ir.maktabsharif.repository.Movie.MovieRepositoryImpl;

import java.util.List;

public class MovieRepositoryProxyImpl implements MovieRepository {

    private MovieRepositoryImpl movieRepository;


    public MovieRepositoryProxyImpl(){
        this.movieRepository = new MovieRepositoryImpl();
    }

    @Override
    public Movie findByTitle(String title) {

    }

    @Override
    public List<Movie> findAvailable() {
        return List.of();
    }

    @Override
    public Long create(Movie movie) {
        return 0L;
    }

    @Override
    public Movie read(Long aLong) {
        return null;
    }

    @Override
    public Movie update(Movie movie) {
        return null;
    }

    @Override
    public Long delete(Long aLong) {
        return 0L;
    }
}
