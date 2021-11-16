package com.example.service.demoservice.controller;

import com.example.demo.demoapi.service.DemoService;
import com.example.demo.demoapi.service.dto.Animal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class DemoController {
    private DemoService demoService;

    @Autowired
    public void setDemoService(DemoService demoService) {
        this.demoService = demoService;
    }

    @GetMapping("/hello")
    public String getStr() {
        return demoService.getStr();
    }

    @GetMapping("/animal")
    public Animal getAnimal() {
        return demoService.getAnimal();
    }

    @GetMapping("/wrong")
    public int error() {
        return demoService.error();
    }

    @GetMapping("error1")
    public void empty() {
        demoService.empty();
    }
}
