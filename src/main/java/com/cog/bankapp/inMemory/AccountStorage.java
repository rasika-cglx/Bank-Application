package com.cog.bankapp.inMemory;

import com.cog.bankapp.dto.AccountCreationRequest;
import com.cog.bankapp.dto.AccountCreationResponse;
import com.cog.bankapp.dto.AmountRequest;
import com.cog.bankapp.entity.Account;
import com.cog.bankapp.entity.Customer;
import com.cog.bankapp.services.imMemory.CustomerServiceInMemory;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class AccountStorage {
    List<Account> bankAccounts = new ArrayList<>();
    @Autowired
    private CustomerServiceInMemory customerServiceInMemory;

    public Account createAccount(AccountCreationRequest accountCreationRequest){
        Account bankAccount = new Account();
        Customer user;
        user = customerServiceInMemory.getUserById(accountCreationRequest.getCustomerId());
        Long account_number = 100000000000L;
        Integer bank_id = bankAccounts.size() + 1;
        bankAccount.setAccountId(bank_id);
        bankAccount.setAccountNumber(account_number + bankAccounts.size() + 1);
        bankAccount.setAccountType(accountCreationRequest.getAccountType());
        bankAccount.setAccountCreationDate(LocalDate.now());
        bankAccount.setAccountBalance(Double.valueOf(String.valueOf(accountCreationRequest.getInitialDepositAmount())));
//        bankAccount.getAccountIfscCode(bankAccount.getAccountIfscCode());
        bankAccount.setCustomerId(accountCreationRequest.getCustomerId());
        bankAccounts.add(bankAccount);
        return bankAccount;
    }

    public Account depositAmount(AmountRequest amountRequest) {
        bankAccounts = bankAccounts.stream()
                .map(bankAccount -> {
                    if (bankAccount.getAccountNumber().equals(amountRequest.getAccountNumber())) {
                        bankAccount.setAccountBalance(bankAccount.getAccountBalance() + amountRequest.getTransactionAmount());
                    }
                    return bankAccount;
                }).collect(Collectors.toList());

        return getAccountById(amountRequest.getAccountNumber());
    }

    public Account withdrawAmount(@NotNull AmountRequest amountRequest) {
        bankAccounts = bankAccounts.stream()
                .peek(bankAccount -> {
                    if (bankAccount.getAccountNumber().equals(amountRequest.getAccountNumber())) {
                        bankAccount.setAccountBalance(bankAccount.getAccountBalance() - amountRequest.getTransactionAmount());
                    }
                }).collect(Collectors.toList());
        return getAccountById(amountRequest.getAccountNumber());
    }

    public Account getAccountById(Long accountNumber) {
        List<Account> bankAccounts1 = bankAccounts.stream()
                .filter(bankAccount -> bankAccount.getAccountNumber().equals(accountNumber))
                .collect(Collectors.toList());
        return bankAccounts1.get(0);
    }

    public List<Account> getAccountsByCustomerId(Integer customerId) {
        return bankAccounts.stream()
                .filter(bankAccount -> bankAccount.getCustomerId().equals(customerId))
                .collect(Collectors.toList());
    }

    public Double getAccountBalance(Long accountNumber) {
        return getAccountById(accountNumber).getAccountBalance();
    }

    public Account deleteAccount(Long accountNumber) {
        bankAccounts = bankAccounts.stream()
                .peek(bankAccount1 -> {
                    if (bankAccount1.getAccountNumber().equals(accountNumber)) {
                    }
                }).collect(Collectors.toList());
        return getAccountById(accountNumber);
    }
}
