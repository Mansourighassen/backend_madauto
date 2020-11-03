package com.madauto.madautobackend.dao;

import com.madauto.madautobackend.entities.OrderItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RepositoryRestResource
public interface OrderItemsRepository extends JpaRepository<OrderItems,Long> {




}
