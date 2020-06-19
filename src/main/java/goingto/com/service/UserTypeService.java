package goingto.com.service;

import goingto.com.model.account.UserType;

import java.util.List;

public interface UserTypeService {

    List<UserType> getAll();
    UserType getById(Integer id);
}
