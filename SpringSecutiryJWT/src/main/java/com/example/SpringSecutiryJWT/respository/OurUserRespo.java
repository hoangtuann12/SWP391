package com.example.SpringSecutiryJWT.respository;

import com.example.SpringSecutiryJWT.entity.OurUsers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OurUserRespo  extends JpaRepository<OurUsers,Integer> {
Optional<OurUsers> findByEmail(String email);


}
