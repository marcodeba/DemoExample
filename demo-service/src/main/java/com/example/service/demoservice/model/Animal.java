package com.example.service.demoservice.model;

import lombok.Data;

@Data
public class Animal {
    private int id;
    private String name;

    public Animal(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
