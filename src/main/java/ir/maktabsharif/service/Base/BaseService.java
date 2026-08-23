package ir.maktabsharif.service.Base;

import ir.maktabsharif.model.BaseModel.BaseModel;

import java.util.List;

public interface BaseService <T extends BaseModel<ID> , ID extends Number>{
    ID save(T t);

    ID delete(ID id);

    T update(T t);

    T findById(ID id);

    List<T> findAll();
}
