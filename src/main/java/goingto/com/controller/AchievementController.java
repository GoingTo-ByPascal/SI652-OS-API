package goingto.com.controller;

import goingto.com.model.account.Achievement;
import goingto.com.resource.AchievementResource;
import goingto.com.resource.SaveAchievementResource;
import goingto.com.resource.converter.AchievementConverter;
import goingto.com.service.AchievementService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AchievementController {
    @Autowired
    private AchievementConverter mapper;

    @Autowired
    private AchievementService achievementService;

    @GetMapping("/achievements")
    public ResponseEntity<List<Achievement>> getAllAchievements() {
        List<Achievement> achievements = new ArrayList<>();
        achievements = achievementService.getAllAchievements();
        return ResponseEntity.ok(achievements);

    }

    @GetMapping("/Achievements/{id}")
    public AchievementResource getAchievementById(@PathVariable(name = "id") Integer AchievementId) {
        return mapper.convertToResource(achievementService.getAchievementById(AchievementId));
    }

    @GetMapping("/users/{userId}/achievements")
    public ResponseEntity<List<Achievement>> getAllAchievementsByUserId(@PathVariable(name = "userId") Integer userId) {
        List<Achievement> achievements = new ArrayList<>();
        achievements = achievementService.getAllAchievementsByUserId(userId);
        return ResponseEntity.ok(achievements);
    }


    @PostMapping("/Achievements")
    public AchievementResource createAchievement(@Valid @RequestBody SaveAchievementResource resource) {
        return mapper.convertToResource(achievementService.createAchievement(mapper.convertToEntity(resource)));
    }
    @PutMapping("/Achievements/{id}")
    public AchievementResource updateTag(@PathVariable(name = "id") Integer achievementId, @Valid @RequestBody SaveAchievementResource resource) {
        return mapper.convertToResource(achievementService.updateAchievement(achievementId, mapper.convertToEntity(resource)));
    }

    @DeleteMapping("/Achievements/{id}")
    public ResponseEntity<?> deleteAchievement(@PathVariable(name = "id") Integer achievementId) {
        return achievementService.deleteAchievement(achievementId);
    }


}
