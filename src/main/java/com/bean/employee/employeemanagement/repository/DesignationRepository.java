package com.bean.employee.employeemanagement.repository;

import com.bean.employee.employeemanagement.entity.Designation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesignationRepository extends JpaRepository<Designation, Integer> {

}
