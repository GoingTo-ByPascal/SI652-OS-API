package goingto.com.service.impl;

import goingto.com.exception.ResourceNotFoundException;
import goingto.com.model.account.UserType;
import goingto.com.repository.account.UserTypeRepository;
import goingto.com.service.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTypeServiceImpl implements UserTypeService {

    @Autowired
    UserTypeRepository userTypeRepository;

    @Override
    public List<UserType> getAll() {
        return userTypeRepository.findAll();
    }

    @Override
    public UserType getById(Integer id) {
        return userTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User Type", "Id", id));
    }

}
