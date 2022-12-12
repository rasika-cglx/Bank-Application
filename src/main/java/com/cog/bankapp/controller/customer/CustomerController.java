package com.cog.bankapp.controller.customer;

import com.cog.bankapp.entity.Customer;
import com.cog.bankapp.services.customer.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerController {

    List<Customer> customerList = new ArrayList<>();
    @Autowired
    private CustomerServices customerServices;

    //----------------------------------------------------Get all customers details--------------------------------------------------------
    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getCustomers() {
        try {
            customerList = customerServices.getCustomers();
            return new ResponseEntity<List<Customer>>(customerList, HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<List<Customer>>(customerList, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //--------------------------------------------------Create new customer to database---------------------------------------------------
    @PostMapping("/createCustomer")
    public ResponseEntity<Object> createCustomer(@RequestBody Customer customer) {
        try {
            Customer customer1 = customerServices.createCustomer(customer);
            return new ResponseEntity<>(customer1, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //----------------------------------------------------Get customer details by ID--------------------------------------------------------
    @GetMapping("/getCustomerById/{customerId}")
    public ResponseEntity<Object> getCustomerById(@PathVariable Long customerId) {
        try {
            Customer customer = customerServices.getCustomerById(customerId);
            return new ResponseEntity<>(customer, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //----------------------------------------------------Delete customer By ID--------------------------------------------------------
    @DeleteMapping("/deleteCustomerById/{customerId}")
    public ResponseEntity<Object> deleteCustomerById(@PathVariable Long customerId) {
        try {
            customerServices.deleteCustomerById(customerId);
            return new ResponseEntity<>(" Customer deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //----------------------------------------------------Update customer details by ID--------------------------------------------------------
    @PutMapping("/updateCustomerById/{customerId}")
    public ResponseEntity<Object> updateCustomerById(@RequestBody Customer customer, @PathVariable Long customerId) {
        try {
            customerServices.updateCustomerById(customer, customerId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
