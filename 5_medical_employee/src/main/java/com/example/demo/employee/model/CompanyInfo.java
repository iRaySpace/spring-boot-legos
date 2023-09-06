package com.example.demo.employee.model;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CompanyInfo {
    private String name;
    private String position;    

    public CompanyInfo (String name, String position) {
        this.name = name;
        this.position = position;
    }
}
