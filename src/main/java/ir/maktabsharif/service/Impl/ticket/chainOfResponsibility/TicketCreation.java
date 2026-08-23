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
        Long id = new TicketServiceImpl().save(ticket);
        System.out.println("your ticket => "+ticket+"  add successfully");
        System.out.println("your ticket id is  => "+id);
    }
}
