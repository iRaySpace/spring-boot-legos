package com.example.demo;

import java.security.SecureRandom;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public Account register(Account account) {
        // TODO: BCryptPasswordEncoder
        String salt = new String(nextSalt());
        account.setPassword(String.format("%s:%s", salt, salt + account.getPassword()));
        account.setUsername(account.getUsername().toLowerCase());
        return accountRepository.save(account);
    }

    public void login(Account account) throws Exception {
        Account existingAccount = accountRepository.findByUsername(account.getUsername().toLowerCase()).orElseThrow(() -> new UserNotFoundException());
        if (!isValidPassword(existingAccount, account.getPassword())) {
            throw new InvalidAccountException();
        }
    }

    private byte[] nextSalt() {
        byte[] salt = new byte[16];
        new SecureRandom().nextBytes(salt);
        return salt;
    }

    private boolean isValidPassword(Account account, String password) {
        String[] passwords = account.getPassword().split(":");
        String salt = passwords[0];
        String saltedPassword = passwords[1];
        String existingPassword = saltedPassword.substring(salt.length());
        return existingPassword.contentEquals(password);
    }
}
