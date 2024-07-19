package com.bean.employee.employeemanagement.controller;

import com.bean.employee.employeemanagement.dto.EmployeeRequestDTO;
import com.bean.employee.employeemanagement.dto.AddressDetailsDTO;
import com.bean.employee.employeemanagement.dto.EmployeeResponseDTO;
import com.bean.employee.employeemanagement.entity.EmployeePassportDetails;
import com.bean.employee.employeemanagement.entity.*;
import com.bean.employee.employeemanagement.exception.EmployeeNotFound;
import com.bean.employee.employeemanagement.helper.EmployeeHelper;
import com.bean.employee.employeemanagement.service.EmployeeService;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.DeleteExchange;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Optional;

@RestController
@RequestMapping(value = "/dml")
public class EmployeeDMLController {

    @Autowired
    private EmployeeService employeeService;


    @PostMapping("/save-employee")
    public EmployeeResponseDTO saveEmployee(@RequestBody EmployeeRequestDTO requestDTO){
        Employee newEmployee = EmployeeHelper.createNewEmployee(requestDTO, employeeService);
        return EmployeeHelper.generateEmployee(newEmployee, employeeService);
    }

    @PutMapping("/update-designation/{id}/{designation}")
    public EmployeeResponseDTO updateDesignation(@PathVariable(name = "id") int employeeid, @PathVariable("designation") int designationId)
    {
        Optional<Employee> byId = employeeService.getEmployeeRepository().findById(employeeid);
        if(byId.isPresent()){
            EmployeePersonalDetails employeePersonalDetails = byId.get().getEmployeePersonalDetails();
            Designation designation = employeeService.getDesignationRepository().findById(designationId).get();
            employeePersonalDetails.setDesignation(null);
            employeeService.getEmployeePersonalDetailsRepository().save(employeePersonalDetails);
            return EmployeeHelper.generateEmployee(byId.get(), employeeService);
        }
        else{
            throw new EmployeeNotFound("Employee Not Exists!!");

        }
    }

    @DeleteMapping("/delete-employee/{id}")
    public void deleteEmployee(@PathVariable(name = "id") int employeeid)
    {
        Optional<Employee> byId = employeeService.getEmployeeRepository().findById(employeeid);
        if(byId.isPresent()){
            Employee employee = byId.get();
            employeeService.getEmployeeRepository().delete(employee);
        }
        else{
            throw new EmployeeNotFound("Employee Not Exists!!");

        }

    }


}
