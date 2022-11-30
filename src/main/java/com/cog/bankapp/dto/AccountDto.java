package com.cog.bankapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AccountDto {
    private String accountNumber;
    private String accountIfscCode;
    private String accountType;
    private String accountBalance;
    private String customerId;

}
