package com.madauto.madautobackend.entities;

import com.madauto.madautobackend.dto.Orderitemdto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.weaver.ast.Or;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItems implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column
    private Integer quantity;

    @Column
    private float price;

    @OneToOne
    Product product;

    @ManyToOne
    Order orders;

    public Orderitemdto makedto(){
        Orderitemdto orderitemdto = new Orderitemdto();
        orderitemdto.setProductid(String.valueOf(this.getProduct().getId()));
        orderitemdto.setQuantity(String.valueOf(this.getQuantity()));
        return  orderitemdto;
    }

}
