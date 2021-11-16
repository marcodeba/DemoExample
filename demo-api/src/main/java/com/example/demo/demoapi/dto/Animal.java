package com.example.demo.demoapi.dto;

import lombok.Data;

/**
 * @author：marco.pan
 * @ClassName：Animal
 * @Description：
 * @date: 2021年11月16日 10:28 上午
 */
@Data
public class Animal {
    private int id;
    private String name;

    public Animal(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
