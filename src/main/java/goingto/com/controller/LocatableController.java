package goingto.com.controller;

import goingto.com.model.Country;
import goingto.com.model.Locatable;
import goingto.com.service.CountryService;
import goingto.com.service.LocatableService;
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
@RequestMapping("/locatables")
public class LocatableController {

    private LocatableService locatableService;

    @GetMapping
    public ResponseEntity<List<Locatable>> listLocatable(){
        List<Locatable> locatables = new ArrayList<>();

        locatables = locatableService.listAllLocatables();
        if(locatables.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(locatables);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Locatable>getById(@PathVariable Integer id)
    {
        Locatable locatable = locatableService.getLocatable(id);
        if(locatable ==null)
            return ResponseEntity.notFound().build();
        else
            return (ResponseEntity.ok(locatable));
    }

}
