package com.bean.employee.employeemanagement.dto;

import jakarta.persistence.NamedStoredProcedureQueries;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@ToString


public class PinCodeAPIResponse {
    private String Message;
    private String Status;

    private List<PostOffice> PostOffice;
}
@Data
@NoArgsConstructor
@ToString
class PostOffice {
    private String Name;
    private String Description;
    private String BranchType;
    private String DeliveryStatus;
    private String Circle;
    private String District;
    private String Division;
    private String Region;
    private String Block;
    private String State;
    private String Country;
    private String Pincode;
}