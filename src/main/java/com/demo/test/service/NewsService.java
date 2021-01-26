package com.demo.test.service;

import com.demo.test.entity.News;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NewsService {

    List<News> getAllNews();
}
