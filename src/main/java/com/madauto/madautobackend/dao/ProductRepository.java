package com.madauto.madautobackend.dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.madauto.madautobackend.entities.Product;
import com.madauto.madautobackend.entities.typeproduit;
import net.minidev.json.annotate.JsonIgnore;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.hateoas.HypermediaAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@CrossOrigin("*")
@RepositoryRestResource

public interface ProductRepository extends JpaRepository<Product,Long> {

    @RestResource(path="/selectedProducts")
    public List<Product> findBySelectedIsTrue();
    @RestResource(path="/selectedProductsBykeyword")
    public List<Product> findByNameContains(String mc);
    @RestResource(path="/selectedProductsBycat")
    public List<Product> findProductByCategoryNameAndType(@Param("cat")String cat,@Param("type") typeproduit t);

    @RestResource(path="/selectedprodbytype")

    public List<Product> findProductByType(@Param("type") typeproduit t);

    Product findProductById(long id);


    Product findProductByReferance(String ref);


}
