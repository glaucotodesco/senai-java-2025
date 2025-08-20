package com.senai.hello.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.hello.entity.Product;
import com.senai.hello.repository.ProductRepository;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("products")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @GetMapping
    public List<Product> getProducts() {
        return repository.findAll();
    }

    // @GetMapping("{id}")
    // public Product getProductById(@PathVariable long id) {
    //     return list.stream()
    //              .filter( p -> p.getId() == id)
    //              .findFirst()
    //              .orElseThrow( () -> new EntityNotFoundException("Não cadastrado"));
    // }

}
