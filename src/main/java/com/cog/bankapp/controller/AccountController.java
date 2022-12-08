package com.cog.bankapp.controller;

import com.cog.bankapp.entity.Account;
import com.cog.bankapp.services.AccountServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AccountController {

    List<Account> accountList = new ArrayList<>();

    @Autowired
    private AccountServices accountServices;

    //----------------------------------------------------Get all customers details--------------------------------------------------------
    @GetMapping("/accounts")
    public ResponseEntity<List<Account>> getAccounts() {
        try {
            accountList = accountServices.getAccounts();
            return new ResponseEntity<>(accountList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //--------------------------------------------------Create new account to database---------------------------------------------------
    @PostMapping("/createAccount")
    public ResponseEntity<Object> createAccount(@RequestBody Account account) {
        try {
            Account a = accountServices.createAccount(account);
            return new ResponseEntity<>(a, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
