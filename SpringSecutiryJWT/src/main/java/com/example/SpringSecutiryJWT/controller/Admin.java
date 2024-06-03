package com.example.SpringSecutiryJWT.controller;

import com.example.SpringSecutiryJWT.dto.ReqRes;
import com.example.SpringSecutiryJWT.entity.Product;
import com.example.SpringSecutiryJWT.respository.ProductRespo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class Admin {
    @Autowired
    private ProductRespo productRespo;

    @GetMapping("/public/product")
    public ResponseEntity<Object> getAllProducts() {
        return ResponseEntity.ok(productRespo.findAll());
    }
    @PostMapping("/admin/saveproduct")
    public ResponseEntity<Object> signUp(@RequestBody ReqRes productRequest) {
        Product productToSave = new Product();
        productToSave.setName(productRequest.getName());

        return ResponseEntity.ok(productRespo.save(productToSave));
    }
    @GetMapping("/user/alone")
    public ResponseEntity<Object> userAlone() {
        return ResponseEntity.ok("users alone can access this api only");
    }
    @GetMapping("/adminUser/both")
    public ResponseEntity<Object> bothAdminUserApi() {
        return ResponseEntity.ok("both admin can and users can access the api");
    }
}
