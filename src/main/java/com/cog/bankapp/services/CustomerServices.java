package com.cog.bankapp.services;

import com.cog.bankapp.entity.Customer;

import java.util.List;

public interface CustomerServices {

    public List<Customer> getCustomers();

    public Customer createCustomer(Customer customer);

    public Customer getCustomerById(Long customerId);

    public void deleteCustomerById(Long customerId);

    public Customer updateCustomerById(Customer customer, Long customerId);
}
