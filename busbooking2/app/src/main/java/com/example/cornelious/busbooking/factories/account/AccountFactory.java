package com.example.cornelious.busbooking.factories.account;

import com.example.cornelious.busbooking.domain.account.Account;

/**
 * Created by Cornelious on 5/12/2016.
 */
public class AccountFactory {
    private static AccountFactory accountFactory = null;

    public static AccountFactory getInstance() {
        if (accountFactory == null)
            accountFactory = new AccountFactory();
        return accountFactory;
    }

    public Account createAccount(Long acc,String username, String password) {
        Account activateAccount = new Account.AccountBuilder()
                .id(acc)
                .username(username)
                .password(password)

                .build();
        return activateAccount;

    }
}
