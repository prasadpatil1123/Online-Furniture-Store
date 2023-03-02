package com.example.demo.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Credential;
import com.example.demo.entities.User;
	
import com.example.demo.repository.UserRepository;
import com.example.demo.services.UserService;


@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;
    
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> loginDetails) {
        String userId = loginDetails.get("userId");
        String password = loginDetails.get("password");

        if (userService.authenticate(userId, password)) {
            int userRole = userService.getUserRole(userId, password);
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


   


