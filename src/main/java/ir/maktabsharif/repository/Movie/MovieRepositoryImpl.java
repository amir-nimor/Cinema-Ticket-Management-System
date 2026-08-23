package ir.maktabsharif.repository.Movie;

import ir.maktabsharif.exception.HibernateConnectionException;
import ir.maktabsharif.exception.RepositoryOperationException;
import ir.maktabsharif.model.Movie;
import ir.maktabsharif.repository.Base.BaseRepositoryImpl;
import ir.maktabsharif.util.HibernateUtil;

import java.math.BigDecimal;
import java.util.List;

public class MovieRepositoryImpl extends BaseRepositoryImpl<Movie, Long> implements MovieRepository {

    public MovieRepositoryImpl() {
        super(Movie.class);
    }

    @Override
    public Movie findByTitle(String title) {
        try {
            return HibernateUtil.read(em -> {
                return em.createNamedQuery("findMovieByTitle", Movie.class)
                        .setParameter("nameTitel", title)
                        .getSingleResult();
            });
        } catch (HibernateConnectionException e) {
            throw new RepositoryOperationException("operation find by title is failed => " + e.getMessage());
        }
    }

    @Override
    public List<Movie> findAvailable() {
        try {
            return HibernateUtil.read(em -> {
                return em.createNamedQuery("findAvailableMovies", Movie.class)
                        .getResultList();
            });
        }catch (HibernateConnectionException e){
            throw new RepositoryOperationException("operation find by Status is failed => " + e.getMessage());
        }
    }

    @Override
    protected void copyEntity(Movie newEntity, Movie databaseEntity) {
        if (newEntity.getPrice().compareTo(BigDecimal.ZERO) > 0) databaseEntity.setPrice(newEntity.getPrice());
        if (newEntity.getStatus() != null) databaseEntity.setStatus(newEntity.getStatus());
        if (newEntity.getTitle() != null) databaseEntity.setTitle(newEntity.getTitle());
    }

    @Override
    public List<Movie> findAll() {
        return HibernateUtil.read(em -> {
            return em.createQuery("SELECT m FROM Movie m")
                    .getResultList();
        });
    }
}
