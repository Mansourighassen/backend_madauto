package com.madauto.madautobackend.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length=100)
    private String	username;
    @Column(length=100)
    private String	firstname;
    @Column(length=100)
    private String	lastname;

    @Column(length=200)
    private String email;

    @Column(length=15)
    private String phone;

    @Column
    private String password;



}
