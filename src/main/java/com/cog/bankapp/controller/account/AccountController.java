package com.cog.bankapp.controller.account;

import com.cog.bankapp.dto.AccountCreationResponse;
import com.cog.bankapp.entity.Account;
import com.cog.bankapp.services.accounts.AccountServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    List<Account> accountList = new ArrayList<>();

    @Autowired
    private AccountServices accountServices;

    //----------------------------------------------------Get all customers details--------------------------------------------------------
//    @GetMapping("/accounts")
//    public ResponseEntity<List<Account>> getAccounts() {
//        try {
//            accountList = accountServices.getAccounts();
//            return new ResponseEntity<>(accountList, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    //--------------------------------------------------Create new account to database---------------------------------------------------
    @RequestMapping(path = "/createAccount/{customer_id}", method = RequestMethod.POST)
    public  ResponseEntity<Object> createAccount(@PathVariable Long customer_id, @RequestBody Account account){
        try {
            AccountCreationResponse accountCreationResponse = accountServices.createAccount(customer_id, account);
            return new ResponseEntity<>(accountCreationResponse, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


//    @PostMapping("/createAccount")
//    public ResponseEntity<Object> createAccount(@RequestBody Account account) {
//        try {
//            Account a = accountServices.createAccount(account);
//            return new ResponseEntity<>(a, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
}
