package ir.maktabsharif.repository.Movie;

import ir.maktabsharif.model.Movie;
import ir.maktabsharif.repository.Base.BaseRpository;

import javax.swing.*;
import java.util.List;

public interface MovieRepository extends BaseRpository<Movie,Long> {
    Movie findByTitle(String title);
    List<Movie> findAvailable();
}
