package com.madauto.madautobackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthentificationtokenResponse {
    private String authentificationtoken;
    private String email;
}
