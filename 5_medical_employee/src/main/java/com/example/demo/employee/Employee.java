package com.example.demo.employee;

import lombok.Getter;
import lombok.Setter;
import lombok.RequiredArgsConstructor;

import com.example.demo.employee.model.CompanyInfo;
import com.example.demo.employee.model.EmergencyInfo;


@Getter
@Setter
public class Employee {
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String mobileNo;

    private CompanyInfo companyInfo;
    private EmergencyInfo emergencyInfo;

    public Employee(
        String firstName,
        String middleName,
        String lastName,
        String email,
        String mobileNo,
        CompanyInfo companyInfo,
        EmergencyInfo emergencyInfo) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.email = email;
        this.mobileNo = mobileNo;
        this.companyInfo = companyInfo;
        this.emergencyInfo = emergencyInfo;
    }
}
