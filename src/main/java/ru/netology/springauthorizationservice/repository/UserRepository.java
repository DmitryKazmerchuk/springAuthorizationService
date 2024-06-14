package ru.netology.springauthorizationservice.repository;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.netology.springauthorizationservice.model.Authorities;

import java.util.*;

@Repository
@Component
public class UserRepository {
    List<Authorities> listUserRights;

    public UserRepository(List<Authorities> listUserRights) {
        this.listUserRights = listUserRights;
    }

    public List<Authorities> getUserAuthorities(String user, String password) {

        if (user.equals("ivan") && password.equals("qwerty")) {
            listUserRights.add(Authorities.READ);
            listUserRights.add(Authorities.WRITE);
            listUserRights.add(Authorities.DELETE);
            return listUserRights;
        }
        return listUserRights;
    }
}