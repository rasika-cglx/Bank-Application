package com.cog.bankapp.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class AccountCreationRequest {
    private Integer customerId;

    private String accountType;

    private Double initialDepositAmount;
}
