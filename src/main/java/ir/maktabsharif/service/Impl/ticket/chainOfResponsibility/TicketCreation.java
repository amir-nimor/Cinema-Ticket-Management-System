package ir.maktabsharif.service.Impl.ticket.chainOfResponsibility;

import ir.maktabsharif.model.Ticket;
import ir.maktabsharif.service.Impl.ticket.TicketServiceImpl;

public class TicketCreation implements Handler {


    private Handler handler;


    @Override
    public void setNext(Handler next) {
        this.handler = next;
    }

    @Override
    public void handel(Ticket ticket) {
        if (ticket.getPruchaseDate() != null && handler != null){
            handler.handel(ticket);
        }else {
            System.out.println("your ticket is not have a date");
        }
    }
}
