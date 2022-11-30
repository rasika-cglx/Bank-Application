package com.cog.bankapp.services;

import com.cog.bankapp.dao.CustomerDao;
import com.cog.bankapp.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerServices {
    @Autowired
    private CustomerDao customerDao;

    //----------------------------------------------------Get all customers details--------------------------------------------------------
    @Override
    public List<Customer> getCustomers() {
        return customerDao.findAll();
    }

    //--------------------------------------------------Create new customer to database---------------------------------------------------
    public Customer createCustomer(Customer customer) {
        return customerDao.save(customer);
    }

    //----------------------------------------------------Get customer details by ID--------------------------------------------------------
    public Customer getCustomerById(Long customerId) {
        Optional<Customer> optionalCustomer = customerDao.findById(customerId);
        return optionalCustomer.get();
    }

    //----------------------------------------------------Delete customer By ID--------------------------------------------------------
    public void deleteCustomerById(Long customerId) {
        customerDao.deleteById(customerId);
    }

    //----------------------------------------------------Update customer details by ID--------------------------------------------------------
    public Customer updateCustomerById(Customer customer, Long customerId) {
        Optional<Customer> c = customerDao.findById(customerId);
        return customerDao.save(customer);
    }

}
