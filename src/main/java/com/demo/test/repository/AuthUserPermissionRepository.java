package com.demo.test.repository;

import com.demo.test.entity.AuthUserPermission;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthUserPermissionRepository extends MongoRepository<AuthUserPermission, Long> {
    List<AuthUserPermission> findByUserId(Long id);
}
