package com.demo.test.api;

import com.demo.test.entity.News;
import com.demo.test.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/api/v1")
public class PublicNewsApi {

    @Autowired
    private NewsService newsService;

    @GetMapping("/news")
    public List<News> getNews(){
        return newsService.getAllNews();
    }
}
