package ir.maktabsharif.util;

import ir.maktabsharif.exception.EntityNotFound;
import ir.maktabsharif.exception.HibernateConnectionException;
import jakarta.persistence.*;

import java.util.function.Function;

public class HibernateUtil {

    private static final String PERSISTENCE_UNIT = "Cinema-Ticket";


    private static EntityManagerFactory emf;


    //singleton pattern
    private static EntityManagerFactory getEmf() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        }
        return emf;
    }


    public static EntityManager getEm() {
        return getEmf().createEntityManager();
    }

    public static <T> T InTxReturn(Function<EntityManager, T> operation) {
        EntityManager entityManager = getEm();
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();

            T result = operation.apply(entityManager);
            tx.commit();
            return result;
        } catch (PersistenceException e) {
            tx.rollback();
            throw new HibernateConnectionException("connection failed => " + e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    public static <T> T read(Function<EntityManager, T> operation) {
        try {
            return operation.apply(getEm());
        } catch (RuntimeException e) {
            throw new HibernateConnectionException("connection failed => " + e.getMessage());
        }
    }


    public static <T> T InTxReturnWithException(FunctionWithException<EntityManager, T> operation) throws EntityNotFound {
        EntityManager entityManager = getEm();
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();

            T result = operation.apply(entityManager);
            tx.commit();
            return result;
        } catch (PersistenceException e) {
            tx.rollback();
            throw new HibernateConnectionException("connection failed => " + e.getMessage());
        } finally {
            entityManager.close();
        }
    }


}
