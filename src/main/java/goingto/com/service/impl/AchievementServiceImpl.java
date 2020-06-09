package goingto.com.service.impl;

import goingto.com.exception.ResourceNotFoundException;
import goingto.com.model.Achievement;
import goingto.com.repository.UserRepository;
import goingto.com.repository.AchievementRepository;
import goingto.com.service.AchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AchievementServiceImpl implements AchievementService {
    @Autowired
    private AchievementRepository achievementRepository;
    @Autowired
    private UserRepository userRepository;


    @Override
    public List<Achievement> getAllAchievements() {
        return achievementRepository.findAll();
    }

    @Override
    public List<Achievement> getAllAchievementsByUserId(Integer userId) {
        return userRepository.findById(userId).map(user -> {
            List<Achievement> achievements = user.getAchievements();
            return achievements;
        }).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
    }

    @Override
    public Achievement getAchievementById(Integer achievementId) {
        return achievementRepository.findById(achievementId)
                .orElseThrow(() -> new ResourceNotFoundException("Achievement", "Id", achievementId));
    }

    @Override
    public Achievement createAchievement(Achievement achievement) {
        return achievementRepository.save(achievement);
    }

    @Override
    public Achievement updateAchievement(Integer achievementId, Achievement achievementDetails) {
        return achievementRepository.findById(achievementId).map(achievement -> {
            achievement.setName(achievementDetails.getName());
            achievement.setText(achievementDetails.getText());
            achievement.setPoints(achievementDetails.getPoints());
            return achievementRepository.save(achievement);
        }).orElseThrow(() -> new ResourceNotFoundException("Achievement", "Id", achievementId));
    }

    @Override
    public ResponseEntity<?> deleteAchievement(Integer achievementId) {
        return achievementRepository.findById(achievementId).map(achievement -> {
            achievementRepository.delete(achievement);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Achievement", "Id", achievementId));
    }

}