package com.bean.employee.employeemanagement.exception;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class EmployeeExceptionResponse {
    private String errorMessage, description;
    private Date dateAndTime;
}
