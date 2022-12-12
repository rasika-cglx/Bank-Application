package com.cog.bankapp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountCreationResponse {
    private Long generatedAccountNumber;
    private Boolean success = false;
    private String message = "Bank account creation failed.";
}
