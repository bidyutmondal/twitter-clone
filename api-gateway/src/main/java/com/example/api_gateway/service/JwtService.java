package com.example.api_gateway.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String jwtSecret;

    public boolean validateToken(String token) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(jwtSecret)
                    .parseClaimsJws(token)
                    .getBody();

            // Check if the token has expired
            if (claims.getExpiration().before(new Date())) {
                return false;
            }

            // Add any additional validation logic here
            // For example, you might want to check the issuer, audience, or any custom claims

            return true;
        } catch (SignatureException e) {
            // Invalid signature
            return false;
        } catch (Exception e) {
            // Other exceptions (e.g., ExpiredJwtException, MalformedJwtException)
            return false;
        }
    }

    public String getUserIdFromToken(String token) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(jwtSecret)
                    .parseClaimsJws(token)
                    .getBody();

            return claims.getSubject();
        } catch (Exception e) {
            return null;
        }
    }

    // You can add more methods here as needed, such as:
    // - Getting other claims from the token
    // - Generating new tokens (if your gateway needs to do this)
}