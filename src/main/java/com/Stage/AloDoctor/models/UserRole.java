package com.Stage.AloDoctor.models;

import org.springframework.security.core.GrantedAuthority;

public enum UserRole implements GrantedAuthority{
    ROLE_PATIENT,
    ROLE_DOCTOR,
    ROLE_ADMIN;
    @Override
    public String getAuthority() {
        return name();
    }
}