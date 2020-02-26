package com.luv2code.springdemo.service;

import com.luv2code.springdemo.entity.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> getCustomers();
    Customer getCustomer(int id);
    void saveCustomer(Customer customer);
    void deleteCustomer(int id);
    List<Customer> searchCustomers(String searchName);
}
