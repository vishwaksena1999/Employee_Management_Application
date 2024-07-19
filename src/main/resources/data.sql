insert into department(id,department_name, branch)values(1,'Sales','Chennai');
insert into department(id,department_name, branch)values(2,'HR','Chennai');
insert into department(id,department_name, branch)values(3,'Marketing','Delhi');
insert into department(id,department_name, branch)values(4,'Delivery','Chennai');
insert into department(id,department_name, branch)values(5,'Payroll','Delhi');


insert into employee (id,hire_date,hire_manager,status,department_id,last_updated) values (1,now(),1,'Active',5,now());
insert into employee (id,hire_date,hire_manager,status,department_id,last_updated) values (2,now(),1,'Active',4,now());
insert into employee (id,hire_date,hire_manager,status,department_id,last_updated) values (3,now(),2,'Active',3,now());
insert into employee (id,hire_date,hire_manager,status,department_id,last_updated) values (4,now(),3,'Active',2,now());
insert into employee (id,hire_date,hire_manager,status,department_id,last_updated) values (5,now(),4,'Active',1,now());
insert into employee (id,hire_date,hire_manager,status,department_id,last_updated) values (6,now(),1,'Active',4,now());
insert into employee (id,hire_date,hire_manager,status,department_id,last_updated) values (7,now(),1,'Active',3,now());
insert into employee (id,hire_date,hire_manager,status,department_id,last_updated) values (8,now(),2,'Active',3,now());
insert into employee (id,hire_date,hire_manager,status,department_id,last_updated) values (9,now(),3,'Active',3,now());
insert into employee (id,hire_date,hire_manager,status,department_id,last_updated) values (10,now(),4,'Active',3,now());


insert into designation(id,designation_name) values (1,'Salesman');
insert into designation(id,designation_name) values (2,'Manager');
insert into designation(id,designation_name) values (3,'Assistant');
insert into designation(id,designation_name) values (4,'CEO');
insert into designation(id,designation_name) values (5,'Security');

insert into employee_personal_details(id,EMAIL_ADDRESS, FIRST_NAME, LAST_NAME, MOBILE_NUMBER, EMPLOYEE_ID, designation_id) values(1,'arunkumar@email.com','Arun', 'Kumar', 9701886422,1,1);
insert into employee_personal_details(id,EMAIL_ADDRESS, FIRST_NAME, LAST_NAME, MOBILE_NUMBER, EMPLOYEE_ID, designation_id) values(2,'ar.sundaram@email.com','Sundaram','AR',9849585785,2,1);
insert into employee_personal_details(id,EMAIL_ADDRESS, FIRST_NAME, LAST_NAME, MOBILE_NUMBER, EMPLOYEE_ID, designation_id) values(3,'gunreddy.madhavi@email.com','madhavi','Gunreddy',8885556666,3,2);
insert into employee_personal_details(id,EMAIL_ADDRESS, FIRST_NAME, LAST_NAME, MOBILE_NUMBER, EMPLOYEE_ID, designation_id) values(4,'janedoe@email.com','Jane','Doe',5132089642,4,2);
insert into employee_personal_details(id,EMAIL_ADDRESS, FIRST_NAME, LAST_NAME, MOBILE_NUMBER, EMPLOYEE_ID, designation_id) values(5,'tonyscott@email.com','Tony','Scott',5134432548,5,2);
insert into employee_personal_details(id,EMAIL_ADDRESS, FIRST_NAME, LAST_NAME, MOBILE_NUMBER, EMPLOYEE_ID, designation_id) values(6,'ridelyscott@email.com','Ridley','Scott',1234567890,6,3);
insert into employee_personal_details(id,EMAIL_ADDRESS, FIRST_NAME, LAST_NAME, MOBILE_NUMBER, EMPLOYEE_ID, designation_id) values(7,'christophernolan@email.com','Christopher','Nolan',9585417613,7,3);
insert into employee_personal_details(id,EMAIL_ADDRESS, FIRST_NAME, LAST_NAME, MOBILE_NUMBER, EMPLOYEE_ID, designation_id) values(8,'meherramesh@email.com','Meher','Ramesh',9996669991,8,3);
insert into employee_personal_details(id,EMAIL_ADDRESS, FIRST_NAME, LAST_NAME, MOBILE_NUMBER, EMPLOYEE_ID, designation_id) values(9,'maheshbabu@email.com','Mahesh','Babu', 1112223334, 9,3);
insert into employee_personal_details(id,EMAIL_ADDRESS, FIRST_NAME, LAST_NAME, MOBILE_NUMBER, EMPLOYEE_ID, designation_id) values(10,'jrntr@email.com','Jr','Ntr',7775554442,10,5);

