package com.example.demo.demoapi.service;

import com.example.demo.demoapi.dto.Animal;

public interface DemoService {
    void testDemo();

    String getStr();

    Animal getAnimal();

    int error();

    void empty();
}
