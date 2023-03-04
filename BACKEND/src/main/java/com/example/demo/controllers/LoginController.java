package com.example.demo.controllers;


import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.LoginService;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {
    @Autowired
    private LoginService userService;
    
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> loginDetails) {
        String email = loginDetails.get("email");
        String password = loginDetails.get("password");

        if (userService.authenticate(email, password)) {
            int userRole = userService.getUserRole(email, password);
            if (userRole == 1) {
                return ResponseEntity.ok("admin");
            } 
            else if (userRole==2) {
            	return ResponseEntity.ok("seller");
            }
            else if (userRole==3) {
            	return ResponseEntity.ok("carpenter");
            }
            else  {
                return ResponseEntity.ok("customer");
            }
        } else {
            return ResponseEntity.badRequest().body("Invalid login details");
        }
    }
    
        
    

}


   


