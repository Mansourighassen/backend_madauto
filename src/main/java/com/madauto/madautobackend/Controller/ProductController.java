package com.madauto.madautobackend.Controller;

import com.madauto.madautobackend.Services.ProductService;
import com.madauto.madautobackend.dao.ProductRepository;
import com.madauto.madautobackend.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.hateoas.HypermediaAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@EnableAutoConfiguration(exclude = HypermediaAutoConfiguration.class)

@RestController

public class ProductController {
    @Autowired
    ProductService ps ;
    @GetMapping(path = "/prods/productdetail",produces ={ "application/json"})
    @CrossOrigin("*")

    public Product getproductbyid(@RequestParam("id") Long id){
        return ps.getproductbyid(id);

    }





}
