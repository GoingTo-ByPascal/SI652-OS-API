package goingto.com.controller;

import goingto.com.model.Locatable;
import goingto.com.model.Tip;
import goingto.com.model.Tip;
import goingto.com.model.User;
import goingto.com.resource.TipResource;
import goingto.com.resource.SaveTipResource;
import goingto.com.resource.converter.TipConverter;
import goingto.com.service.TipService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class TipController {

    @Autowired
    TipService tipService;
    
    @Autowired
    TipConverter mapper;

    @GetMapping("/tips")
    public ResponseEntity<List<Tip>> getAllTips() {
        List<Tip> tips = new ArrayList<>();
        tips = tipService.getAllTips();
        return ResponseEntity.ok(tips);

    }

    @GetMapping("/tips/{id}")
    public TipResource getTipById(@PathVariable(name = "id") Integer tipId) {
        return mapper.convertToResource(tipService.getTipById(tipId));
    }

    @GetMapping("/locatables/{locatableId}/tips")
    public ResponseEntity<List<Tip>> getAllTipsByLocatableId(@PathVariable(name = "locatableId") Integer locatableId) {
        List<Tip> tips = new ArrayList<>();
        tips = tipService.getAllTipsByLocatableId(locatableId);
        return ResponseEntity.ok(tips);
    }

    @GetMapping("/users/{userId}/tips")
    public ResponseEntity<List<Tip>> getAllTipsByUserId(@PathVariable(name = "userId") Integer userId){
        List<Tip> tips = new ArrayList<>();
        tips = tipService.getAllTipsByUserId(userId);
        return ResponseEntity.ok(tips);
    }

    @PostMapping("/tips")
    public TipResource createTip(@Valid @RequestBody SaveTipResource resource) {
        return mapper.convertToResource(tipService.createTip(mapper.convertToEntity(resource)));
    }
    @PutMapping("/tips/{id}")
    public TipResource updateTag(@PathVariable(name = "id") Integer tipId, @Valid @RequestBody SaveTipResource resource) {
        return mapper.convertToResource(tipService.updateTip(tipId, mapper.convertToEntity(resource)));
    }

    @DeleteMapping("/tips/{id}")
    public ResponseEntity<?> deleteTip(@PathVariable(name = "id") Integer tipId) {
        return tipService.deleteTip(tipId);
    }
}
