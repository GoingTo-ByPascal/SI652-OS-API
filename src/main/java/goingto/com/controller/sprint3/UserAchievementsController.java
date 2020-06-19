package goingto.com.controller.sprint3;

import goingto.com.model.account.Achievement;
import goingto.com.resource.converter.AchievementConverter;
import goingto.com.service.AchievementService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserAchievementsController {
    @Autowired
    private AchievementConverter mapper;

    @Autowired
    private AchievementService achievementService;

    @ApiOperation("Return Achievements by User id")
    @GetMapping("/users/{userId}/achievements")
    public ResponseEntity<List<Achievement>> getAllAchievementsByUserId(@PathVariable(name = "userId") Integer userId) {
        List<Achievement> achievements = new ArrayList<>();
        achievements = achievementService.getAllAchievementsByUserId(userId);
        return ResponseEntity.ok(achievements);
    }


}
