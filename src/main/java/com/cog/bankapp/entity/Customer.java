package com.cog.bankapp.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//----------------------------------------------------Entity class for customers---------------------------------------------------
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @NotNull
    private String customerName;

    @NotNull
    private String customerMobile;

    @NotNull
    private String customerAddress;

    @NotNull
    private String customerEmail;

    @NotNull
    private String customerAadhar;

    @NotNull
    private String customerPan;

    @NotNull
    private String customerAge;

    @NotNull
    private String customerDob;
}
