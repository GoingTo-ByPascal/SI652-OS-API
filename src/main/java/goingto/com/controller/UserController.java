package goingto.com.controller;

import goingto.com.model.User;
import goingto.com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping
    public List<User> GetAll() {
        return userService.ListUsers();
    }


    @GetMapping("/{id}")
    public User show(@PathVariable int id) {
        return userService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED) //201: successfully created
    public User create(@RequestBody User user) {
        return userService.save(user);
    }


    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public User update(@RequestBody User user, @PathVariable int id) {

        User existingUser = userService.findById(id);

        existingUser.setEmail(user.getEmail());
        existingUser.setPassword((user.getPassword()));

        return userService.save(existingUser);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        userService.delete(id);
    }
}