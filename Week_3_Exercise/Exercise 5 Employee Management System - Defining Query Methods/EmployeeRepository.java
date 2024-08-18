package com.example.EmployeeManagementSystem.repository;

import com.example.EmployeeManagementSystem.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Custom query method using keywords
    List<Employee> findByNameContaining(String keyword);

    // Custom query method using @Query annotation
    @Query("SELECT e FROM Employee e WHERE e.email = :email")
    Employee findByEmail(@Param("email") String email);
}