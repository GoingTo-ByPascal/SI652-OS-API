package goingto.com.controller;

import goingto.com.model.Locatable;
import goingto.com.resource.converter.TipConverter;
import goingto.com.service.LocatableService;
import goingto.com.service.TipService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/locatables/{locatableId}/tips")
public class LocatableTipsController {

    @Autowired
    private TipService tipService;
    @Autowired
    private LocatableService locatableService;
    @Autowired
    private TipConverter tipConverter;

    @GetMapping
    public ResponseEntity<?> GetAllTipByLocatableId(@PathVariable Integer locatableId){
        Locatable existingLocatable = locatableService.getLocatable(locatableId);
        if(existingLocatable==null)
            return ResponseEntity.notFound().build();
        var tips = tipService.getAllTipsByLocatableId(locatableId);
        var result = tips.stream().map(tipConverter::convertToResource).collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }

}
