package com.example.demo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Account {
    private String id;
    private String username;
    private String password;

    @Override
    public String toString() {
        return String.format("Account { id: %s, username: %s }", this.id, this.username);
    }
}
