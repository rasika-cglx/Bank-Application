package com.cog.bankapp.services.accounts.impl;

import com.cog.bankapp.dao.AccountDao;
import com.cog.bankapp.entity.Account;
import com.cog.bankapp.services.accounts.AccountServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public abstract class AccountServiceImpl implements AccountServices {

    @Autowired
    private AccountDao accountDao;
    //--------------------------------------------------Get all Accounts ---------------------------------------------
    @Override
    public List<Account> getAccounts(){
        if(accountDao.findAll().isEmpty()) {
            return null;
        }
        return accountDao.findAll();
    }

    //--------------------------------------------------Create Account for customer---------------------------------------------
    public Account createAccount(Account account){
        return accountDao.save(account);
    }
}
