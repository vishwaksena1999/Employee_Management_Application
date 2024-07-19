package com.bean.employee.employeemanagement.repository;

import com.bean.employee.employeemanagement.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer>{
    @Query(value = "select o from Department o where o.departmentName = :department")
    public Department getDepartment(@Param("department") String department);

}
