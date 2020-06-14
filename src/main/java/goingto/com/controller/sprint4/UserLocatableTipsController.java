package goingto.com.controller.sprint4;

import goingto.com.model.account.Favourite;
import goingto.com.model.interaction.Tip;
import goingto.com.resource.interaction.SaveTipResource;
import goingto.com.resource.converter.TipConverter;
import goingto.com.service.LocatableService;
import goingto.com.service.TipService;
import goingto.com.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserLocatableTipsController {
    @Autowired
    private UserService userService;
    @Autowired
    private LocatableService locatableService;
    @Autowired
    private TipService tipService;
    @Autowired
    private TipConverter mapper;

    @ApiOperation("Create Tips by User id and Locatable id")
    @PostMapping("/users/{userId}/locatables/{locatableId}/tips")
    public ResponseEntity<?> createTip(@PathVariable Integer userId, @PathVariable Integer locatableId, @Valid @RequestBody SaveTipResource resource) {
        var existingUser = userService.getUserById(userId);
        var existingLocatable = locatableService.getLocatable(locatableId);
        if (existingLocatable == null)
            return ResponseEntity.notFound().build();
        if (existingUser == null)
            return ResponseEntity.notFound().build();
        var tip = mapper.convertToEntity(resource);
        tip.setLocatable(existingLocatable);
        tip.setUser(existingUser);
        var result = tipService.createTip(tip);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

   /* @ApiOperation("Update Tips by User id and Locatable id")
    @PutMapping("/users/{userId}/locatables/{locatableId}/tips")*/

    @ApiOperation("Update Tips by User id and Locatable id")
    @GetMapping("/users/{userId}/locatables/{locatableId}/tips")
    public List<Tip> getTipByUserIdAndLocatableId(@PathVariable(name = "userId") Integer userId, @PathVariable(name = "locatableId") Integer locatableId){
        return tipService.getByUserIdAndLocatableId(userId, locatableId);
    }

    @ApiOperation("Delete Tips by User id and Locatable id")
    @DeleteMapping("/users/{userId}/locatables/{locatableId}/tips")
    public void deleteTipByUserIdAndLocatableId (@PathVariable(name = "userId") Integer userId, @PathVariable(name = "locatableId") Integer locatableId)
    {
        List<Tip> tips = tipService.getByUserIdAndLocatableId(userId,locatableId);
        var currentTip = new Tip();
        for (int i = 0 ; i < tips.size(); i++){

             currentTip = tips.get(i);
            tipService.deleteTip(currentTip.getId());
        }
    }


}