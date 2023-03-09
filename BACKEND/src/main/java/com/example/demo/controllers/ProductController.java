package com.example.demo.controllers;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.ProductDTO;
import com.example.demo.entities.Product;
import com.example.demo.entities.Seller;
import com.example.demo.services.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/search")
    public List<ProductDTO> searchByCategoryName(@RequestParam String categoryName) {
        List<Product> products = productService.searchByCategoryName(categoryName);
        List<ProductDTO> responses = new ArrayList<>();
        for (Product product : products) {
            ProductDTO response = new ProductDTO();
            response.setProductImage(product.getProductImage());
            response.setPname(product.getPname());
            response.setDescription(product.getDescription());
            response.setSeller(product.getSeller());
            response.setCategory(product.getCategory());
            responses.add(response);
        }
        return responses;
    }
}



















//@CrossOrigin(origins = "http://localhost:3000")
//@RestController
//@RequestMapping("/api/sellers")
//public class ProductController {
//
//    private final ProductService productService;
//    
//    public ProductController(ProductService productService) {
//        this.productService = productService;
//    }
//
//    @PostMapping("/products")
//    public Product addProduct(@RequestBody Product product, @RequestParam("sellerId") int sellerId) {
//        Product newProduct = productService.addProduct(product, sellerId);
//        return newProduct;
//    }
//}
