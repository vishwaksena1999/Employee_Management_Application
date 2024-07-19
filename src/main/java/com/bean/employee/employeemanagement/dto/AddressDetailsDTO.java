package com.bean.employee.employeemanagement.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class AddressDetailsDTO {
    private String line1;
    private String line2;
    private String city;
    private Integer zipcode;
}
