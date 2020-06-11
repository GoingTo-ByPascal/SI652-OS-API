package goingto.com.controller;

import goingto.com.model.account.Favourite;
import goingto.com.model.account.User;
import goingto.com.model.geographic.Locatable;
import goingto.com.resource.converter.CategoryConverter;
import goingto.com.resource.converter.FavouriteConverter;
import goingto.com.resource.converter.LocatableConverter;
import goingto.com.service.FavouriteService;
import goingto.com.service.PlaceService;
import goingto.com.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class FavouriteController {

    @Autowired
    private FavouriteService favouriteService;

    @Autowired
    private UserService userService;

    @Autowired
    private FavouriteConverter mappervs;

    @Autowired
    private LocatableConverter mapper;

    /*
    @ApiOperation("Return Locatables by User id")
    @GetMapping("/users/{userId}/locatables")
    public ResponseEntity<?> getAllLocatablesByUserIdVS(@PathVariable(name = "userId") Integer userId)
    {
        List<Favourite> favourites = favouriteService.getByUserIdVS(userId);
        var result = favourites.stream().map(mappervs::convertToResource).collect(Collectors.toList());
        return ResponseEntity.ok(result);

    }*/

    @ApiOperation("Return Locatables by User id")
    @GetMapping("/users/{userId}/locatables")
    public ResponseEntity<?> getAllLocatablesByUserId(@PathVariable(name = "userId") Integer userId)
    {
        User existingUser = userService.getUserById(userId);
        if(existingUser == null)
            return ResponseEntity.notFound().build();
        List<Locatable> locatables= favouriteService.getByUserId(userId);
        var result = locatables.stream().map(mapper::convertToResource).collect(Collectors.toList());
        return ResponseEntity.ok(result);

    }

}
