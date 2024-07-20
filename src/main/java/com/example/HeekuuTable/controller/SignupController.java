package com.example.HeekuuTable.controller;

import com.example.HeekuuTable.dto.SignupRequestDto;
import com.example.HeekuuTable.grade.RoleName;
import com.example.HeekuuTable.model.Customer;
import com.example.HeekuuTable.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class SignupController {

    @Autowired
    private UserService userService;

    @Autowired
    @Lazy
    private PasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public ResponseEntity<Map<String, String>> registerUser(@Valid @RequestBody SignupRequestDto signupRequestDto, BindingResult bindingResult) {
        Map<String, String> response = new HashMap<>();

        if (bindingResult.hasErrors()) {
            response.put("status", "error");
            response.put("message", bindingResult.getAllErrors().get(0).getDefaultMessage());
            return ResponseEntity.badRequest().body(response);
        }

        if (userService.findByPhoneNumber(signupRequestDto.getPhoneNumber()) != null) {
            response.put("status", "error");
            response.put("message", "Phone number is already in use!");
            return ResponseEntity.badRequest().body(response);
        }

        RoleName roleName = signupRequestDto.getRole();

        Customer customer = new Customer();
        customer.setPhoneNumber(signupRequestDto.getPhoneNumber());
        customer.setName(signupRequestDto.getName());
        customer.setPassword(passwordEncoder.encode(signupRequestDto.getPassword()));
        customer.setRoles(Collections.singleton(roleName));

        userService.saveUser(customer);

        response.put("status", "success");
        response.put("message", "User registered successfully");
        return ResponseEntity.ok(response);
    }
}