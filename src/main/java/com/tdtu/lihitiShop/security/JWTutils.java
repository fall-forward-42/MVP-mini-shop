package com.tdtu.lihitiShop.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Objects;
import java.util.function.Function;

@Component
public class JWTutils {
    private SecretKey key;
    private static final long EXPIRATION_TIME = 846000000; //24 hours
    public JWTutils(){
        String secretString = "02739c146689b11a898032e1e48537cd3598955be26b51f9c6f2803da42f1a3e50f1de16c15851106ab1ca75437a98f5925c456c75f57e4f2f27dae787f008c4c168cc26085a886348f21a7a87710ec7f1877b36b77e8b4ad7e628368af4b7bab35c901529535068eabf7844f2caa807af8dd5d466247e4d85dc7d40a82f461c6f2476930bdbbe5eb7df834a42c3142bd38b48f12304c1f4a42462c2858a09273605eb2c34af3e0e7f3fd15a03fc20c01d33224feb0d6183fa2156a8612cd2726a2981df9ee9dd6f1b6b2ec8f4c72b8a695f3e427e5279a81cbb779430be25678c8e8392d54e464bc645def26b2b2ac02658451c449ae8dc031c45343fb470fa";
        byte[] keyBytes = Base64.getDecoder().decode(secretString.getBytes(StandardCharsets.UTF_8));
        this.key = new SecretKeySpec(keyBytes,"HmacSHA256");

    }
    public String generateToken(UserDetails userDetails){
        return Jwts.builder()
                .subject(userDetails.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+ EXPIRATION_TIME))
                .signWith(key)
                .compact();
    }
    public String generateRefreshToken(HashMap<String, Objects> claims, UserDetails userDetails){
        return Jwts.builder()
                .claims(claims)
                .subject(userDetails.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+ EXPIRATION_TIME))
                .signWith(key)
                .compact();
    }
    public <T> T extractClaims(String token, Function<Claims,T> claimsTFunction){
        return claimsTFunction.apply(Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload()
        );
    }
    public String  extractUsername(String token){
        return extractClaims(token,Claims::getSubject);
    }
    public boolean isTokenValid(String token, UserDetails userDetails){
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())  && !isTokenExpire(token)  );
    }
    public boolean isTokenExpire(String token){
        return extractClaims(token,Claims::getExpiration).before(new Date());
    }

}
