package com.example.service.demoservice.controller;

import com.example.service.demoservice.pojo.Animal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class DemoController {

    @GetMapping("/hello")
    public String getStr() {
        return "hello,javadaily";
    }

    @GetMapping("/animal")
    public Animal getAnimal() {
        Animal animal = new Animal(1, "pig");
        log.info("animal is {}", animal);
        return animal;
    }

    @GetMapping("/wrong")
    public int error() {
        int i;
        try {
            i = 9 / 0;
        } catch (Exception e) {
            log.error("error:{}", e);
            throw new ArithmeticException("divided by 0");
        }
        return i;
    }

    @GetMapping("error1")
    public void empty() {
        throw new RuntimeException("自定义异常");
    }
}
