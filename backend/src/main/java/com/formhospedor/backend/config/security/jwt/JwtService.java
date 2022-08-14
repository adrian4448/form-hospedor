package com.formhospedor.backend.config.security.jwt;

import com.formhospedor.backend.model.AppUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Service
public class JwtService {

    @Value("${auth.expiration_minutes}")
    private String EXPIRATION;

    @Value("${auth.secret_key}")
    private String SIGNATURE_KEY;

    public String generateToken(AppUser user) {
        Long expLong = Long.valueOf(EXPIRATION);
        LocalDateTime expirationDate = LocalDateTime.now().plusMinutes(expLong);
        Date data = Date.from(expirationDate.atZone(ZoneId.systemDefault()).toInstant());

        return Jwts
                .builder()
                .setSubject(user.getUserName())
                .setExpiration(data)
                .signWith(SignatureAlgorithm.HS512, SIGNATURE_KEY)
                .compact();
    }

    private Claims getClaims(String token) throws ExpiredJwtException {
        return Jwts
                .parser()
                .setSigningKey(SIGNATURE_KEY)
                .parseClaimsJws(token)
                .getBody();
    }

    boolean tokenIsValid(String token) {
        try {
            Date expirationDate = getClaims(token).getExpiration();

            LocalDateTime localDateTime = expirationDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

            return !LocalDateTime.now().isAfter(localDateTime);
        } catch(Exception e) {
            return false;
        }
    }

    public String getUserLogin(String token) throws ExpiredJwtException {
        return getClaims(token).getSubject();
    }

}
