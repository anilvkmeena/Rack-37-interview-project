package com.demo.test.service.impl;

import com.demo.test.entity.News;
import com.demo.test.repository.NewsRepository;
import com.demo.test.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImp implements NewsService {

    @Autowired
    private NewsRepository newsRepository;

    @Override
    public List<News> getAllNews() {
        return newsRepository.findAll();
    }
}
