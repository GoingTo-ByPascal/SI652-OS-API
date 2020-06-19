package goingto.com.controller;

import goingto.com.model.geographic.Locatable;
import goingto.com.service.LocatableService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class LocatableController {

    @Autowired
    private LocatableService locatableService;

    @ApiOperation("Return all Locatables")
    @GetMapping("/locatables")
    public ResponseEntity<List<Locatable>> listLocatable(){
        List<Locatable> locatables = new ArrayList<>();

        locatables = locatableService.listAllLocatables();
        if(locatables.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(locatables);
    }

    @ApiOperation("Return Locatable by id")
    @GetMapping("/locatables/{id}")
    public ResponseEntity<Locatable>getById(@PathVariable Integer id)
    {
        Locatable locatable = locatableService.getLocatable(id);
        if(locatable ==null)
            return ResponseEntity.notFound().build();
        else
            return (ResponseEntity.ok(locatable));
    }

}
