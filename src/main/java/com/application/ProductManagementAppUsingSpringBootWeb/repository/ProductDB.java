package com.application.ProductManagementAppUsingSpringBootWeb.repository;

import com.application.ProductManagementAppUsingSpringBootWeb.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductDB extends JpaRepository<Product, Integer> {
    Product findByName(String name);
    List<Product> findByPlace(String place);
    List<Product> findByType(String type);
}
