package com.madauto.madautobackend.security;

import com.madauto.madautobackend.exceptions.Excep;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;

import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.security.*;
import java.security.cert.CertificateException;
import java.time.Instant;
import java.util.Date;

import static io.jsonwebtoken.Jwts.parser;
import static java.util.Date.from;

@Service
public class JwtProvider {



    private KeyStore keyStore;
    @Value("${jwt.expiration.time}")
    private Long jwtExpirationInMillis;

    @PostConstruct
    public void init() {
        try {
            keyStore = KeyStore.getInstance("JKS");
            InputStream ressourceastream = getClass().getResourceAsStream("/madauto.jks");
            keyStore.load(ressourceastream, "160419".toCharArray());
        }catch (KeyStoreException| CertificateException|NoSuchAlgorithmException| IOException e){
            throw  new Excep("Exception occured while loading keystore");
        }

    }


    private PrivateKey getPrivateKey() {
        try {
            return (PrivateKey) keyStore.getKey("madauto", "160419".toCharArray());
        } catch (KeyStoreException | NoSuchAlgorithmException | UnrecoverableKeyException e) {
            throw new Excep("Exception occured while retrieving public key from keystore");
        }
    }


    private PublicKey getPublickey() {
        try {
            return keyStore.getCertificate("madauto").getPublicKey();
        } catch (KeyStoreException e) {
            throw new Excep("Exception occured while " +
                    "retrieving public key from keystore");
        }
    }

    public String getUsernameFromJwt(String token) {
        Claims claims = parser()
                .setSigningKey(getPublickey())
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

    public String generateTokenWithUserName(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(from(Instant.now()))
                .signWith(getPrivateKey())
                .setExpiration(Date.from(Instant.now().plusMillis(jwtExpirationInMillis)))
                .compact();
    }

    public String generateToken(Authentication authentication) {
        org.springframework.security.core.userdetails.User principal = (User) authentication.getPrincipal();
        return Jwts.builder()
                .setSubject(principal.getUsername())
                .setIssuedAt(from(Instant.now()))
                .signWith(getPrivateKey())
                .setExpiration(Date.from(Instant.now().plusMillis(jwtExpirationInMillis)))
                .compact();
    }



//
//    public String generateToken(Authentication authentication){
//        User principal = (User) authentication.getPrincipal();
//        return Jwts.builder().setSubject(principal.getUsername()).signWith(key).compact();
//    }

    public boolean validateToken(String jwt) {
        parser().setSigningKey(getPublickey()).parseClaimsJws(jwt);
        return true;
    }

    public Long getJwtExpirationInMillis() {
        return jwtExpirationInMillis;
    }


}
