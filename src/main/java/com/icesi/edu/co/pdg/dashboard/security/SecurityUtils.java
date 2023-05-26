package com.icesi.edu.co.pdg.dashboard.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtils {

    public static SaamfiUserDetails getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !(authentication.getPrincipal() instanceof SaamfiUserDetails)) {
            return null;
        }
        return (SaamfiUserDetails) authentication.getPrincipal();
    }
}
