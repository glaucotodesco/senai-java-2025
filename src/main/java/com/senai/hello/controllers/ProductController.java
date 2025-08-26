package com.senai.hello.controllers;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.hello.entities.Product;
import com.senai.hello.repositories.ProductRepository;
import com.senai.hello.services.ProductService;



@RestController
@RequestMapping("products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        return ResponseEntity.ok(service.getProducts());
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> getProductById(@PathVariable long id) {
        return ResponseEntity.ok(service.getProductById(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable long id)
    {
        service.deleteProductById(id);
        return ResponseEntity.noContent().build();
    }


    @PostMapping
    public ResponseEntity<Product> saveProduct(@RequestBody Product product)
    {
        Product newProduct = service.saveProduct(product);
        return ResponseEntity.created(null)
                             .body(newProduct);
    }



}
