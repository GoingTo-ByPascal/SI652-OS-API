package goingto.com.controller;

import goingto.com.model.account.Favourite;
import goingto.com.model.account.User;
import goingto.com.model.account.UserProfile;
import goingto.com.model.geographic.Country;
import goingto.com.resource.account.SaveFavouriteResource;
import goingto.com.resource.account.SaveUserProfileResource;
import goingto.com.resource.account.UserProfileResource;
import goingto.com.resource.converter.UserProfileConverter;
import goingto.com.service.CountryService;
import goingto.com.service.UserProfileService;
import goingto.com.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

    @Autowired
    private UserService userService;

    @Autowired
    private CountryService countryService;

    @Autowired
    private UserProfileConverter mapper;

    @ApiOperation("Return all User Profiles")
    @GetMapping("/user_profiles")
    public ResponseEntity<List<UserProfileResource>> getAllUserProfiles(){
        List<UserProfile> userProfiles = new ArrayList<>();
        userProfiles = userProfileService.getAllUserProfiles();
        var result = userProfiles.stream().map(mapper::convertToResource).collect(Collectors.toList());
        return ResponseEntity.ok(result);
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

    @ApiOperation("Create UserProfile with Country ID")
    @PostMapping("/users/{userId}/countries/{countryId}")
    public UserProfileResource createUserProfileWithCountry(@PathVariable(name = "userId") Integer userId,
                                                            @PathVariable(name = "countryId") Integer countryId, @Valid @RequestBody SaveUserProfileResource resource) {
        var existingUser = userService.getUserById(userId);
        var existingCountry = countryService.getCountryById(countryId);
        var userProfile = mapper.convertToEntity(resource);
        var date = Date.valueOf(resource.getBirthdate());
        userProfile.setUser(existingUser);
        userProfile.setCountry(existingCountry);
        userProfile.setBirthdate(date);
        var result = userProfileService.createUserProfile(userProfile);
        return mapper.convertToResource(result);
    }
}
