package goingto.com.service.impl;

import goingto.com.exception.ResourceNotFoundException;
import goingto.com.model.account.UserProfile;
import goingto.com.repository.account.UserProfileRepository;
import goingto.com.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.Instant;
import java.util.List;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    UserProfileRepository userProfileRepository;

    @Override
    public List<UserProfile> getAllUserProfiles() {
        return userProfileRepository.findAll();
    }

    @Override
    public UserProfile getUserProfileByUserId(Integer userId) {

        return userProfileRepository.findByUserId(userId);
    }

    @Override
    public UserProfile getUserProfileById(Integer userProfileId) {
        return userProfileRepository.findById(userProfileId)
                .orElseThrow(() -> new ResourceNotFoundException("UserProfile","Id",userProfileId));
    }

    @Override
    public UserProfile createUserProfile(UserProfile userProfile) {
        userProfile.setCreatedAt(Instant.now());
        return userProfileRepository.save(userProfile);
    }

    @Override
    public UserProfile updateUserProfile(Integer userProfileId, UserProfile userProfileDetails) {
        return userProfileRepository.findById(userProfileId).map(userProfile -> {
            userProfile.setName(userProfileDetails.getName());
            userProfile.setSurname(userProfileDetails.getSurname());
           //userProfile.setBirthdate(userProfileDetails.getBirthdate());
            userProfile.setGender(userProfile.getGender());
            return userProfileRepository.save(userProfile);
        }).orElseThrow(() -> new ResourceNotFoundException("User Profile", "Id", userProfileId));
    }

    @Override
    public ResponseEntity<?> deleteUserProfile(Integer userProfileId) {
        return userProfileRepository.findById(userProfileId).map(userProfile -> {
            userProfileRepository.delete(userProfile);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("User Profile", "Id", userProfileId));
    }
}
