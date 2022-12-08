package com.cog.bankapp.services;

import com.cog.bankapp.entity.Account;

import java.util.List;

public interface AccountServices {

    public Account createAccount(Account account);

    public List<Account> getAccounts();

}
