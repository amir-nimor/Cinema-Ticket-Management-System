package ir.maktabsharif.repository.Ticket;

import ir.maktabsharif.model.Ticket;
import ir.maktabsharif.repository.Base.BaseRepositoryImpl;

public class TicketRepositoryImpl extends BaseRepositoryImpl<Ticket,Long> implements TicketRepository {

    public TicketRepositoryImpl( ) {
        super(Ticket.class);
    }

    @Override
    protected void copyEntity(Ticket newEntity, Ticket databaseEntity) {
        if (newEntity.getCustomer() != null) databaseEntity.setCustomer(newEntity.getCustomer());
        if (newEntity.getMovie() != null) databaseEntity.setMovie(newEntity.getMovie());
        if (newEntity.getPruchaseDate() != null) databaseEntity.setPruchaseDate(newEntity.getPruchaseDate());
    }
}
