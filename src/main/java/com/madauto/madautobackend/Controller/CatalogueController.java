package com.madauto.madautobackend.Controller;

import com.madauto.madautobackend.dao.CategoryRepository;
import com.madauto.madautobackend.dao.ProductRepository;
import com.madauto.madautobackend.entities.Product;
import com.madauto.madautobackend.entities.typeproduit;
import org.springframework.data.annotation.Transient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.annotation.XmlTransient;
import java.awt.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CatalogueController {
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    public  CatalogueController(ProductRepository productRepository,CategoryRepository categoryRepository){
        this.productRepository=productRepository;
        this.categoryRepository=categoryRepository;
    }
    @GetMapping(path="/photoProduct/{id}",produces = MediaType.IMAGE_GIF_VALUE)
    public byte[] getphoto(@PathVariable("id") Long id) throws Exception{
        Product p = productRepository.findById(id).get();
        return Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/madautoimg/product/"+p.getPhotoName()));

    }

    @GetMapping(path="  ",produces ={ "application/json"})
    @CrossOrigin("*")


    public typeproduit[] gettypesproduits(){
        typeproduit[]types=  typeproduit.values();
        return types;
    }

//    @GetMapping(path="/products/filtera",produces ={ "application/json"})
//    @CrossOrigin("*")
//    @XmlTransient
//    public  List<Product> filtrerproduits(@RequestParam("cat") String cat){
//        List<Product> lp = new ArrayList<>();
//      productRepository.findProductByCategoryName(cat).forEach(product -> lp.add(product) );
//        System.out.println(lp.size());
//        return  lp;
//    }





}
