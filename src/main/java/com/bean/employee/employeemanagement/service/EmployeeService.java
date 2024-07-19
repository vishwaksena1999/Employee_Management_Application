package com.bean.employee.employeemanagement.service;

import com.bean.employee.employeemanagement.repository.DepartmentRepository;
import com.bean.employee.employeemanagement.repository.DesignationRepository;
import com.bean.employee.employeemanagement.repository.EmployeePersonalDetailsRepository;
import com.bean.employee.employeemanagement.repository.EmployeeRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Data

public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private DesignationRepository designationRepository;

    @Autowired
    private EmployeePersonalDetailsRepository employeePersonalDetailsRepository;

    @Autowired
    private EmployeeUtilService employeeUtilService;
}
