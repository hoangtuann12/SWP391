package com.example.SpringSecutiryJWT.service;

import com.example.SpringSecutiryJWT.dto.ReqRes;
import com.example.SpringSecutiryJWT.entity.OurUsers;
import com.example.SpringSecutiryJWT.respository.OurUserRespo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class AuthService {
    @Autowired
    private OurUserRespo ourUserRespo;

    @Autowired
    private JWTUtils jwtUtils;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;

    public ReqRes signUp(ReqRes regístrationRequest) {
        ReqRes resp = new ReqRes();
        try{
            OurUsers ourUser  = new OurUsers();
            ourUser.setEmail(regístrationRequest.getEmail());
            ourUser.setPassword(passwordEncoder.encode(regístrationRequest.getPassword()));
            ourUser.setRole(regístrationRequest.getRole());
            OurUsers ourUsersResult = ourUserRespo.save(ourUser);
            if(ourUsersResult !=null && ourUsersResult.getId()>0) {
                resp.setOurusers(ourUsersResult);
                resp.setMessage("users save successfully");
                resp.setStatusCode(200);
            }

        }catch (Exception e) {
            resp.setStatusCode(500);
            resp.setError(e.getMessage());

        }
        return resp;
    }
    public ReqRes signIn(ReqRes siginRequest) {
        ReqRes response = new ReqRes();
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(siginRequest.getEmail(),siginRequest.getPassword()));
            var user = ourUserRespo.findByEmail(siginRequest.getEmail()).orElseThrow();
            System.out.println("user is " + user);
            var jwt = jwtUtils.generateToken(user);
            var refreshToken = jwtUtils.generateRefreshToken(new HashMap<>(),user);
            response.setStatusCode(200);
            response.setToken(jwt);
            response.setRefreshtoken(refreshToken);
            response.setExpirationTime("24Hr");
            response.setMessage("Success signed in");


        }catch (Exception e) {
            response.setStatusCode(500);
            response.setError(e.getMessage());
        }
        return response;
    }
    public ReqRes refreshToken(ReqRes refreshTokenRequest) {
        ReqRes response = new ReqRes();
        String ourEmail = jwtUtils.extractUserName(refreshTokenRequest.getToken());
        OurUsers users = ourUserRespo.findByEmail(ourEmail).orElseThrow();
        if(jwtUtils.isTokenValid(refreshTokenRequest.getToken(),users)){
            var jwt = jwtUtils.generateToken(users);
            response.setStatusCode(200);
            response.setToken(jwt);
            response.setRefreshtoken(refreshTokenRequest.getToken());
            response.setExpirationTime("24Hr");
            response.setMessage("Success refreshed in");

        }
        response.setStatusCode(500);
        return response;
    }
}