insert into employee_payroll_details(id,ACCOUNT_NUMBER, ACCOUNT_STATUS, BANK_CODE, BANK_NAME, EMPLOYEE_ID) values(1,998761,'Active','SBI09877','Bank of Neveda',1);
insert into employee_payroll_details(id,ACCOUNT_NUMBER, ACCOUNT_STATUS, BANK_CODE, BANK_NAME, EMPLOYEE_ID) values(2,998762,'Active','SBI09877','Bank of Neveda',2);
insert into employee_payroll_details(id,ACCOUNT_NUMBER, ACCOUNT_STATUS, BANK_CODE, BANK_NAME, EMPLOYEE_ID) values(3,998763,'Active','SCI13455','Standard Chatered Bank',3);
insert into employee_payroll_details(id,ACCOUNT_NUMBER, ACCOUNT_STATUS, BANK_CODE, BANK_NAME, EMPLOYEE_ID) values(4,998764,'Active','SBI09877','Bank of Neveda',4);
insert into employee_payroll_details(id,ACCOUNT_NUMBER, ACCOUNT_STATUS, BANK_CODE, BANK_NAME, EMPLOYEE_ID) values(5,998765,'Active','SCI13455','Standard Chatered Bank',5);
insert into employee_payroll_details(id,ACCOUNT_NUMBER, ACCOUNT_STATUS, BANK_CODE, BANK_NAME, EMPLOYEE_ID) values(6,998766,'Active','SBI09877','Bank of Neveda',6);
insert into employee_payroll_details(id,ACCOUNT_NUMBER, ACCOUNT_STATUS, BANK_CODE, BANK_NAME, EMPLOYEE_ID) values(7,998767,'Not-Active','SCI13455','Standard Chatered Bank',7);
insert into employee_payroll_details(id,ACCOUNT_NUMBER, ACCOUNT_STATUS, BANK_CODE, BANK_NAME, EMPLOYEE_ID) values(8,998768,'Active','SBI09877','Bank of Neveda',8);
insert into employee_payroll_details(id,ACCOUNT_NUMBER, ACCOUNT_STATUS, BANK_CODE, BANK_NAME, EMPLOYEE_ID) values(9,998769,'Active','SCI13455','Standard Chatered Bank',9);
insert into employee_payroll_details(id,ACCOUNT_NUMBER, ACCOUNT_STATUS, BANK_CODE, BANK_NAME, EMPLOYEE_ID) values(10,998770,'Not-Active','SBI09877','Bank of Neveda',10);

insert into employee_passport_details(id,PASSPORT_NUMBER, VALID_FROM, VALID_TO, EMPLOYEE_ID) values (1,'BCD2324', '2008-11-11', '2018-11-11', 1);
insert into employee_passport_details(id,PASSPORT_NUMBER, VALID_FROM, VALID_TO, EMPLOYEE_ID) values (2,'YZA2122','2020-10-21','2028-11-11',2);
insert into employee_passport_details(id,PASSPORT_NUMBER, VALID_FROM, VALID_TO, EMPLOYEE_ID) values (3,'VWX9120','2020-10-21', '2028-11-11',3);
insert into employee_passport_details(id,PASSPORT_NUMBER, VALID_FROM, VALID_TO, EMPLOYEE_ID) values (4,'STU7181','2020-12-21', '2026-12-11',4);
insert into employee_passport_details(id,PASSPORT_NUMBER, VALID_FROM, VALID_TO, EMPLOYEE_ID) values (5,'PQR5161','2018-09-11','2027-09-11',5);
insert into employee_passport_details(id,PASSPORT_NUMBER, VALID_FROM, VALID_TO, EMPLOYEE_ID) values (6,'MNO3141', '2014-08-11','2024-08-11',6);
insert into employee_passport_details(id,PASSPORT_NUMBER, VALID_FROM, VALID_TO, EMPLOYEE_ID) values (7,'JKL1121', '2020-11-11', '2028-11-11', 7);
insert into employee_passport_details(id,PASSPORT_NUMBER, VALID_FROM, VALID_TO, EMPLOYEE_ID) values (8,'GHI9101','2020-10-11','2028-10-11',8);
insert into employee_passport_details(id,PASSPORT_NUMBER, VALID_FROM, VALID_TO, EMPLOYEE_ID) values (9,'DEF5678', '2020-06-11', '2028-06-11', 9);
insert into employee_passport_details(id,PASSPORT_NUMBER, VALID_FROM, VALID_TO, EMPLOYEE_ID) values (10,'ABC1234', '2020-05-11', '2028-05-11', 10);

insert into employee_address(id,CITY, LINE1, LINE2, ZIP_CODE, EMPLOYEE_ID) values (1,'Chennai', '5th Street', 'OMR', 600096, 1);
insert into employee_address(id,CITY, LINE1, LINE2, ZIP_CODE, EMPLOYEE_ID) values (2,'Delhi', 'Nethji Road', '1st Main St', 123432, 2);
insert into employee_address(id,CITY, LINE1, LINE2, ZIP_CODE, EMPLOYEE_ID) values (3,'Banglore','Rai Nagar', '2nd Cross St', 433232,3);
insert into employee_address(id,CITY, LINE1, LINE2, ZIP_CODE, EMPLOYEE_ID) values (4,'Goa','Green APT', '3rd phase', 654456, 4);
insert into employee_address(id,CITY, LINE1, LINE2, ZIP_CODE, EMPLOYEE_ID) values (5,'Gurgaon', 'Madipakkal', 'ECR', 567754, 5);
insert into employee_address(id,CITY, LINE1, LINE2, ZIP_CODE, EMPLOYEE_ID) values (6,'Gujarath', 'Adampakkam', 'East Coast', 766566, 6);
insert into employee_address(id,CITY, LINE1, LINE2, ZIP_CODE, EMPLOYEE_ID) values (7,'Chennai', 'Kilapakkam', 'Bhai Mahal', 566566, 7);
insert into employee_address(id,CITY, LINE1, LINE2, ZIP_CODE, EMPLOYEE_ID) values (8,'Delhi', 'Central', 'Market Arena', 234534, 8);
insert into employee_address(id,CITY, LINE1, LINE2, ZIP_CODE, EMPLOYEE_ID) values (9,'Hyderabad', 'Kailash', 'Hallal Mall', 122212, 9);
insert into employee_address(id,CITY, LINE1, LINE2, ZIP_CODE, EMPLOYEE_ID) values (10,'Goa', 'Western Main Road', '4th Main Road', 121231, 10);
