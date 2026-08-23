package ir.maktabsharif.repository.Base;

import ir.maktabsharif.model.BaseModel.BaseModel;

import java.util.List;

//crud
//create
//read
//update
//delete
public interface BaseRpository <T extends BaseModel<ID>,ID extends Number>{

    ID create(T t);

    T read(ID id);

    T update(T t);

    ID delete(ID id);

    List<T> findAll();

}
