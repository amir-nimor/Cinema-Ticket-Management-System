package ir.maktabsharif.service.Impl.movie;

import ir.maktabsharif.model.Movie;
import ir.maktabsharif.service.Base.BaseService;

import java.util.List;

public interface MovieService extends BaseService<Movie,Long> {
    Movie findByTitle(String title);

    List<Movie> findAvailable();

    List<Movie> findAll();
}
