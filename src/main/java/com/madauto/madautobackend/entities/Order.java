package com.madauto.madautobackend.entities;

import com.madauto.madautobackend.dto.Orderitemdto;
import com.madauto.madautobackend.dto.OrdersDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Entity(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalDate orderDate;

    @Column(length=2000)
    private String shipToAddress;

    @Column
    private LocalDate shipToDate;

    @Column

    private String Telephone;
    @Column

    private String zipcode;
    @Column

    private String gouvernorat;
    @Column

    private  String company;
    @Column
    @Enumerated(EnumType.STRING)
    private Status recordStatus;


    @ManyToOne()
    Client customer;



    @OneToMany(mappedBy = "orders",fetch = FetchType.LAZY)
    private Collection<OrderItems> orderItems;

    public OrdersDto makedto(){
        OrdersDto ordersDto = new OrdersDto();
        List<Orderitemdto> loidto = new ArrayList<>();
        this.orderItems.forEach(order -> {
            loidto.add(order.makedto());
        });
        ordersDto.setId(String.valueOf(this.getId()));
        ordersDto.setCompany(this.company);
        ordersDto.setTelephone(this.getTelephone());
        ordersDto.setGouvernorat(this.gouvernorat);
        ordersDto.setZipcode(this.zipcode);
        ordersDto.setOrderItems(loidto);
        ordersDto.setStatus(String.valueOf(this.recordStatus));
        ordersDto.setCreatedate(String.valueOf(this.getOrderDate()));
        ordersDto.setClientid(String.valueOf(this.customer.getId()));
        ordersDto.setShipToAddress(this.getShipToAddress());

        return ordersDto;
    }
}
