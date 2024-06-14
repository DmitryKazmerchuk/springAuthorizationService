package ru.netology.springauthorizationservice.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.netology.springauthorizationservice.model.InvalidCredentials;
import ru.netology.springauthorizationservice.model.UnauthorizedUser;
import ru.netology.springauthorizationservice.model.Authorities;
import ru.netology.springauthorizationservice.repository.UserRepository;

import java.util.List;

@Service
@Component
public class AuthorizationService {
    UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}