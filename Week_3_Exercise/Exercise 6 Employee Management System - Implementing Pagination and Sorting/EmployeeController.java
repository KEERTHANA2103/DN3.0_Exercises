package com.example.EmployeeManagementSystem.controller;

import com.example.EmployeeManagementSystem.entity.Employee;
import com.example.EmployeeManagementSystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Other CRUD methods...

    // Get paginated and sorted list of Employees by name
    @GetMapping("/search")
    public Page<Employee> searchEmployees(@RequestParam("keyword") String keyword,
                                          @RequestParam("page") int page,
                                          @RequestParam("size") int size,
                                          @RequestParam("sortField") String sortField,
                                          @RequestParam("sortDir") String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase("asc") ? Sort.by(sortField).ascending() : Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return employeeRepository.findByNameContaining(keyword, pageable);
    }
}