package com.example.user_service.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {

    private String id;
    private String name;
    private String category;
    private String color;
    private double price;

    public ProductDto(String id, String name, String category, String color, double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.color = color;
        this.price = price;
    }
}