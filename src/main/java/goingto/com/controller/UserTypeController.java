package goingto.com.controller;

import goingto.com.model.account.Permission;
import goingto.com.model.account.UserType;
import goingto.com.service.UserTypeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UserTypeController {

    @Autowired
    UserTypeService userTypeService;

    @ApiOperation("Return all Permissions")
    @GetMapping("/user_types")
    public ResponseEntity<List<UserType>> getAllUserTypes(){
        List<UserType> userTypes = new ArrayList<>();
        userTypes = userTypeService.getAll();
        return ResponseEntity.ok(userTypes);
    }

    @ApiOperation("Return User Type by id")
    @GetMapping("/user_types/{id}")
    public ResponseEntity<UserType>getUserTypeById(@PathVariable Integer id)
    {
        UserType userType = userTypeService.getById(id);
        if(userType ==null)
            return ResponseEntity.notFound().build();
        else
            return (ResponseEntity.ok(userType));
    }
}
