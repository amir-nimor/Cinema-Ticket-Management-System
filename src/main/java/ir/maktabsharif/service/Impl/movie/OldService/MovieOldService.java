package ir.maktabsharif.service.Impl.movie.OldService;

import ir.maktabsharif.model.BaseModel.BaseModel;

public interface MovieOldService <T extends BaseModel<ID> ,ID extends Number>{

    T getMovie(ID id);
}
