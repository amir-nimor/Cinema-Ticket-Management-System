package ir.maktabsharif.service.Impl.ticket;

import ir.maktabsharif.exception.ValidationException;
import ir.maktabsharif.model.BaseModel.BaseModel;
import ir.maktabsharif.model.Ticket;
import ir.maktabsharif.repository.Base.BaseRepositoryImpl;
import ir.maktabsharif.repository.Base.BaseRpository;
import ir.maktabsharif.repository.Ticket.TicketRepository;
import ir.maktabsharif.repository.Ticket.TicketRepositoryImpl;
import ir.maktabsharif.service.Base.BaseServiceImpl;

public class TicketServiceImpl extends BaseServiceImpl<Ticket, Long, TicketRepository>
        implements TicketService {


    public TicketServiceImpl() {
        super(new TicketRepositoryImpl());
    }

    @Override
    protected void validation(Ticket ticket) throws ValidationException {
        if (ticket.getMovie() == null) throw new ValidationException("ticket movie is empty...");
        if (ticket.getCustomer() == null) throw new ValidationException("ticket customer is empty...");
        if (ticket.getPruchaseDate() == null) throw new ValidationException("ticket Date is empty...");
    }
}
