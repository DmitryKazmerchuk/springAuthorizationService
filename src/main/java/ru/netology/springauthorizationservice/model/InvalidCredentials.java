package ru.netology.springauthorizationservice.model;

public class InvalidCredentials extends NullPointerException {
    public InvalidCredentials(String msg) {
        super(msg);
    }
}