package com.demo.test.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class AuthUserPermission {
    @Id
    private Long id;
    private Long userId;
    private Long permissionId;
}
