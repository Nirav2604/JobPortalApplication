package com.Portal.JobPortalApplication.security;

import com.Portal.JobPortalApplication.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class JwtService {

    private static final String SECRET_KEY = "mysecretkeymysecretkeymysecretkey123456";
    private final Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

    //for generating tokens
    //token validity is 10hours
    public String generateToken(User user){
        return Jwts.builder()
                .setSubject(user.getEmail())
                .claim("role",user.getRole().name())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    private Claims getClaims(String token){
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJwt(token)
                .getBody();
    }
    public String extractEmail(String token){
        return getClaims(token).getSubject();
    }

    private boolean isTokenExpired(String token) {
        return getClaims(token).getExpiration().before(new Date());
    }

    public boolean IsTokenValid(String token, User user){
        String email=extractEmail(token);
        return (email.equals(user.getEmail()) && !isTokenExpired(token));
    }




}
