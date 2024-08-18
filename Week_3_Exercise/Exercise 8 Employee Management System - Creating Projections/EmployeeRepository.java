package com.example.EmployeeManagementSystem.repository;

import com.example.EmployeeManagementSystem.entity.Employee;
import com.example.EmployeeManagementSystem.projection.EmployeeDetailsDTO;
import com.example.EmployeeManagementSystem.projection.EmployeeNameAndEmailProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Interface-based projection
    List<EmployeeNameAndEmailProjection> findByDepartmentName(String departmentName);

    // Class-based projection using @Query and constructor expression
    @Query("SELECT new com.example.EmployeeManagementSystem.projection.EmployeeDetailsDTO(e.name, e.email, d.name) " +
           "FROM Employee e JOIN e.department d WHERE d.name = :departmentName")
    List<EmployeeDetailsDTO> findEmployeeDetailsByDepartmentName(String departmentName);
}