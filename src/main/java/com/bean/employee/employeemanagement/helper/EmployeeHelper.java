package com.bean.employee.employeemanagement.helper;

import com.bean.employee.employeemanagement.dto.AddressDetailsDTO;
import com.bean.employee.employeemanagement.dto.EmployeeRequestDTO;
import com.bean.employee.employeemanagement.dto.EmployeeResponseDTO;
import com.bean.employee.employeemanagement.entity.*;
import com.bean.employee.employeemanagement.service.EmployeeService;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmployeeHelper {

    enum EmployeeStatus {Active, Retired, Left}

    public static EmployeeResponseDTO generateEmployee(Employee emp, EmployeeService employeeService) {

        EmployeeResponseDTO employeeResponseDTO = new EmployeeResponseDTO();

        employeeResponseDTO.setAccountNumber(emp.getEmployeePayrollDetails().getAccountNumber());
        employeeResponseDTO.setDesignation(emp.getEmployeePersonalDetails().getDesignation().getDesignationName());

        Employee hireManager = employeeService.getEmployeeRepository().findById(emp.getHireManagerID()).get();
        employeeResponseDTO.setHireManager(hireManager.getEmployeePersonalDetails().getFirstName());

        employeeResponseDTO.setAccountNumber(emp.getEmployeePayrollDetails().getAccountNumber());
        employeeResponseDTO.setBankName(emp.getEmployeePayrollDetails().getBankName());
        employeeResponseDTO.setEmailAddress(emp.getEmployeePersonalDetails().getEmailAddress());
        employeeResponseDTO.setLastName(emp.getEmployeePersonalDetails().getLastName());
        employeeResponseDTO.setFirstName(emp.getEmployeePersonalDetails().getFirstName());
        employeeResponseDTO.setMobileNumber(emp.getEmployeePersonalDetails().getMobileNumber());
        employeeResponseDTO.setPassportNumber(emp.getEmployeePassportDetails().getPassportNumber());
        employeeResponseDTO.setHireDate(emp.getHireDate());
        employeeResponseDTO.setDepartmentName(emp.getDepartment().getDepartmentName());

        AddressDetailsDTO addressDetailsDTO = new AddressDetailsDTO();
        addressDetailsDTO.setLine1(emp.getEmployeeAddress().getLine1());
        addressDetailsDTO.setLine2(emp.getEmployeeAddress().getLine2());
        addressDetailsDTO.setCity(emp.getEmployeeAddress().getCity());
        addressDetailsDTO.setZipcode(emp.getEmployeeAddress().getZipCode());

        employeeResponseDTO.setAddressDetailsDTO(addressDetailsDTO);
        return employeeResponseDTO;
    }

    public static List<EmployeeResponseDTO> generateListofEmployees(List<Employee> employeesByDepartment, EmployeeService employeeService) {
        List<EmployeeResponseDTO> response = new ArrayList<>();
        employeesByDepartment.forEach(emp -> {
                response.add(generateEmployee(emp, employeeService));
        });
        return response;

    }

    public static Employee createNewEmployee(EmployeeRequestDTO requestDTO, EmployeeService employeeService) {
        Employee employee = createEmployee(requestDTO, employeeService);
        EmployeePersonalDetails employeePersonalDetails = createEmployeePersonalDetails(requestDTO, employee, employeeService);
        createEmployeePayrollDetails(requestDTO, employeePersonalDetails,employee);
        createEmployeePassportDetails(requestDTO, employee);
        createEmployeeAddress(requestDTO, employee);
        return employeeService.getEmployeeRepository().save(employee);
    }
    private static void createEmployeeAddress(EmployeeRequestDTO requestDTO, Employee employee) {
        EmployeeAddress employeeAddress = new EmployeeAddress();
        employeeAddress.setLine1(requestDTO.getAddressDetailsDTO().getLine1());
        employeeAddress.setLine2(requestDTO.getAddressDetailsDTO().getLine2());
        employeeAddress.setCity(requestDTO.getAddressDetailsDTO().getCity());
        employeeAddress.setZipCode(requestDTO.getAddressDetailsDTO().getZipcode());
        employeeAddress.setEmployeeAddress(employee);
        employee.setEmployeeAddress(employeeAddress);
    }

    private static void createEmployeePassportDetails(EmployeeRequestDTO requestDTO, Employee employee) {
        EmployeePassportDetails employeePassportDetails = new EmployeePassportDetails();
        employeePassportDetails.setPassportNumber(requestDTO.getPassportNumber());
        employeePassportDetails.setValidFrom(requestDTO.getValidFrom());
        employeePassportDetails.setValidTo(requestDTO.getValidTo());
        employeePassportDetails.setEmployeePassportDetails(employee);
        employee.setEmployeePassportDetails(employeePassportDetails);
    }

    private static void createEmployeePayrollDetails(EmployeeRequestDTO requestDTO, EmployeePersonalDetails employeePersonalDetails, Employee employee) {
        EmployeePayrollDetails employeePayrollDetails = new EmployeePayrollDetails();
        employeePayrollDetails.setAccountNumber(requestDTO.getAccountNumber());
        employeePayrollDetails.setAccountStatus("Active");
        employeePayrollDetails.setBankCode(requestDTO.getBankCode());
        employeePayrollDetails.setBankName(requestDTO.getBankNAme());
        employeePayrollDetails.setEmployeePayrollDetails(employee);
        employee.setEmployeePayrollDetails(employeePayrollDetails);
    }

    private static EmployeePersonalDetails createEmployeePersonalDetails(EmployeeRequestDTO requestDTO, Employee employee, EmployeeService employeeService) {
        EmployeePersonalDetails employeePersonalDetails =new EmployeePersonalDetails();
        Designation designation = employeeService.getDesignationRepository().findById(requestDTO.getDesignationId()).get();
        employeePersonalDetails.setFirstName(requestDTO.getFirstName());
        employeePersonalDetails.setLastName(requestDTO.getLastName());
        employeePersonalDetails.setEmailAddress(requestDTO.getEmailAddress());
        employeePersonalDetails.setMobileNumber(requestDTO.getMobileNumber());
        employeePersonalDetails.setDesignation(designation);
        employeePersonalDetails.setEmployeePersonalDetails(employee);
        employee.setEmployeePersonalDetails(employeePersonalDetails);
        return employeePersonalDetails;
    }

    private static Employee createEmployee(EmployeeRequestDTO requestDTO, EmployeeService employeeService) {
        Employee employee = new Employee();
        Department department = employeeService.getDepartmentRepository().findById(Integer.parseInt(requestDTO.getDepartmentId())).get();
        employee.setDepartment(department);
        employee.setHireDate(requestDTO.getHireDate());
        employee.setHireManagerID(Integer.parseInt(requestDTO.getHireManagerId()));
        employee.setLastUpdated(new Timestamp(new Date().getTime()));
        employee.setStatus(EmployeeStatus.Active.toString());
        return employee;
    }
}
