package com.cog.bankapp.dto;

import com.cog.bankapp.entity.Customer;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class CustomerListResponse {
    private Integer totalElements;

    private List<Customer> userList;
}
