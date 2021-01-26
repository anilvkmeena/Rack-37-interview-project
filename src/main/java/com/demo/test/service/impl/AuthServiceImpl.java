package com.demo.test.service.impl;

import com.demo.test.config.TokenProvider;
import com.demo.test.dto.vm.LoginVM;
import com.demo.test.entity.AuthUserPermission;
import com.demo.test.entity.User;
import com.demo.test.repository.AuthUserPermissionRepository;
import com.demo.test.repository.UserRepository;
import com.demo.test.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AuthServiceImpl {

    @Autowired
    private AuthenticationManagerBuilder authenticationManagerBuilder;
    @Autowired
    TokenProvider jwtConfigure;
    @Autowired
    private AuthUserPermissionRepository authUserPermissionRepository;
    @Autowired
    private UserService userService;

    public String AuthenticateUser(LoginVM loginVM) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginVM.getUserName(), loginVM.getPassword());
        try {
            Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            User user = userService.findByEmail(loginVM.getUserName());
            List<AuthUserPermission> authUserPermissions = authUserPermissionRepository.findByUserId(user.getId());
            return jwtConfigure.getToken(loginVM.getUserName(), authUserPermissions);
        } catch (Exception e) {
            log.error("error in login {} , {}", e.getMessage(), e);
            throw new BadCredentialsException("not valid user or password wrong");
        }
    }
}
