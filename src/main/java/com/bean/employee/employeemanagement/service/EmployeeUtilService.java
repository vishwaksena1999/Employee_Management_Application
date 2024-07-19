package com.bean.employee.employeemanagement.service;

import com.bean.employee.employeemanagement.dto.EmailDetailsDTO;
import com.bean.employee.employeemanagement.entity.EmployeePersonalDetails;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class EmployeeUtilService {

    private final Logger LOGGER = LogManager.getLogger(EmployeeUtilService.class);

    private JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")

    private String from;

    @Autowired
    private @Lazy EmployeeService employeeService;

    @Async
    public void asyncTest(){
        List<Integer> intList = Stream.of(1, 2, 3, 4, 5).collect(Collectors.toList());
        LOGGER.info("Method Initiator");
        intList.forEach(in ->{
            try {
                Thread.sleep(3000);
                LOGGER.info("Data :"+in);
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        });
        LOGGER.info("Method End");
    }

    public void sendEmail(String emailAddress) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(from);
        simpleMailMessage.setTo(emailAddress);
        simpleMailMessage.setSubject("Test Email");
        simpleMailMessage.setText("Welcome to Springboot Application");
        javaMailSender.send(simpleMailMessage);
        LOGGER.info("Mail Sent Successfully");
    }

    @Async
    public void send(EmailDetailsDTO emailDetailsDTO) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(from);
        simpleMailMessage.setTo(emailDetailsDTO.getRecipients());
        simpleMailMessage.setSubject(emailDetailsDTO.getSubject());
        simpleMailMessage.setText(emailDetailsDTO.getMsgBody());
        javaMailSender.send(simpleMailMessage);
        LOGGER.info("Mail Sent Successfully"+ Arrays.toString(emailDetailsDTO.getRecipients()));
    }

    //@Scheduled(fixedDelay = 10000)
    //@Scheduled(cron = "0 0/1 * 1/1 * ?")//for every minute
    @Scheduled(initialDelay = 1000*30, fixedDelay = Long.MAX_VALUE)//for only once
    public void sendEmailByMonthly(){
        List<EmployeePersonalDetails> all = employeeService.getEmployeePersonalDetailsRepository().findAll();
        LOGGER.info("Scheduler Started");
        String[] listofEmail = all.stream().map(emp -> emp.getEmailAddress()).toArray(size -> new String[size]);
        EmailDetailsDTO emailDetailsDTO = new EmailDetailsDTO("Salary Credited","Salary Got Credited into your Account",listofEmail,null );
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        LOGGER.info("Monthly Scheduler Started"+simpleDateFormat.format(new Date()));
        send(emailDetailsDTO);
        LOGGER.info("Monthly Scheduler End"+simpleDateFormat.format(new Date()));
    }

}
