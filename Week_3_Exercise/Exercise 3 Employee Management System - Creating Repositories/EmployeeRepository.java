package com.example.EmployeeManagementSystem.repository;

import com.example.EmployeeManagementSystem.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Derived query method to find employees by department name
    List<Employee> findByDepartmentName(String departmentName);

    // Derived query method to find employees by name
    List<Employee> findByName(String name);
}