package com.example.SpringSecutiryJWT.respository;

import com.example.SpringSecutiryJWT.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRespo extends JpaRepository<Product,Integer> {

}
