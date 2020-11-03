package com.madauto.madautobackend.dto;

import com.madauto.madautobackend.entities.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private  String Raisonsocial;
    private String lastname;
    private String firstname;
    private String phonenumber;
    private  String Gouvernorat;
    private  String email;
    private String address;
    private String zipcode;
    private String password;

public Client dtotoclient(){
    Client c = new Client();
    c.setZipcode(this.zipcode);
    c.setPassword(this.password);
    c.setGouvernorat(this.Gouvernorat);
    c.setFirstname(this.firstname);
    c.setPhonenumber(this.phonenumber);
    c.setLastname(this.lastname);
    c.setAddress(this.address);
    c.setEmail(this.email);
    c.setRaisonsocial(this.Raisonsocial);
    return c;
}
}
