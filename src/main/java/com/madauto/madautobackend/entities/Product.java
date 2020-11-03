package com.madauto.madautobackend.entities;

import com.madauto.madautobackend.dto.Productdto;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
@Builder
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id ;
    private  String name;
    private  String description;
    private  double currentprice;
    private boolean promotion;
    private boolean selected;
    private boolean avaiable;
    private String photoName;
    private String referance;
    private String submarque;
    private String marqueyear;
    private String OE;
    private String spec;



    @Enumerated(value = EnumType.STRING)
    private typeproduit type;
    @ManyToOne
    private  Category category;

    @ManyToOne
    private Productype productype;

    public Productdto maketodto(){
    Productdto pdto = new Productdto();
    pdto.setCategory(String.valueOf(this.category.getId()));
    pdto.setId(String.valueOf(this.id));
    pdto.setPromotion(this.promotion);
    pdto.setSubmarque(this.submarque);
    pdto.setRef(this.referance);
    pdto.setPhotoName(this.photoName);
    return pdto;
}


}
