package goingto.com.service;

import goingto.com.model.Achievement;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AchievementService {
    List<Achievement> getAllAchievements();
    List<Achievement> getAllAchievementsByUserId(Integer userId);
    Achievement getAchievementById(Integer achievementId);
    Achievement createAchievement(Achievement achievement);
    Achievement updateAchievement(Integer achievementId, Achievement achievementDetails);
    ResponseEntity<?> deleteAchievement(Integer achievementId);
}