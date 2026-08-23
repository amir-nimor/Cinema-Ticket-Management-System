package ir.maktabsharif.service.Impl.customer;

import ir.maktabsharif.exception.ValidationException;
import ir.maktabsharif.model.Customer;
import ir.maktabsharif.repository.Customer.CustomerRepository;
import ir.maktabsharif.repository.Customer.CustomerRepositoryImpl;
import ir.maktabsharif.service.Base.BaseServiceImpl;

public class CustomerServiceImpl extends BaseServiceImpl<Customer,Long, CustomerRepository> implements CustomerService {


    public CustomerServiceImpl(){
        super(new CustomerRepositoryImpl());
    }

    @Override
    protected void validation(Customer customer) throws ValidationException {
        if (customer.getName() == null || customer.getName().isBlank())throw new ValidationException("customer name is empty...");
        if (customer.getEmail() == null || customer.getEmail().isBlank() )throw new ValidationException("customer email is empty...");



    }
}
