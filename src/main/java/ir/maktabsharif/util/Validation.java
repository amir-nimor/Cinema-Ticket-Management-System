package ir.maktabsharif.util;

import ir.maktabsharif.exception.ValidationException;

@FunctionalInterface
public interface Validation <T>{
    void validation(T t)throws ValidationException;
}
