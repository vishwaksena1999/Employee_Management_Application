package com.bean.employee.employeemanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class EmailDetailsDTO {
    private String subject;
    private String msgBody;
    private String[] recipients;
    private String attachments;
}
