package com.unoffstars.dip.datacollection.service;

import com.unoffstars.dip.datacollection.model.Account;
import com.unoffstars.dip.datacollection.model.dto.request.RequestAccount;
import org.springframework.stereotype.Service;
import com.unoffstars.dip.datacollection.repository.AccountRepository;

import java.util.Date;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account save(Account account) {
        return accountRepository.save(account);
    }

    public Account save(RequestAccount requestAccount){
        Account account = createAccount(0, requestAccount.getUsername(), requestAccount.getEmail(), requestAccount.getPassword());
        return save(account);
    }

    public Account createAccount(Integer id, String username, String email, String password) {
        Account account = new Account();
        account.setUsername(username);
        account.setEmail(email);
        account.setPassword(password);

        if (id != 0) {
            account.setId(id);
        } else {
            account.setCreatedAt(new Date());
        }
        account.setUpdatedAt(new Date());
        return account;
    }

}
