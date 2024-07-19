package com.bean.employee.employeemanagement.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@ToString

public class EmployeeRequestDTO {
    private LocalDate hireDate;
    private String hireManagerId;
    private String departmentId;
    private int designationId;

    private String firstName;
    private String lastName;
    private String emailAddress;
    private BigInteger mobileNumber;

    private String bankNAme;
    private String bankCode;
    private Integer accountNumber;

    private String passportNumber;
    private Date validFrom;
    private Date validTo;

    private AddressDetailsDTO addressDetailsDTO;
}
