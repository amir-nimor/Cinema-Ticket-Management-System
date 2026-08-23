package ir.maktabsharif.service.Base;

import ir.maktabsharif.exception.BuisinesException;
import ir.maktabsharif.exception.EntityNotFound;
import ir.maktabsharif.exception.RepositoryOperationException;
import ir.maktabsharif.exception.ValidationException;
import ir.maktabsharif.model.BaseModel.BaseModel;
import ir.maktabsharif.repository.Base.BaseRpository;

import java.util.List;

public abstract class BaseServiceImpl<T extends BaseModel<ID>,
        ID extends Number,
        R extends BaseRpository<T, ID>>
        implements BaseService<T, ID> {

    private R repository;


    public BaseServiceImpl(R repository){
        this.repository = repository;
    }

    protected abstract void validation(T t)throws ValidationException;



    @Override
    public ID save(T t) {
        try {
            validation(t);
            return repository.create(t);
        }catch (ValidationException e ){
            throw new BuisinesException("your save operation is failed => "+e.getMessage());
        }
    }

    @Override
    public ID delete(ID id) {
        try {
            ID id1 = repository.delete(id);
            if (id1 != null){
                return id1;
            }
            throw new EntityNotFound("Entity not found in database ");
        }catch (EntityNotFound | RepositoryOperationException e){
            throw new BuisinesException(" delete operation is failed => "+e.getMessage());
        }
    }

    @Override
    public T update(T t) {
        try {
            validation(t);
            return repository.update(t);
        }catch (ValidationException | RepositoryOperationException e){
            throw new BuisinesException(" update operation is failed => "+e.getMessage());
        }
    }

    @Override
    public T findById(ID id) {
        try {
            T t = repository.read(id);
            if (t != null){
                return t;
            }
            throw new EntityNotFound("Entity not found in db for read => ");
        }catch (EntityNotFound | RepositoryOperationException e){
            throw new BuisinesException(" find by id operation is failed => "+e.getMessage());
        }
    }

    @Override
    public List<T> findAll() {
        try {
            return repository.findAll();
        }catch (RuntimeException e){
            throw new BuisinesException(" find All operation is failed => "+e.getMessage());
        }
    }
}
