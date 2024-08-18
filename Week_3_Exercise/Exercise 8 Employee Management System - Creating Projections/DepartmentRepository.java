package com.example.EmployeeManagementSystem.repository;

import com.example.EmployeeManagementSystem.entity.Department;
import com.example.EmployeeManagementSystem.projection.DepartmentNameProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    // Interface-based projection
    List<DepartmentNameProjection> findBy();
}