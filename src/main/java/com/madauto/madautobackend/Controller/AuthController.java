package com.madauto.madautobackend.Controller;

import com.madauto.madautobackend.Services.AuthService;
import com.madauto.madautobackend.Services.RefreshTokenService;
import com.madauto.madautobackend.dto.*;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
@CrossOrigin("*")
public class AuthController {
    private final AuthService authService;
    private  final RefreshTokenService refreshTokenService;
    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody RegisterRequest registerRequest){
            if(this.authService.isclientexist(registerRequest)){
                return new ResponseEntity<>("{'message': 'email is used'}", HttpStatus.FOUND);
            }
            authService.signup(registerRequest);
         return new ResponseEntity<>("{{'message': 'User Registration Successful'}}", HttpStatus.OK);
    }

   @PostMapping("/login")
   public AuthenticationResponse singin (@RequestBody LoginRequest loginRequest){
       AuthenticationResponse login = authService.login(loginRequest);
       return login;

   }
    @PostMapping("refresh/token")
    public AuthenticationResponse refreshTokens(@Valid @RequestBody RefreshTokenRequest refreshTokenRequest) {
        return authService.refreshToken(refreshTokenRequest);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(@Valid @RequestBody RefreshTokenRequest refreshTokenRequest) {
        refreshTokenService.deleteRefreshToken(refreshTokenRequest.getRefreshToken());
        return ResponseEntity.status(HttpStatus.OK).body("Refresh Token Deleted Successfully!!");
    }

}
