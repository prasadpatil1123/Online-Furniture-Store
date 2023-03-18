package com.example.demo.services;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.SellerDTO;
import com.example.demo.entities.City;
import com.example.demo.entities.Login;
import com.example.demo.entities.Seller;
import com.example.demo.exceptions.EmailAlreadyExistsException;
import com.example.demo.repository.LoginRepository;
import com.example.demo.repository.SellerRepository;

@Service
public class SellerService {
    @Autowired
    private SellerRepository sellerRepository;
    @Autowired
    private LoginRepository loginRepository;	
    @Autowired
    private CityService cityService;

    public void registerSeller(SellerDTO seller) throws EmailAlreadyExistsException {
        // Check if the email is already in use
        Optional<Seller> existingSeller = sellerRepository.findByEmail(seller.getEmail());
        if (existingSeller.isPresent()) {
            throw new EmailAlreadyExistsException("Email is already in use");
        }
        City city = cityService.getCityById(seller.getCity_id());
		Seller s=new Seller();
        s.setCity(city);
        s.setAddress(seller.getAddress());
        s.setContact(seller.getContact());
        s.setEmail(seller.getEmail());
        s.setGstno(seller.getGstno());
        
        
        //encoder
        s.setPassword(seller.getPassword());
        s.setSname(seller.getSname());
        s.setStatus(0);
        s.setRole(2);
        Login cred=new Login();
        cred.setEmail(seller.getEmail());
        cred.setPassword(seller.getPassword());
        cred.setRole(2);
        // Save the new Seller to the database
        sellerRepository.save(s);
        loginRepository.save(cred);
    }
    
    public List<Seller> getAllSellers() {
        return sellerRepository.findAll();
    }
    
    public List<Seller> getSellersByStatus(int status) {
        return sellerRepository.findByStatus(status);
    }
    
    public void approveSeller(int sid) {
        Seller seller = sellerRepository.findById(sid).orElse(null);
        Login login =loginRepository.findEmail(seller.getEmail());
        if (seller != null) {
            seller.setStatus(1);
            login.setStatus(1);
            loginRepository.save(login);
            sellerRepository.save(seller);
        }
    }
    
    public void rejectSeller(int sid) {
        sellerRepository.deleteBySid(sid);
    }
    
    
}
