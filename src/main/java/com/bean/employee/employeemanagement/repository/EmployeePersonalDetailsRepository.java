package com.bean.employee.employeemanagement.repository;

import com.bean.employee.employeemanagement.entity.EmployeePersonalDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeePersonalDetailsRepository extends JpaRepository<EmployeePersonalDetails, Integer> {
}
