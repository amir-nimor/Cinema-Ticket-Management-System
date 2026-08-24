package ir.maktabsharif.service.Impl.ticket.chainOfResponsibility;

import ir.maktabsharif.model.Ticket;
import ir.maktabsharif.model.enums.Status;

public class MovieAvailabilityHandler implements Handler{


    private Handler nextHandler;


    @Override
    public void setNext(Handler next) {
        this.nextHandler = next;
    }

    @Override
    public void handel(Ticket ticket) {
        if (ticket.getMovie().getStatus() == Status.AVAILABLE && nextHandler != null){
            nextHandler.handel(ticket);
        }else {
            System.out.println("your movie status is NOT_AVAILABLE ");
        }
    }
}
