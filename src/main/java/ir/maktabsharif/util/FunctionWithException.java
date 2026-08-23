package ir.maktabsharif.util;

import ir.maktabsharif.exception.EntityNotFound;
import ir.maktabsharif.model.BaseModel.BaseModel;

@FunctionalInterface
public interface FunctionWithException<T,R> {
    R apply(T t) throws EntityNotFound;
}
