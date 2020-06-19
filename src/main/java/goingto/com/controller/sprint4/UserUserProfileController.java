package goingto.com.controller.sprint4;

import goingto.com.model.account.User;
import goingto.com.model.account.UserProfile;
import goingto.com.model.business.PartnerProfile;
import goingto.com.resource.account.AchievementResource;
import goingto.com.resource.account.SaveAchievementResource;
import goingto.com.resource.account.SaveUserProfileResource;
import goingto.com.resource.account.UserProfileResource;
import goingto.com.resource.converter.UserProfileConverter;
import goingto.com.service.UserProfileService;
import goingto.com.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Date;
import java.text.Format;
import java.text.SimpleDateFormat;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserUserProfileController {

    @Autowired
    UserProfileService userProfileService;

    @Autowired
    UserService userService;

    @Autowired
    UserProfileConverter mapper;

    @ApiOperation("Return UserProfile by User id")
    @GetMapping("/users/{userId}/user_profiles")
    public ResponseEntity<?> getUserProfileByUserId(@PathVariable(name = "userId") Integer userId) {
        var userProfiles = userProfileService.getUserProfileByUserId(userId);
        var result = userProfiles;
        return ResponseEntity.ok(result);
    }

    @ApiOperation("Create UserProfile by User id")
    @PostMapping("/users/{userId}/user_profiles")
    public UserProfile createUserProfile(@PathVariable Integer userId, @Valid @RequestBody SaveUserProfileResource resource) {
        var existingUser = userService.getUserById(userId);
        var userProfile = mapper.convertToEntity(resource);
        var date = Date.valueOf(resource.getBirthdate());
        userProfile.setUser(existingUser);
        userProfile.setBirthdate(date);
        var result = userProfileService.createUserProfile(userProfile);
        return result;
    }

   /* @ApiOperation("Update User Profile by User id")
    @PutMapping("/users/{userId}/user_profiles")
    public UserProfile updateAchievement(@PathVariable(name = "userId") Integer userId, @Valid @RequestBody SaveUserProfileResource resource) {
        var userProfile = userProfileService.getUserProfileByUserId(userId);
       //var date = Date.valueOf(resource.getBirthdate());
        var result = userProfileService.updateUserProfile(userProfile.getId(), mapper.convertToEntity(resource));
        return result;
    }*/

   @ApiOperation("Delete existing User Profile by User id")
   @DeleteMapping("/users/{userId}/user_profiles")
   public ResponseEntity<?> deleteUserProfileByUserId(@PathVariable(name = "userId") Integer userId) {
       var userProfile = userProfileService.getUserProfileByUserId(userId);
       return userProfileService.deleteUserProfile(userProfile.getId());
   }


}

