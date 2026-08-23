package ir.maktabsharif.repository.Customer;

import ir.maktabsharif.model.Customer;
import ir.maktabsharif.repository.Base.BaseRepositoryImpl;
import ir.maktabsharif.util.HibernateUtil;

import java.util.List;

public class CustomerRepositoryImpl extends BaseRepositoryImpl<Customer,Long> implements CustomerRepository {

    public CustomerRepositoryImpl() {
        super(Customer.class);
    }

    @Override
    protected void copyEntity(Customer newEntity, Customer databaseEntity) {
        if (newEntity.getEmail() != null) databaseEntity.setEmail(newEntity.getEmail());
        if (newEntity.getName() != null) databaseEntity.setName(newEntity.getName());
    }

    @Override
    public List<Customer> findAll() {
        return HibernateUtil.read(em -> {
            return em.createQuery("SELECT c FROM Customer c")
                    .getResultList();
        });
    }
}
