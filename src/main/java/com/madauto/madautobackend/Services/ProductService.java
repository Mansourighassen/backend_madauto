package com.madauto.madautobackend.Services;

import com.madauto.madautobackend.dao.CategoryRepository;
import com.madauto.madautobackend.dao.ProductRepository;
import com.madauto.madautobackend.dto.Productdto;
import com.madauto.madautobackend.entities.Product;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class ProductService {
private final    ProductRepository pr ;
private final CategoryRepository cs;
    public Product getproductbyid(Long id){
        Product p = pr.findProductById(id);
        p.setCategory(null);
       // System.out.println(pr.findProductById(id));
        return p;
    }
@Transactional
    public void addproduct(Productdto prod){
        Product produit = new Product();
        produit.setSubmarque(prod.getSubmarque());
        produit.setCategory(cs.findByName(prod.getCategory()));
        produit.setPhotoName(prod.getPhotoName());
        produit.setReferance(prod.getRef());
        pr.save(produit);

    }


 @Transactional
    public  void editproduct(Productdto p ){
        Product produit = pr.findProductByReferance(p.getRef());
        produit.setPhotoName(p.getPhotoName());
        produit.setReferance(p.getRef());
        produit.setSubmarque(p.getSubmarque());
        produit.setPromotion(p.isPromotion());
        produit.setCategory(cs.findByName(p.getCategory()));




 }


 @Transactional
    public void deleteproduct(Productdto p ){
        pr.delete(pr.findProductByReferance(p.getRef()));
 }




}
