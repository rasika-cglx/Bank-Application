package com.cog.bankapp.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//-----------------------------------------------------Entity class for accounts of customers-----------------------------------------
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    @NotNull
    private String accountType;

    @NotNull
    private String accountBalance;

    @NotNull
    private String accountNumber;

    @NotNull
    private String accountIfscCode;

    @NotNull
    private Long customerId;
}
