package com.bookstore.controller;

import com.bookstore.model.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    // POST endpoint to create a new customer
    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    // POST endpoint to process form data for customer registration
    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> registerCustomer(@RequestParam("name") String name,
                                                                @RequestParam("email") String email,
                                                                @RequestParam("password") String password,
                                                                @RequestParam(value = "profilePicture", required = false) MultipartFile profilePicture) {
        // In a real application, you'd save the customer data to a database here

        Map<String, String> response = new HashMap<>();
        response.put("name", name);
        response.put("email", email);
        response.put("status", "Registration successful");

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Additional methods...
}