package com.irayspace.h2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Getter
@Setter
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String middleName;
    private String lastName;

    public Employee() {}

    public Employee(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        System.out.println(firstName);
        return String.format(
            "Employee[id=%d, firstName='%s', lastName='%s']",
            id, firstName, lastName
        );
    }
}
