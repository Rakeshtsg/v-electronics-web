package com.velectronics.security;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;
import java.util.Date;
@Component
public class JwtUtil {
    private final String SECRET = "velectronics-very-secret-key";
    public String generateToken(String username) {
        return Jwts.builder().setSubject(username)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + 1000L*60*60*8))
            .signWith(SignatureAlgorithm.HS256, SECRET).compact();
    }
    public String extractUsername(String token) {
        try { return Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody().getSubject(); }
        catch(Exception e) { return null; }
    }
}
