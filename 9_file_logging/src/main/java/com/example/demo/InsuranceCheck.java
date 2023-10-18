package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class InsuranceCheck {
    private String userId;
    private boolean eligible;    
}
