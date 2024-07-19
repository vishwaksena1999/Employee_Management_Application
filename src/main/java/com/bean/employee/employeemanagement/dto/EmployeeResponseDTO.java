package com.bean.employee.employeemanagement.dto;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
//@JsonIgnoreProperties({"bankNAme", "accountNumber", "passportNumber"})
//@JsonFilter("EmployeeResponse")

public class EmployeeResponseDTO {
    private LocalDate hireDate;
    private String hireManager;
    private String departmentName;
    private String designation;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private BigInteger mobileNumber;
    private String bankName;
    private Integer accountNumber;
    private String passportNumber;
    private AddressDetailsDTO addressDetailsDTO;
}
