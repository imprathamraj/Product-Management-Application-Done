package com.application.ProductManagementAppUsingSpringBootWeb.service;

import com.application.ProductManagementAppUsingSpringBootWeb.repository.ProductDB;
import com.application.ProductManagementAppUsingSpringBootWeb.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductDB productDB;

    // Adding product
    public void addProduct(Product product) {
        productDB.save(product);
    }

    // Getting all product
    public List<Product> getAllProduct() {
        return productDB.findAll();
    }

    // Getting product with a particular name
    public Product getProductByName(String name){
        return productDB.findByName(name);
    }
    public List<Product> getProductByPlace(String place) {
        return productDB.findByPlace(place);
    }

    public List<Product> getProductByType(String type) {
        return productDB.findByType(type);
    }

    public List<Product> getProductByExpiredWarranty() {
        int currentYear = 2025;
        List<Product> expiredProducts = new ArrayList<>();
        for (Product product : productDB.findAll()) {
            if (product.getWarranty() < currentYear) {
                expiredProducts.add(product);
            }
        }
        return expiredProducts;
    }

    public List<Product> getProductByText(String text) {
        List<Product> productsWithText = new ArrayList<>();
		for(Product product : productDB.findAll()){
			if (product.getName().equalsIgnoreCase(text)){
                productsWithText.add(product);
            }
		}
        return productsWithText;
    }
}
