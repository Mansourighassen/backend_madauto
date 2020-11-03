package com.madauto.madautobackend.dao;

import com.madauto.madautobackend.entities.Client;
import com.madauto.madautobackend.entities.Order;
import com.madauto.madautobackend.entities.Product;
import com.madauto.madautobackend.entities.typeproduit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RepositoryRestResource
public interface OrderRepository extends JpaRepository<Order,Long> {
 List<Order> findByCustomer(Client c);





}
