package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Seller;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Integer>{
	    Optional<Seller> findByEmail(String email);
	    Seller save(Seller s);
}
