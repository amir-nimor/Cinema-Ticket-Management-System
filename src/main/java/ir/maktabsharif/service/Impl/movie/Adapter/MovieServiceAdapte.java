package ir.maktabsharif.service.Impl.movie.Adapter;

import ir.maktabsharif.model.Movie;
import ir.maktabsharif.service.Impl.movie.MovieServiceImpl;
import ir.maktabsharif.service.Impl.movie.OldService.MovieOldService;

public class MovieServiceAdapte extends MovieServiceImpl implements MovieOldService<Movie ,Long> {



    private MovieServiceImpl movieService;

    public MovieServiceAdapte(){
        this.movieService = new MovieServiceImpl();
    }

    @Override
    public Movie getMovie(Long aLong) {
        return movieService.findById(aLong);
    }
}
