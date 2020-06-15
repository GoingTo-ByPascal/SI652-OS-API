package goingto.com.controller.sprint3;

import goingto.com.model.account.Favourite;
import goingto.com.model.account.User;
import goingto.com.resource.account.SaveFavouriteResource;
import goingto.com.resource.converter.FavouriteConverter;
import goingto.com.service.FavouriteService;
import goingto.com.service.LocatableService;
import goingto.com.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class FavouriteController {

    @Autowired
    private FavouriteService favouriteService;

    @Autowired
    private UserService userService;

    @Autowired
    private LocatableService locatableService;

    @Autowired
    private FavouriteConverter mapper;

    @ApiOperation("Return Locatables by User id")
    @GetMapping("/users/{userId}/favourites")
    public ResponseEntity<?> getAllLocatablesByUserId(@PathVariable(name = "userId") Integer userId)
    {
        User existingUser = userService.getUserById(userId);
        if(existingUser == null)
            return ResponseEntity.notFound().build();
        var result = existingUser.getFavourites();
        return ResponseEntity.ok(result);

    }

    @GetMapping("/users/{userId}/locatables/{locatableId}")
    public Favourite getFavouriteByUserIdAndLocatableId(@PathVariable(name = "userId") Integer userId, @PathVariable(name = "locatableId") Integer locatableId){
        return favouriteService.getByUserIdAndLocatableId(userId, locatableId);
    }

    @PostMapping("/users/{userId}/locatables/{locatableId}")
    public Favourite assignFavourite(@PathVariable(name = "userId") Integer userId,
                                      @PathVariable(name = "locatableId") Integer locatableId, @Valid @RequestBody SaveFavouriteResource resource) {
        var existingUser = userService.getUserById(userId);
        var existingLocatable = locatableService.getLocatable(locatableId);
        var favourite = mapper.convertToEntity(resource);
        favourite.setUser(existingUser);
        favourite.setLocatable(existingLocatable);
        return favouriteService.createFavourite(favourite);
    }

    @DeleteMapping("/users/{userId}/locatables/{locatableId}")
    public void unassignFavourite(@PathVariable(name = "userId") Integer userId,
                                             @PathVariable(name = "locatableId") Integer locatableId) {

        var favourite = favouriteService.getByUserIdAndLocatableId(userId,locatableId);
        favouriteService.deleteFavourite(favourite);

    }

}
