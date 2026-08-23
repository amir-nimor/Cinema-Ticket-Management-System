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
        if (ticket.getMovie().getStatus().equals(Status.AVAILABLE)){
            setNext(nextHandler);
        }else {
            System.out.println("your movie status is NOT_AVAILABLE ");
        }
    }
}
