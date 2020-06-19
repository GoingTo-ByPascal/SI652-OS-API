package goingto.com.service;

import goingto.com.model.account.Achievement;
import goingto.com.model.account.UserProfile;
import org.springframework.http.ResponseEntity;

import java.sql.Date;
import java.util.List;

public interface UserProfileService {

    List<UserProfile> getAllUserProfiles();
    UserProfile getUserProfileByUserId(Integer userId);
    UserProfile getUserProfileById(Integer userProfileId);
    UserProfile createUserProfile(UserProfile userProfile);
    UserProfile updateUserProfile(Integer userProfileId, UserProfile userProfileDetails);
    ResponseEntity<?> deleteUserProfile(Integer userProfileId);

}
