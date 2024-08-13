package com.fis.portal.provider;

import java.util.Date;
import org.springframework.security.core.userdetails.UserDetails;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtProvider {
  private static final String SECRET = "@cCmr25TH04A#";
  private static final long EXPORATION = 900000000; //600s

  public static String generateToken(String username) {
    return "Bearer " + Jwts.builder()
                    .setSubject(username)
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + EXPORATION))
                    .signWith(SignatureAlgorithm.HS512, SECRET)
                    .compact();
  }

  private static Claims getAllClaims(String token) {
    return Jwts.parser()
            .setSigningKey(SECRET)
            .parseClaimsJws(token)
            .getBody();
  }

  public static boolean validateToken(String token, UserDetails userDetails) {
    return getSubject(token).equalsIgnoreCase(userDetails.getUsername())
            && !isTokenExpired(token);
  }

  public static String getSubject(String token) {
    return getAllClaims(token).getSubject();
  }

  private static Date getExpirationDate(String token) {
    return getAllClaims(token).getExpiration();
  }

  private static boolean isTokenExpired(String token) {
    return getExpirationDate(token).before(new Date());
  }
}

