package com.icesi.edu.co.pdg.dashboard.security;

import java.io.IOException;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.impl.DefaultJwtParser;

public class JwtAuthenticationFilter extends OncePerRequestFilter {
	
	@Value("${saamfi.api.url}")
	private String saamfiUrl;
	@Value("${saamfi.api.institutions.icesi.id}")
    private String institutionId;
	
	public JwtAuthenticationFilter(String saamfiUrl, String instId) {
		this.saamfiUrl = saamfiUrl;
		this.institutionId = instId;
	}
    
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String header = request.getHeader("Authorization");

        if (header == null || !header.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        try {
            String token = header.replace("Bearer ", "");
            validateToken(token);
        } catch (RuntimeException e) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Unauthorized - " + e.getMessage());
            return;
        }

        filterChain.doFilter(request, response);
    }
    
    public Claims decodeTokenClaims(String token) {
    	String[] splitToken = token.split("\\.");
    	String unsignedToken = splitToken[0] + "." + splitToken[1] + ".";

    	DefaultJwtParser parser = new DefaultJwtParser();
            Jwt<?, ?> jwt = parser.parse(unsignedToken);
            Claims claims = (Claims) jwt.getBody();
    	return claims;
    }

    private void validateToken(String token) {
    	
        try {
        	
        	 String publicKey = getPublicKey();
        	 
        	 Claims body = decodeTokenClaims(token);
             System.out.println("PASO");
            
             String persId = body.get("persId", String.class);
             String role = body.get("role", String.class) + "ROLE_Default";
             Integer system = body.get("system", Integer.class);
             Integer institution = body.get("institution", Integer.class);
             String username = body.get("username", String.class);
             
             SaamfiUserDetails userDetails = new SaamfiUserDetails();
             userDetails.setPersId(persId);
             userDetails.setRole(role);
             userDetails.setSystem(system);
             userDetails.setInstitution(institution);
             userDetails.setUsername(username);

             // Estableciendo detalles de usuario en el contexto de seguridad
             Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
             SecurityContextHolder.getContext().setAuthentication(authentication);

        } catch (JwtException e) {
        	System.out.println(e.getMessage());
            throw new RuntimeException("Token inválido", e);
        }
    }
    
    private String getPublicKey() {
        RestTemplate restTemplate = new RestTemplate();
        String url = saamfiUrl + "/public/institutions/" + institutionId + "/recaptcha/public-key";
        System.out.println("URL: "+url);
        return restTemplate.getForObject(url, String.class);
    }

}
