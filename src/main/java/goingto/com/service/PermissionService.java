package goingto.com.service;

import goingto.com.model.account.Permission;

import java.util.List;

public interface PermissionService {

    List<Permission> getAllPermissions();
    Permission getById(Integer id);
}
