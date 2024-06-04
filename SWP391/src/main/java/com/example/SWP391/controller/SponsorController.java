package com.example.SWP391.controller;

import com.example.SWP391.payload.Request.SponsorSignUp;
import com.example.SWP391.service.SponsorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api-sponsor")
public class SponsorController {
    @Autowired
    private SponsorService sponsorService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @PostMapping("/sign-up-visitor")
    public ResponseEntity<String> signUpVisitor(@RequestBody SponsorSignUp sponsorSignUp) {
        try {
            sponsorService.signUpSponsor(sponsorSignUp);
            return ResponseEntity.ok("Sponsor signed up successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
