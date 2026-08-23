package ir.maktabsharif.service.Impl.ticket.chainOfResponsibility;

import ir.maktabsharif.model.Ticket;

public interface Handler {
    void setNext(Handler next);

    void handel(Ticket ticket);
}
