package ir.demo;

import ir.maktabsharif.model.Movie;
import ir.maktabsharif.model.enums.Status;
import ir.maktabsharif.service.Impl.movie.MovieServiceImpl;
import ir.maktabsharif.util.HibernateUtil;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MovieTests {

//
//    @BeforeEach
//    void start(){
//        MovieServiceImpl movieService = new MovieServiceImpl();
//
//        Movie movie1 = new Movie(
//                "Interstellar",
//                new BigDecimal("15.00"),
//                Status.AVAILABLE
//        );
//
//        Movie movie2 = new Movie(
//                "Inception",
//                new BigDecimal("12.00"),
//                Status.AVAILABLE
//        );
//
//        Long id1 = movieService.save(movie1);
//        Long id2 = movieService.save(movie2);
//    }


    @Test
    public void  testSaveAndFindMovie(){

        MovieServiceImpl movieService = new MovieServiceImpl();

        Movie movie1 = new Movie(
                "Interstellar",
                new BigDecimal("15.00"),
                Status.AVAILABLE
        );

        Movie movie2 = new Movie(
                "Inception",
                new BigDecimal("12.00"),
                Status.AVAILABLE
        );

        Long id1 = movieService.save(movie1);
        Long id2 = movieService.save(movie2);


        //assertEquals();

        assertNotNull(id1);
        assertNotNull(id2);
        assertEquals(3L,id1);
        assertEquals(4L,id2);
        assertEquals("Interstellar",movieService.findById(id1).getTitle());
        assertEquals(new BigDecimal("12.00"),movieService.findById(id2).getPrice());
        assertEquals(Status.AVAILABLE,movieService.findById(id2).getStatus());

        HibernateUtil.getEm().close();

    }



    @Test
    public void testFindAvailableMovies(){
        MovieServiceImpl movieService = new MovieServiceImpl();

        Movie movie1 = new Movie(
                "Interstellar12",
                new BigDecimal("15.00"),
                Status.NOT_AVAILABLE
        );

        Movie movie2 = new Movie(
                "Inception45",
                new BigDecimal("12.00"),
                Status.AVAILABLE
        );

        Long id1 = movieService.save(movie1);
        Long id2 = movieService.save(movie2);

        List<Movie> avalaibaleMovie = movieService.findAvailable();

        assertEquals(1,avalaibaleMovie.size());
        assertEquals(Status.AVAILABLE,avalaibaleMovie.getFirst().getStatus());

        System.out.println(avalaibaleMovie);


        Movie movie = movieService.findByTitle("stellar12");
        System.out.println(movie);

    }

}
