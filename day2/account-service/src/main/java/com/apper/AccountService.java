package com.apper;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RestController
@RequestMapping("account")
public class AccountService {
    private IdGeneratorService idGenerator = new IdGeneratorService();
    private List<Account> accounts = new ArrayList<>();

    public Account create(String firstName, String lastName, String username, String clearPassword) throws UsernameAlreadyRegisteredException {
        Account account = new Account();
        account.setId(idGenerator.nextId());
        account.setBalance(1_000.0);

        LocalDateTime now = LocalDateTime.now();
        account.setCreationDate(now);
        account.setLastUpdated(now);

        account.setFirstName(firstName);
        account.setLastName(lastName);
        account.setUsername(username);
        account.setClearPassword(clearPassword);

        // call a method that generates a verification code
        account.setVerificationCode(idGenerator.generateRandomCharacters(6));

        accounts.add(account);

        return account;
    }

    public Account get(String accountId) {
        for (Account account : accounts) {
            if (account.getId().equals(accountId)) {
                return account;
            }
        }

        return null;
    }

    public List<Account> getAll() {
        return accounts;
    }

    public Account update(String accountId, String firstName, String lastName, String username, String clearPassword) {
        LocalDateTime now = LocalDateTime.now();
        for (Account account : accounts) {
            // once the account is found, set the new parameters
            // and return to the controller
            if (account.getId().equals(accountId)) {
                account.setFirstName(firstName);
                account.setLastName(lastName);
                account.setUsername(username);
                account.setClearPassword(clearPassword);
                account.setLastUpdated(now);
                return account;
            }
        }
        return null;
    }

    public Boolean delete(String accountId) {
        for (Account account : accounts) {
            if (account.getId().equals(accountId)) {
                accounts.remove(account);
                return true;
            }
        }
        return false;
    }
}