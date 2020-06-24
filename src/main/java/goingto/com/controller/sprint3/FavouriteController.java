package goingto.com.controller.sprint3;

import goingto.com.model.account.User;
import goingto.com.model.geographic.Locatable;
import goingto.com.service.LocatableService;
import goingto.com.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class FavouriteController {


    @Autowired
    private UserService userService;

    @Autowired
    private LocatableService locatableService;


    @ApiOperation("Return Locatables by User ID")
    @GetMapping("/users/{userId}/locatables")
    public ResponseEntity<List<Locatable>> getAllLocatablesByUserId(@PathVariable(name = "userId") Integer userId)
    {
        User existingUser = userService.getUserById(userId);
        if(existingUser == null)
            return ResponseEntity.notFound().build();
        var locatables = locatableService.getAllLocatablesByUserId(userId);
        return ResponseEntity.ok(locatables);
    }

    /*
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
    */


}
