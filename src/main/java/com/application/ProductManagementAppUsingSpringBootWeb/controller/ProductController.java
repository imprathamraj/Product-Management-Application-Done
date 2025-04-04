package com.application.ProductManagementAppUsingSpringBootWeb.controller;

import com.application.ProductManagementAppUsingSpringBootWeb.service.ProductService;
import com.application.ProductManagementAppUsingSpringBootWeb.entity.Product;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping
    public List<Product> getAllProduct() {
        return service.getAllProduct();
    }

    @GetMapping("/{name}")
    public Product getProductByName(@PathVariable String name) {
        return service.getProductByName(name);
    }

    @GetMapping("/place/{place}")
    public List<Product> getProductByPlace(@PathVariable String place) {
        return service.getProductByPlace(place);
    }

    @GetMapping("/type/{type}")
    public List<Product> getProductByType(@PathVariable String type) {
        return service.getProductByType(type);
    }

    @GetMapping("/expired-warranty")
    public List<Product> getProductByExpiredWarranty() {
        return service.getProductByExpiredWarranty();
    }

    @GetMapping("/search/{text}")
    public List<Product> getProductByText(@PathVariable String text) {
        return service.getProductByText(text);
    }

    @PostMapping("/add")
    public void addProduct(@RequestBody Product product) {
        service.addProduct(product);
    }

    @GetMapping("csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }
}
