package com.demo.test.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class AuthPermission {
    @Id
    private Long id;
    private String coed;
    private String description;
}
