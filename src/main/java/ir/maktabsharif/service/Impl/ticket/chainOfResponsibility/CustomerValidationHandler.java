package ir.maktabsharif.service.Impl.ticket.chainOfResponsibility;

import ir.maktabsharif.model.Ticket;
import ir.maktabsharif.repository.Customer.CustomerRepositoryImpl;

public class CustomerValidationHandler implements Handler{


    private Handler nextHandler;

    @Override
    public void setNext(Handler next) {
        this.nextHandler = next;
    }

    @Override
    public void handel(Ticket ticket) {
        Long customerID = new CustomerRepositoryImpl().read(ticket.getCustomer().getId()).getId();

        if (customerID != null){
            setNext(nextHandler);
        }else {
            System.out.println("your ticket customer id not founded");
        }
    }
}
