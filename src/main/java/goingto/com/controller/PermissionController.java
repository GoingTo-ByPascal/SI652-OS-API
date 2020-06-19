package goingto.com.controller;

import goingto.com.model.account.Permission;
import goingto.com.model.account.UserProfile;
import goingto.com.service.PermissionService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class PermissionController {

    @Autowired
    PermissionService permissionService;

    @ApiOperation("Return all Permissions")
    @GetMapping("/permissions")
    public ResponseEntity<List<Permission>> getAllPermissions(){
        List<Permission> permissions = new ArrayList<>();
        permissions = permissionService.getAllPermissions();
        return ResponseEntity.ok(permissions);
    }

    @ApiOperation("Return Permission by id")
    @GetMapping("/permissions/{id}")
    public ResponseEntity<Permission>getPermissionById(@PathVariable Integer id)
    {
        Permission permission = permissionService.getById(id);
        if(permission ==null)
            return ResponseEntity.notFound().build();
        else
            return (ResponseEntity.ok(permission));
    }
}
