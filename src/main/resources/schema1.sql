CREATE TABLE department(
    id int not null AUTO_INCREMENT,
    department_name varchar(100),
    branch varchar(50),
    PRIMARY KEY(id)
);

CREATE TABLE designation(
    id int not null AUTO_INCREMENT,
    designation_name varchar(100),
    PRIMARY KEY (id)
);

CREATE TABLE employee(
    id int not null AUTO_INCREMENT primary key ,
    department_id int,
    hire_date DATE,
    hire_manager int,
    status varchar(10),
    last_updated timestamp,
    CONSTRAINT FK_DEPARTMENT FOREIGN KEY (department_id) REFERENCES department(id)
);

CREATE TABLE employee_personal_details(
    id int not null AUTO_INCREMENT primary key ,
    employee_id int,
    first_name varchar(100),
    last_name varchar(100),
    email_address varchar(100),
    mobile_number bigint,
    designation_id int,
    last_updated timestamp,
    CONSTRAINT FK_EMP_PER_1 Foreign Key(employee_id) REFERENCES employee(id),
    CONSTRAINT FK_EMP_PER_2 FOREIGN KEY(designation_id) REFERENCES designation(id)
);

CREATE TABLE employee_address(
    id int not null AUTO_INCREMENT primary key ,
    employee_id int,
    line1 varchar(100),
    line2 varchar(100),
    zip_code int,
    last_updated timestamp,
    CONSTRAINT FK_EMP_ADD1 FOREIGN KEY(employee_id) REFERENCES employee(id)
);

CREATE TABLE employee_payroll_details(
    id int not null AUTO_INCREMENT primary key ,
    employee_id int,
    bank_name varchar(100),
    account_number int,
    bank_code varchar(100),
    account_status varchar(100),
    last_updated timestamp,
    CONSTRAINT FK_EMP_PER_4 FOREIGN KEY(employee_id) REFERENCES employee(id)
);

CREATE TABLE employee_passport_details(
    id int not null AUTO_INCREMENT primary key,
    employee_id int,
    passport_number varchar(100),
    valid_from DATE,
    valid_to DATE,
    last_updated timestamp,
    CONSTRAINT FK_EMP_PER_3 FOREIGN KEY(employee_id) REFERENCES employee(id)
);
