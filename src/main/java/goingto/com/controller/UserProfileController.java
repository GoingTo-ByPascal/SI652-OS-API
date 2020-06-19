package goingto.com.controller;

import goingto.com.model.account.User;
import goingto.com.model.account.UserProfile;
import goingto.com.model.geographic.Country;
import goingto.com.service.CountryService;
import goingto.com.service.UserProfileService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

    @ApiOperation("Return all User Profiles")
    @GetMapping("/user_profiles")
    public ResponseEntity<List<UserProfile>> getAllUserProfiles(){
        List<UserProfile> userProfiles = new ArrayList<>();
        userProfiles = userProfileService.getAllUserProfiles();
        return ResponseEntity.ok(userProfiles);
    }

    @ApiOperation("Return User Profile by id")
    @GetMapping("/user_profiles/{id}")
    public ResponseEntity<UserProfile>getUserProfileById(@PathVariable Integer id)
    {
        UserProfile userProfile = userProfileService.getUserProfileById(id);
        if(userProfile ==null)
            return ResponseEntity.notFound().build();
        else
            return (ResponseEntity.ok(userProfile));
    }


}
