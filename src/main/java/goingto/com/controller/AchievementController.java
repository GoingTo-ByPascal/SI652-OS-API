package goingto.com.controller;

import goingto.com.model.account.Achievement;
import goingto.com.resource.account.AchievementResource;
import goingto.com.resource.account.SaveAchievementResource;
import goingto.com.resource.converter.AchievementConverter;
import goingto.com.service.AchievementService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AchievementController {
    @Autowired
    private AchievementConverter mapper;

    @Autowired
    private AchievementService achievementService;

    @ApiOperation("Return all Achievements")
    @GetMapping("/achievements")
    public ResponseEntity<List<Achievement>> getAllAchievements() {
        List<Achievement> achievements = new ArrayList<>();
        achievements = achievementService.getAllAchievements();
        return ResponseEntity.ok(achievements);

    }

    @ApiOperation("Return Achievement by id")
    @GetMapping("/achievements/{id}")
    public AchievementResource getAchievementById(@PathVariable(name = "id") Integer achievementId) {
        return mapper.convertToResource(achievementService.getAchievementById(achievementId));
    }

    @ApiOperation("Create new Achievement")
    @PostMapping("/achievements")
    public AchievementResource createAchievement(@Valid @RequestBody SaveAchievementResource resource) {
        return mapper.convertToResource(achievementService.createAchievement(mapper.convertToEntity(resource)));
    }

    @ApiOperation("Update existing Achievement by id")
    @PutMapping("/achievements/{id}")
    public AchievementResource updateAchievement(@PathVariable(name = "id") Integer achievementId, @Valid @RequestBody SaveAchievementResource resource) {
        return mapper.convertToResource(achievementService.updateAchievement(achievementId, mapper.convertToEntity(resource)));
    }

    @ApiOperation("Delete existing Achievement by id")
    @DeleteMapping("/achievements/{id}")
    public ResponseEntity<?> deleteAchievement(@PathVariable(name = "id") Integer achievementId) {
        return achievementService.deleteAchievement(achievementId);
    }


}
