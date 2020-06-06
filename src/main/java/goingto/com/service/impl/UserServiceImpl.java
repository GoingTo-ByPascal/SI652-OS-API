package goingto.com.service.impl;

import goingto.com.repository.UserRepository;
import goingto.com.service.UserService;
import goingto.com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> ListUsers() {
        return userRepository.findAll();
    }
}