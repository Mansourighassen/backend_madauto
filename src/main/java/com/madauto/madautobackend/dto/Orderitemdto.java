package com.madauto.madautobackend.dto;

import com.madauto.madautobackend.entities.OrderItems;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orderitemdto {
    String productid;
    String quantity;


}
