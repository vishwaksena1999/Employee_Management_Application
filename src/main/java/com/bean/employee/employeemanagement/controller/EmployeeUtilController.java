package com.bean.employee.employeemanagement.controller;

import com.bean.employee.employeemanagement.dto.EmailDetailsDTO;
import com.bean.employee.employeemanagement.entity.EmployeePersonalDetails;
import com.bean.employee.employeemanagement.service.EmployeeService;
import com.bean.employee.employeemanagement.service.EmployeeUtilService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/util")
public class EmployeeUtilController {

    private static final Logger LOGGER= LogManager.getLogger(String.valueOf(EmployeeUtilController.class));

    private EmployeeService employeeService;

    @GetMapping("/test-async")
    public void callAsyncMethod(){
        LOGGER.info("Async Method Call Begin");
        employeeService.getEmployeeUtilService().asyncTest();
        LOGGER.info("Async Method Call End");
    }

    @GetMapping("/send-email")
    public void SendEmail(){
        List<EmployeePersonalDetails> all = employeeService.getEmployeePersonalDetailsRepository().findAll();
        LOGGER.info("initiate Email");
        String[] listofEmail = all.stream().map(emp -> emp.getEmailAddress()).toArray(size -> new String[size]);
        EmailDetailsDTO emailDetailsDTO = new EmailDetailsDTO("Salary Credited","Salary Got Credited into your Account",listofEmail,null );
        employeeService.getEmployeeUtilService().sendEmail(emailDetailsDTO.toString());
        LOGGER.info("Mail Sent");

    }
}
