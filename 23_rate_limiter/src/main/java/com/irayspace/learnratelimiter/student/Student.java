package com.irayspace.learnratelimiter.student;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Student {
    private String id;
    private String firstName;
    private String middleName;
    private String lastName;    
}
