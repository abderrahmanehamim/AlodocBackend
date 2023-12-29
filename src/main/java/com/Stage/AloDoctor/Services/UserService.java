package com.Stage.AloDoctor.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Stage.AloDoctor.models.User;
import com.Stage.AloDoctor.repositories.UserRepository;

import java.util.Collection;
import java.util.Collections;
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Authentication authenticateUser(String email, String password) {
        // Your authentication logic here
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));

        // Compare the provided password with the stored password
        if (!password.equals(user.getPassword())) {
            // Handle incorrect password
            throw new IllegalArgumentException("Incorrect password");
        }

        // Return an Authentication object using UsernamePasswordAuthenticationToken
        Collection<? extends GrantedAuthority> authorities =
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + user.getRole().name()));

        return new UsernamePasswordAuthenticationToken(user, password, authorities);
    }
}