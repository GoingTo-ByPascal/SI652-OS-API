package goingto.com.controller.sprint4;

import goingto.com.model.account.User;
import goingto.com.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;


    @ApiOperation("Return all Users")
    @GetMapping("/users")
    public List<User> GetAll() {
        return userService.getAllUsers();
    }

    @ApiOperation("Return User by id")
    @GetMapping("/users/{id}")
    public User show(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @ApiOperation("Create new User")
    @PostMapping("/users")
    @ResponseStatus(HttpStatus.ACCEPTED) //201: successfully created
    public User create(@RequestBody User user) {
        return userService.createUser(user);
    }


    @ApiOperation("Update existing User by id")
    @PutMapping("/users/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public User update(@RequestBody User user, @PathVariable int id) {

        User existingUser = userService.getUserById(id);

        existingUser.setEmail(user.getEmail());
        existingUser.setPassword((user.getPassword()));

        return userService.createUser(existingUser);
    }

    @ApiOperation("Delete existing User by id")
    @DeleteMapping("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        userService.deleteUser(id);
    }
}