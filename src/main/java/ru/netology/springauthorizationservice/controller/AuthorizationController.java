package ru.netology.springauthorizationservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.springauthorizationservice.service.AuthorizationService;
import ru.netology.springauthorizationservice.model.Authorities;

import java.util.List;

@RestController
public class AuthorizationController {
    AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
        return service.getAuthorities(user, password);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> icHandler(NullPointerException e) {
        return new ResponseEntity<>("InvalidCredentials", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> uuHandler(IllegalArgumentException e) {
        System.out.println("UnauthorizedUser");
        return new ResponseEntity<>("UnauthorizedUser", HttpStatus.UNAUTHORIZED);
    }
}