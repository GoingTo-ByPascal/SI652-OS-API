package goingto.com.controller.sprint4;

import goingto.com.model.interaction.Tip;
import goingto.com.resource.interaction.SaveTipResource;
import goingto.com.resource.converter.TipConverter;
import goingto.com.service.LocatableService;
import goingto.com.service.TipService;
import goingto.com.service.UserProfileService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserLocatableTipsController {
    @Autowired
    private UserProfileService userProfileService;
    @Autowired
    private LocatableService locatableService;
    @Autowired
    private TipService tipService;
    @Autowired
    private TipConverter mapper;

    @ApiOperation("Create Tips by User id and Locatable id")
    @PostMapping("/user_profiles/{userProfileId}/locatables/{locatableId}/tips")
    public ResponseEntity<?> createTip(@PathVariable Integer userProfileId, @PathVariable Integer locatableId, @Valid @RequestBody SaveTipResource resource) {
        var existingUserProfile = userProfileService.getUserProfileById(userProfileId);
        var existingLocatable = locatableService.getLocatable(locatableId);
        if (existingLocatable == null)
            return ResponseEntity.notFound().build();
        if (existingUserProfile == null)
            return ResponseEntity.notFound().build();
        var tip = mapper.convertToEntity(resource);
        tip.setLocatable(existingLocatable);
        tip.setUserProfile(existingUserProfile);
        var result = tipService.createTip(tip);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

   /* @ApiOperation("Update Tips by User id and Locatable id")
    @PutMapping("/users/{userId}/locatables/{locatableId}/tips")*/

    @ApiOperation("Update Tips by User id and Locatable id")
    @GetMapping("/user_profiles/{userProfileId}/locatables/{locatableId}/tips")
    public List<Tip> getTipByUserProfileIdAndLocatableId(@PathVariable(name = "userProfileId") Integer userProfileId, @PathVariable(name = "locatableId") Integer locatableId){
        return tipService.getByUserProfileIdAndLocatableId(userProfileId, locatableId);
    }

    @ApiOperation("Delete Tips by User id and Locatable id")
    @DeleteMapping("/user_profiles/{userProfileId}/locatables/{locatableId}/tips")
    public void deleteTipByUserProfileIdAndLocatableId (@PathVariable(name = "userProfileId") Integer userProfileId, @PathVariable(name = "locatableId") Integer locatableId)
    {
        List<Tip> tips = tipService.getByUserProfileIdAndLocatableId(userProfileId,locatableId);
        var currentTip = new Tip();
        for (int i = 0 ; i < tips.size(); i++){

             currentTip = tips.get(i);
            tipService.deleteTip(currentTip.getId());
        }
    }


}