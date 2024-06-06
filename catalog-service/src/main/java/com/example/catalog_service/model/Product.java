package com.example.catalog_service.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("/eurekaOrders")
@Getter
@Setter
public class Product {
    private String id;
    private String name;
    private String category;
    private String color;
    private double price;

}