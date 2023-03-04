package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Seller;
import com.example.demo.exceptions.EmailAlreadyExistsException;
import com.example.demo.services.SellerService;


@CrossOrigin
@RestController
@RequestMapping("/api/sellers")
public class SellerController {
    @Autowired
    private SellerService sellerService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Seller seller) {
        try {
            // Register the new Seller
            sellerService.registerSeller(seller);
        } catch (EmailAlreadyExistsException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

        return ResponseEntity.ok("Seller registered successfully");
    }
}
