package com.demo.test.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class News {
    private String id;
    private String news;
}
