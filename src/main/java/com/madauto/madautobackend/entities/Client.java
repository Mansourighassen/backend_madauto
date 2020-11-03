package com.madauto.madautobackend.entities;

import com.madauto.madautobackend.dto.ClientDto;
import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private  String Raisonsocial;
    private String lastname;
    private String firstname;
    private String phonenumber;
    private  String Gouvernorat;
    private  String email;
    private String address;
    private String zipcode;
    private String password;
    @Column
    @Enumerated(value = EnumType.STRING)
    private RecordStatus recordStatus;

    @OneToMany(fetch=FetchType.LAZY,mappedBy = "customer")
    @JsonIgnore
    private Collection<Order> order;

    @Enumerated(value = EnumType.STRING)
    private Roles role;


    public ClientDto clientodto(){
        ClientDto c = new ClientDto();
        c.setEmail(this.email);
        c.setStatus(this.recordStatus.name());
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
