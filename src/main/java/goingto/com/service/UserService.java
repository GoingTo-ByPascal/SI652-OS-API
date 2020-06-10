package goingto.com.service;

import goingto.com.model.account.User;

import java.util.List;

public interface UserService {
    List<User> ListUsers();
    User findById(int userId);
    User save(User user);
    void delete (int userId);
}