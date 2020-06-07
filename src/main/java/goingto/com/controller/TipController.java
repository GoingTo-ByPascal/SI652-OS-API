package goingto.com.controller;

import goingto.com.model.Locatable;
import goingto.com.model.Tip;
import goingto.com.model.User;
import goingto.com.service.TipService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tips")
public class TipController {

    @Autowired
    TipService tipService;
/*
    @GetMapping
    public ResponseEntity<List<Tip>> listTipsByUser(@RequestParam(name="userId",required = false)Integer userId){
        List<Tip> tips = new ArrayList<>();
        if(userId == null)
        {
            tips = tipService.listAllTips();
            if(tips.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
        }
        else {
            tips = tipService.getByUserId(User.builder().id(userId).build());
        }
        return ResponseEntity.ok(tips);
    }

    @GetMapping
    public ResponseEntity<List<Tip>> listTipsByLocatable(@RequestParam(name="locatableId",required = false)Integer locatableId){
        List<Tip> tips = new ArrayList<>();
        if(locatableId == null)
        {
            tips = tipService.listAllTips();
            if(tips.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
        }
        else {
            tips = tipService.getByLocatableId(Locatable.builder().id(locatableId).build());
        }
        return ResponseEntity.ok(tips);
    }
*/

    @GetMapping("/{id}")
    public ResponseEntity<Tip>getById(@PathVariable Integer id)
    {
        Tip tip = tipService.getTip(id);
        if(tip ==null)
            return ResponseEntity.notFound().build();
        else
            return (ResponseEntity.ok(tip));
    }
    @PostMapping
    public ResponseEntity<Tip> newTip(@RequestBody Tip tip)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(tipService.save((tip)));
    }

    /*@PutMapping
    public ResponseEntity<Place> updatePlace(@RequestBody Place place,@PathVariable Integer id)
    {
        return  ResponseEntity.status(HttpStatus.OK).body(placeService.edit(place, id));
    }*/

    @DeleteMapping("/{id}")
    public ResponseEntity<Tip> deleteTip(@PathVariable Integer id)
    {
        tipService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
