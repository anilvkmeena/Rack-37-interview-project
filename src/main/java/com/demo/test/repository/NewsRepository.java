package com.demo.test.repository;

import com.demo.test.entity.News;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends MongoRepository<News, Long> {

    List<News> findAll();
}
