package goingto.com.service;

import goingto.com.model.account.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Integer userId);
    User createUser(User user);
    ResponseEntity<?> deleteUser (Integer userId);
}