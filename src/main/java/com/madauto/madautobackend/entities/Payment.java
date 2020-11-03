package com.madauto.madautobackend.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(precision=2)
    private float amount;

    @Column
    private LocalDate paymentDate;

    @Column
    private Status status;

    @Column
    private RecordStatus recordStatus;

//    @OneToOne(mappedBy = "payment")
//    Order order;

    @OneToOne
    User customer;
}
