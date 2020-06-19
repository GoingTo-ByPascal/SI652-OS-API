package goingto.com.controller.sprint4;

import goingto.com.model.account.User;
import goingto.com.resource.converter.TipConverter;
import goingto.com.service.TipService;
import goingto.com.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserTipsController {

    @Autowired
    TipService tipService;

    @Autowired
    UserService userService;

    @Autowired
    TipConverter mapper;

    @ApiOperation("Return Tips by User id")
    @GetMapping("/users/{userId}/tips")
    public ResponseEntity<?> getAllTipsByUserId(@PathVariable(name = "userId") Integer userId){
        User existingUser = userService.getUserById(userId);
        if(existingUser==null)
            return ResponseEntity.notFound().build();
        var tips = tipService.getAllTipsByUserId(userId);
        var result = tips.stream().map(mapper::convertToResource).collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }

}
