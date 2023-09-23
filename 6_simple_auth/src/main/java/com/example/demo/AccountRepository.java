package com.example.demo;

import java.util.ArrayList;
import java.util.UUID;
import java.util.Optional;

import org.springframework.stereotype.Component;


@Component
public class AccountRepository {
    private ArrayList<Account> data = new ArrayList<>();

    public Account save(Account account) {
        if (account.getId() == null) {
            account.setId(UUID.randomUUID().toString());
        }
        data.add(account);
        return account;
    }

    public Optional<Account> findByUsername(String username) {
        return data.stream().filter((account) -> account.getUsername().contentEquals(username)).findFirst();
    }
}
