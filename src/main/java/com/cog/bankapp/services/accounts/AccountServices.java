package com.cog.bankapp.services.accounts;

import com.cog.bankapp.dto.AccountCreationResponse;
import com.cog.bankapp.entity.Account;

import java.util.List;

public interface AccountServices {

    AccountCreationResponse createAccount(Long customer_id, Account account);

    public List<Account> getAccounts();

}
