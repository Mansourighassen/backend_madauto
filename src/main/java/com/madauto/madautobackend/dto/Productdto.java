package com.madauto.madautobackend.dto;

import com.madauto.madautobackend.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Productdto {
    private String id ;
    private String photoName;
    private String ref;
    private String submarque;
    private boolean promotion;
    private String category;


public Long getidl(){

    return Long.valueOf(this.id);
}




}
