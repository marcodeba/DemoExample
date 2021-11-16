package com.example.service.demoservice.controller;

import com.example.demo.demoapi.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author：marco.pan
 * @ClassName：BizController
 * @Description：
 * @date: 2021年10月12日 3:32 下午
 */
@RestController
public class BizController {
    private DemoService demoService;

    @Autowired
    public void setDemoService(DemoService demoService) {
        this.demoService = demoService;
    }

    @GetMapping("/testController")
    public void testController() {
        demoService.testDemo();
    }
}
