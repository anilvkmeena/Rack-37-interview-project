package com.demo.test.api;

import com.demo.test.dto.vm.LoginVM;
import com.demo.test.service.impl.AuthServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

@RequestMapping("/api/v1")
public class AuthenticationApi {

    @Autowired
    private AuthServiceImpl authService;

    @PostMapping("/authenticate")
    public ResponseEntity<String> authorize(@Validated @RequestBody LoginVM loginVM, HttpServletRequest httpRequest) throws BadCredentialsException {
        String token = authService.AuthenticateUser(loginVM);
        return new ResponseEntity<>(token, HttpStatus.OK);
    }
}
