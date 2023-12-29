package com.Stage.AloDoctor.controllers;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Stage.AloDoctor.Services.UserService;
import com.Stage.AloDoctor.models.User;

import com.Stage.AloDoctor.utils.JwtTokenProvider;

@RestController
public class LoginController {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        // Authenticate the user based on role
        Authentication authentication = userService.authenticateUser(user.getEmail(), user.getPassword());

        // Assuming user is authenticated, generate token
        String token = jwtTokenProvider.generateToken(authentication);

        // Redirect logic based on user role
        String redirectUrl = determineRedirectUrl(authentication);

        // Return token and redirect URL
        Map<String, Object> response = new HashMap<>();
        response.put("token", token);
        response.put("redirectUrl", redirectUrl);

        return ResponseEntity.ok(response);
    }

    private String determineRedirectUrl(Authentication authentication) {
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        if (authorities.contains(new SimpleGrantedAuthority("ROLE_PATIENT"))) {
            return "/patient-dashboard";
        } else if (authorities.contains(new SimpleGrantedAuthority("ROLE_DOCTOR"))) {
            return "/doctor-dashboard";
        } else if (authorities.contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
            return "/admin-dashboard";
        } else {
            throw new IllegalStateException("Unexpected user role");
        }
    }
}
