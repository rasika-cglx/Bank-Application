package com.cog.bankapp.services.imMemory;

import com.cog.bankapp.dto.CustomerListResponse;
import com.cog.bankapp.entity.Customer;
import org.springframework.stereotype.Service;

@Service
public interface CustomerServiceInMemory {

    Customer createUserAccountInMemory(Customer user);

    CustomerListResponse getAllUsers();

    String deleteUser(Integer userId);

    Customer getUserById(Integer userId);
}
