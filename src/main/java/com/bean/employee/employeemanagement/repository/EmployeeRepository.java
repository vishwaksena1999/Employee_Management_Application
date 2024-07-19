package com.bean.employee.employeemanagement.repository;

import com.bean.employee.employeemanagement.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

        @Query(value = "select o from Employee o where o.department.id = :id")
        public List<Employee> getEmployeesByDepartment(@Param("id") int id);

        @Query(value = "select o from Employee o where o.hireManagerID = :id")
        public List<Employee> getEmployeesByManager(@Param("id") int id);

        @Query(value = "select o from Employee o where now() not between o.employeePassportDetails.validFrom and o.employeePassportDetails.validTo")
        public List<Employee> getPassportExpiredEmployees();

}
