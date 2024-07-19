package com.bean.employee.employeemanagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Employee  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonIgnore
    @ManyToOne
    private Department department;

    @Column
    private LocalDate hireDate;

    @JsonIgnore
    @Column(name = "hire_manager")
    private int hireManagerID;

    @Column
    private String status;

    @JsonIgnore
    @Column
    private Timestamp lastUpdated;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "employeePersonalDetails")
    private EmployeePersonalDetails employeePersonalDetails;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "employeePayrollDetails")
    private EmployeePayrollDetails employeePayrollDetails;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "employeePassportDetails")
    private EmployeePassportDetails employeePassportDetails;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "employeeAddress")
    private EmployeeAddress employeeAddress;
}
