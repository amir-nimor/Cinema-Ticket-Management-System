package ir.maktabsharif.service.Impl.ticket.chainOfResponsibility;

import ir.maktabsharif.model.Ticket;
import ir.maktabsharif.repository.Customer.CustomerRepositoryImpl;
import ir.maktabsharif.service.Impl.ticket.TicketServiceImpl;

public class CustomerValidationHandler implements Handler{


    private Handler nextHandler;

    private TicketServiceImpl ticketService = new TicketServiceImpl();

    @Override
    public void setNext(Handler next) {
        this.nextHandler = next;
    }

    @Override
    public void handel(Ticket ticket) {

        if (ticket.getCustomer().getName() != null && nextHandler == null){
            ticketService.save(ticket);
        }else {
            System.out.println("your ticket customer name not founded");
        }
    }
}
