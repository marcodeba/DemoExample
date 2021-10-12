package com.example.service.demoservice.service;

import com.example.demo.demoapi.DemoService;
import org.springframework.stereotype.Service;

/**
 * @author：marco.pan
 * @ClassName：DemoServiceImpl
 * @Description：
 * @date: 2021年10月12日 3:31 下午
 */
@Service
public class DemoServiceImpl implements DemoService {
    @Override
    public void testDemo() {
        System.out.println("test Demo");
    }
}
