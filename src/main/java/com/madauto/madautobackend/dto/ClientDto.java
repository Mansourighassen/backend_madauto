package com.madauto.madautobackend.dto;

import com.madauto.madautobackend.entities.Client;
import com.madauto.madautobackend.entities.RecordStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDto {
    private String Raisonsocial;
    private String lastname;
    private String firstname;
    private String phonenumber;
    private String Gouvernorat;
    private String email;
    private String address;
    private String zipcode;
    private String status;



    public Client dtotoclient(){
        Client c = new Client();
        c.setEmail(this.email);
        c.setRecordStatus(RecordStatus.valueOf(this.status));
        c.setRaisonsocial(this.Raisonsocial);
        c.setLastname(this.lastname);
        c.setFirstname(this.firstname);
        c.setAddress(this.address);
        c.setPhonenumber(this.phonenumber);
        c.setGouvernorat(this.Gouvernorat);
        c.setZipcode(this.zipcode);
        return c;
    }
}


