package com.bean.employee.employeemanagement.controller;

import com.bean.employee.employeemanagement.dto.AddressDetailsDTO;
import com.bean.employee.employeemanagement.dto.EmployeeResponseDTO;
import com.bean.employee.employeemanagement.dto.PinCodeAPIResponse;
import com.bean.employee.employeemanagement.entity.Department;
import com.bean.employee.employeemanagement.entity.Employee;
import com.bean.employee.employeemanagement.exception.EmployeeNotFound;
import com.bean.employee.employeemanagement.helper.EmployeeHelper;
import com.bean.employee.employeemanagement.repository.DepartmentRepository;
import com.bean.employee.employeemanagement.repository.EmployeeRepository;
import com.bean.employee.employeemanagement.service.EmployeeService;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping(value ="/fetch")
public class EmployeeFetchController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/get-all")
    public List<Employee> getAll() {
        return employeeService.getEmployeeRepository().findAll();
    }

    @GetMapping("/employee-by-id/{id}")
    public EmployeeResponseDTO getEmployeeById(@PathVariable(name = "id") int employeeId) {
        Optional<Employee> byId = employeeService.getEmployeeRepository().findById(employeeId);
        if(byId.isPresent())
            return EmployeeHelper.generateEmployee(byId.get(), employeeService);
        throw new EmployeeNotFound(" Employee details not found! ");
    }

    @GetMapping("/employee-by-department/{department}")
    public List<EmployeeResponseDTO> getEmployeeByDepartment(@PathVariable(name = "department") String department) {
        Department dept = employeeService.getDepartmentRepository().getDepartment(department);
        List<Employee> employeesByDepartment = employeeService.getEmployeeRepository().getEmployeesByDepartment(dept.getId());
        return EmployeeHelper.generateListofEmployees(employeesByDepartment, employeeService);
    }

    @GetMapping("/employee-by-manager/{Id}")
    public List<EmployeeResponseDTO> getEmployeeByManager(@PathVariable(name = "Id") int id)
    {
        List<Employee> employeesByManager = employeeService.getEmployeeRepository().getEmployeesByManager(id);
        return EmployeeHelper.generateListofEmployees(employeesByManager, employeeService);
    }

    @GetMapping("/passport-expired-employees")
    public List<EmployeeResponseDTO> getPassportExpiredEmployees()
    {
        List<Employee> employeesByManager = employeeService.getEmployeeRepository().getPassportExpiredEmployees();
        return EmployeeHelper.generateListofEmployees(employeesByManager, employeeService);
    }

    @GetMapping("/filter/employee")
    public MappingJacksonValue employeeFilter(){
        List<EmployeeResponseDTO> employeeResponseDTOS = EmployeeHelper.generateListofEmployees(employeeService.getEmployeeRepository().findAll(), employeeService);
        Set<String> filter = Stream.of("departmentName","hireDate","designation","firstName","LastName","emailAddress","mobileNumber").collect(Collectors.toSet());
        SimpleBeanPropertyFilter empFilter = SimpleBeanPropertyFilter.filterOutAllExcept(filter);
        SimpleFilterProvider simpleFilterProvider = new SimpleFilterProvider().addFilter("EmployeeResponse", empFilter);
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(employeeResponseDTOS);
        mappingJacksonValue.setFilters(simpleFilterProvider);
        return mappingJacksonValue;
    }

    @GetMapping("/filter/admin")
    public MappingJacksonValue adminFilter(){
        List<EmployeeResponseDTO> employeeResponseDTOS = EmployeeHelper.generateListofEmployees(employeeService.getEmployeeRepository().findAll(), employeeService);
        Set<String> filter = Stream.of("departmentName","hireDate","designation","firstName","LastName","emailAddress","mobileNumber","accountNumber","passportNumber").collect(Collectors.toSet());
        SimpleBeanPropertyFilter empFilter = SimpleBeanPropertyFilter.filterOutAllExcept(filter);
        SimpleFilterProvider simpleFilterProvider = new SimpleFilterProvider().addFilter("EmployeeResponse", empFilter);
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(employeeResponseDTOS);
        mappingJacksonValue.setFilters(simpleFilterProvider);
        return mappingJacksonValue;
    }

    @GetMapping("/find-area/{pinnumber}")
    public ResponseEntity<List<PinCodeAPIResponse>> findArea(@PathVariable(name = "pinnumber") int pinnumber) {
        String baseUrl = "https://api.postalpincode.in/pincode/"+pinnumber;
        RestTemplate restTemplate = new RestTemplate();
        List<PinCodeAPIResponse> response = restTemplate.getForObject(baseUrl, List.class);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
