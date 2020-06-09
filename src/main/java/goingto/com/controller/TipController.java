package goingto.com.controller;

import goingto.com.model.interaction.Tip;
import goingto.com.resource.TipResource;
import goingto.com.resource.SaveTipResource;
import goingto.com.resource.converter.TipConverter;
import goingto.com.service.TipService;
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
