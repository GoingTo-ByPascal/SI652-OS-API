package goingto.com.controller.sprint4;

import goingto.com.model.geographic.Locatable;
import goingto.com.model.interaction.Tip;
import goingto.com.resource.converter.TipConverter;
import goingto.com.resource.interaction.TipResource;
import goingto.com.service.LocatableService;
import goingto.com.service.TipService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class LocatableTipsController {

    @Autowired
    private TipService tipService;
    @Autowired
    private LocatableService locatableService;
    @Autowired
    private TipConverter mapper;

    @ApiOperation("Return Tips by Locatable id")
    @GetMapping("/locatables/{locatableId}/tips")
    public ResponseEntity<List<TipResource>> getAllTipsByLocatableId(@PathVariable Integer locatableId){
        Locatable existingLocatable = locatableService.getLocatable(locatableId);
        if(existingLocatable==null)
            return ResponseEntity.notFound().build();
        var tips = tipService.getAllTipsByLocatableId(locatableId);
        var result = tips.stream().map(mapper::convertToResource).collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }

}
