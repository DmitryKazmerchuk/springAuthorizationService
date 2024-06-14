package ru.netology.springauthorizationservice.model;

public class UnauthorizedUser extends IllegalArgumentException {
    public UnauthorizedUser(String msg) {
        super(msg);
    }
}