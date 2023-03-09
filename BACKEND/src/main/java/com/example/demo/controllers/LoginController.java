package com.example.demo.controllers;


import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.LoginResponse;
import com.example.demo.repository.SellerRepository;
import com.example.demo.services.LoginService;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {
    @Autowired
    private LoginService userService;
    @Autowired
    private SellerRepository sellerRepository;
    
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody Map<String, String> loginDetails) {
        String email = loginDetails.get("email");
        String password = loginDetails.get("password");
        int id;

        if (userService.authenticate(email, password)) {
            int userRole = userService.getUserRole(email, password);
            if (userRole == 1) {
                return ResponseEntity.ok(new LoginResponse(0, "admin"));
            } else if (userRole == 2) {
                id = sellerRepository.findSidByEmail(email);
                return ResponseEntity.ok(new LoginResponse(id, "seller"));
            } else if (userRole == 3) {
                return ResponseEntity.ok(new LoginResponse(0, "carpenter"));
            } else {
                return ResponseEntity.ok(new LoginResponse(0, "customer"));
            }
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    
        
    }

}


   


