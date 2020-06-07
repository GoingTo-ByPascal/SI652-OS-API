package goingto.com.service.impl;

import goingto.com.exception.ResourceNotFoundException;
import goingto.com.repository.UserRepository;
import goingto.com.service.UserService;
import goingto.com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> ListUsers() {
        return userRepository.findAll();
    }

    @Override
    @Transactional (readOnly = true)
    public User findById(int userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
    }

    @Override
    @Transactional
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public void delete(int id) {
        userRepository.deleteById(id);
    }
}