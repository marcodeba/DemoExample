package com.example.service.demoservice.controller;

import com.example.demo.demoapi.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author：marco.pan
 * @ClassName：AsyncTestController
 * @Description：
 * @date: 2021年10月24日 8:20 下午
 */
@RestController
public class AsyncTestController {
    private ArticleService articleService;

    @Autowired
    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }

    /**
     * 模拟获取文章后阅读量+1
     */
    @GetMapping("/article")
    public String getArticle() {
        // 查询文章
        String article = articleService.selectArticle();
        // 阅读量+1
        articleService.updateReadCount();
        System.out.println("文章阅读业务执行完毕");
        return article;
    }
}
