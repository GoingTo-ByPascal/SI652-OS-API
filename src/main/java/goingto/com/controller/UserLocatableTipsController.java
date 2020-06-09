package goingto.com.controller;

import goingto.com.resource.SaveTipResource;
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

    @ApiOperation("Return Tips by User id and Locatable id")
    @PostMapping("/users/{userId}/locatables/{locatableId}/tips")
    public ResponseEntity<?> createTip (@PathVariable Integer userId, @PathVariable Integer locatableId, @Valid @RequestBody SaveTipResource resource){
        var existingUser = userService.findById(userId);
        var existingLocatable = locatableService.getLocatable(locatableId);
        if(existingLocatable==null)
            return ResponseEntity.notFound().build();
        if(existingUser==null)
            return ResponseEntity.notFound().build();
        var tip = mapper.convertToEntity(resource);
        tip.setLocatable(existingLocatable);
        tip.setUser(existingUser);
        var result = tipService.createTip(tip);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
    /*
    @GetMapping
    public ResponseEntity<List<Tip>> getAllTipsByUserIdAndLocatableId(@PathVariable(name = "userId") Integer userId,
                                                                      @PathVariable(name = "locatableId") Integer locatableId){
        var existingUserId = userId;
        var existingLocatableId = locatableId;

        List<Tip> tips = new ArrayList<>();
     */

    }

