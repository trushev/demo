package com.example.demo.entity;

import com.example.demo.exception.NotEnoughProductException;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String name;

    private Double price;

    private Long inStock;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty())
            this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        if (price != null && price >= 0)
            this.price = price;
    }

    public Long getInStock() {
        return inStock;
    }

    public void setInStock(Long in_stock) {
        if (in_stock != null && in_stock >= 0)
            this.inStock = in_stock;
    }

    public void buy(Long amount) {
        Long newInStock = inStock - amount;
        if (newInStock < 0)
            throw new NotEnoughProductException(inStock, amount);
        this.inStock = newInStock;
    }
}
