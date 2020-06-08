package goingto.com.controller;

import goingto.com.resource.SaveTipResource;
import goingto.com.resource.converter.TipConverter;
import goingto.com.service.LocatableService;
import goingto.com.service.TipService;
import goingto.com.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user/{userId}/locatables/{locatableId}/tips")
public class UserLocatableTipsController {
    @Autowired
    private UserService userService;
    @Autowired
    private LocatableService locatableService;
    @Autowired
    private TipService tipService;
    @Autowired
    private TipConverter tipConverter;

    @PostMapping
    public ResponseEntity<?> createTip (@PathVariable Integer userId, @PathVariable Integer locatableId, @Valid @RequestBody SaveTipResource resource){
        var existingUser = userService.findById(userId);
        var existingLocatable = locatableService.getLocatable(locatableId);
        if(existingLocatable==null)
            return ResponseEntity.notFound().build();
        if(existingLocatable==null)
            return ResponseEntity.notFound().build();
        var tip = tipConverter.convertToEntity(resource);
        var result = tipService.createTip(tip);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
}
