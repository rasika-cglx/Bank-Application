package com.cog.bankapp.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

//-----------------------------------------------------Entity class for accounts of customers-----------------------------------------
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountId;

    @NotNull
    private String accountType;

    @NotNull
    private Double accountBalance;

    @NotNull
    private LocalDate accountCreationDate;

    @NotNull
    private Long accountNumber;

    @NotNull
    private String accountIfscCode;

    @NotNull
    private Integer customerId;
}
