package com.madauto.madautobackend.dao;

import com.madauto.madautobackend.entities.Category;
import com.madauto.madautobackend.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RepositoryRestResource
public interface CategoryRepository extends JpaRepository<Category,Long> {
    public Category findByName(String name);
}
