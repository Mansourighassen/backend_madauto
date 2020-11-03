package com.madauto.madautobackend.Services;

import com.madauto.madautobackend.dao.ClientRepository;
import com.madauto.madautobackend.dto.*;
import com.madauto.madautobackend.entities.Client;
import com.madauto.madautobackend.entities.RecordStatus;
import com.madauto.madautobackend.security.JwtProvider;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;

@Service
@AllArgsConstructor
public class AuthService {

    private final PasswordEncoder passwordEncoder;
    private final ClientRepository clientRepository;
    private  final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;
    private final RefreshTokenService refreshTokenService;
    @Transactional
    public void signup(RegisterRequest registerRequest){
        Client client = registerRequest.dtotoclient();
        client.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        client.setRecordStatus(RecordStatus.inactive);
        clientRepository.save(client);



    }

    public Boolean isclientexist(RegisterRequest registerRequest){
        return clientRepository.findClientByEmail(registerRequest.getEmail()).isPresent();
    }

    public AuthenticationResponse login(LoginRequest loginRequest) {
        System.out.println("dd5al");
       Authentication authentication =  authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token =jwtProvider.generateToken(authentication);
        return  new AuthenticationResponse().builder().authenticationToken(token).refreshToken(refreshTokenService.generateRefreshToken().getToken()).expiresAt(Instant.now().plusMillis(jwtProvider.getJwtExpirationInMillis()))
                .username(loginRequest.getEmail()).build();
    }

    public AuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
        refreshTokenService.validateRefreshToken(refreshTokenRequest.getRefreshToken());
        String token = jwtProvider.generateTokenWithUserName(refreshTokenRequest.getUsername());
        return AuthenticationResponse.builder()
                .authenticationToken(token)
                .refreshToken(refreshTokenRequest.getRefreshToken())
                .expiresAt(Instant.now().plusMillis(jwtProvider.getJwtExpirationInMillis()))
                .username(refreshTokenRequest.getUsername())
                .build();
    }


}
