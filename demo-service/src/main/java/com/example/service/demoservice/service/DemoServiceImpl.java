package com.example.service.demoservice.service;

import com.example.demo.demoapi.dto.Animal;
import com.example.demo.demoapi.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author：marco.pan
 * @ClassName：DemoServiceImpl
 * @Description：
 * @date: 2021年10月12日 3:31 下午
 */
@Service
@Slf4j
public class DemoServiceImpl implements DemoService {
    @Override
    public void testDemo() {
        System.out.println("test Demo");
    }

    @Override
    public String getStr() {
        return "hello,javadaily";
    }

    @Override
    public Animal getAnimal() {
        Animal animal = new Animal(1, "pig");
        log.info("animal is {}", animal);
        return animal;
    }

    @Override
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

    @Override
    public void empty() {
        throw new RuntimeException("自定义异常");
    }
}
