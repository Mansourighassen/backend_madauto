package com.madauto.madautobackend.dao;

import com.madauto.madautobackend.entities.ProductStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RepositoryRestResource
public interface ProductStockRepository extends JpaRepository<ProductStock,Long> {




}
