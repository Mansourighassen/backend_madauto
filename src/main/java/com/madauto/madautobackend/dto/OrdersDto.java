package com.madauto.madautobackend.dto;

import com.madauto.madautobackend.entities.Order;
import com.madauto.madautobackend.entities.OrderItems;
import com.madauto.madautobackend.entities.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.Collection;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class OrdersDto {
    private String id ;
    private String shipToAddress;
    private String createdate;
    private Collection<Orderitemdto> orderItems;
    private String status;
    private String Clientid;
    private String email;
    private String Telephone;
    private String zipcode;
    private String gouvernorat;
    private  String company;



    public Order makeobj(){
        Order order = new Order();
        order.setShipToAddress(this.shipToAddress);
        order.setOrderDate(LocalDate.parse(this.createdate));
        order.setRecordStatus(Status.valueOf(status));
        order.setCompany(this.company);
        order.setTelephone(this.getTelephone());
        order.setGouvernorat(this.gouvernorat);
        order.setZipcode(this.zipcode);
        return order;
    }
}
