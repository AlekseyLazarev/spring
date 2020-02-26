package com.luv2code.springdemo.dao;

import com.luv2code.springdemo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAO implements ICustomerDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {
        Session session = this.sessionFactory.getCurrentSession();
        Query<Customer> theQuery = session.createQuery("from Customer order by last_name", Customer.class);
        return theQuery.getResultList();
    }

    @Override
    public Customer getCustomer(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        return session.get(Customer.class, id);
    }

    @Override
    public void saveCustomer(Customer customer) {
        this.sessionFactory.getCurrentSession().saveOrUpdate(customer);
    }

    @Override
    public void deleteCustomer(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from Customer where id=:customerId");
        query.setParameter("customerId", id);
        query.executeUpdate();
    }

    @Override
    public List<Customer> searchCustomers(String searchName) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query theQuery = null;
        if (searchName != null && searchName.trim().length() > 0) {
            theQuery =currentSession.createQuery("from Customer where lower(firstName) like :theName or lower(lastName) like :theName", Customer.class);
            theQuery.setParameter("theName", "%" + searchName.toLowerCase() + "%");
        }
        else {
            theQuery =currentSession.createQuery("from Customer", Customer.class);
        }
        List<Customer> customers = theQuery.getResultList();
        return customers;
    }
}
