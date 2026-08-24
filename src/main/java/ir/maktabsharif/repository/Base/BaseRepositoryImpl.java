package ir.maktabsharif.repository.Base;

import ir.maktabsharif.exception.EntityNotFound;
import ir.maktabsharif.exception.HibernateConnectionException;
import ir.maktabsharif.exception.RepositoryOperationException;
import ir.maktabsharif.model.BaseModel.BaseModel;
import ir.maktabsharif.util.HibernateUtil;

public abstract class BaseRepositoryImpl<T extends BaseModel<ID>
        , ID extends Number>
        implements BaseRpository<T, ID> {


    private Class<T> entityClass;


    public BaseRepositoryImpl(Class<T> entity) {
        this.entityClass = entity;
    }

    @Override
    public ID create(T t) {
        try {
            return HibernateUtil.InTxReturn(em -> {
                em.persist(t);
                return t.getId();
            });
        } catch (HibernateConnectionException e) {
            throw new RepositoryOperationException("operation save is failed => " + e.getMessage());
        }
    }

    @Override
    public T read(ID id) {
        try {
            return HibernateUtil.read(em -> {
                return em.find(entityClass, id);
            });
        } catch (HibernateConnectionException e) {
            throw new RepositoryOperationException("operation read is failed => " + e.getMessage());
        }
    }

    @Override
    public T update(T t) {
        try {
            return HibernateUtil.InTxReturnWithException(em -> {
                ID id = t.getId();

                T t1 = em.find(entityClass, id);

                if (t1 == null) {
                    throw new EntityNotFound("Entity not founded in database ");
                } else {
                    copyEntity(t, t1);
                    return t;
                }


            });
        } catch (HibernateConnectionException | EntityNotFound e) {
            throw new RepositoryOperationException("operation update is failed => " + e.getMessage());
        }
    }

    @Override
    public ID delete(ID id) {
        try {
            return HibernateUtil.InTxReturn(em -> {
                T find = em.find(entityClass, id);
                if (find != null){
                    em.remove(find);
                    return id;
                }
                return null;
            });
        } catch (HibernateConnectionException e) {
            throw new RepositoryOperationException("operation delete is failed => " + e.getMessage());
        }
    }


    protected abstract void copyEntity(T newEntity, T databaseEntity);
}
