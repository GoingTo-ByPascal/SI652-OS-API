package goingto.com.controller;

import goingto.com.model.account.Permission;
import goingto.com.model.business.Benefit;
import goingto.com.service.BenefitService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class BenefitController {

    @Autowired
    BenefitService benefitService;

    @ApiOperation("Return all Benefits")
    @GetMapping("/benefits")
    public ResponseEntity<List<Benefit>> getAllBenefits(){
        List<Benefit> benefits = new ArrayList<>();
        benefits = benefitService.getAll();
        return ResponseEntity.ok(benefits);
    }

    @ApiOperation("Return Benefit by id")
    @GetMapping("/benefits/{id}")
    public ResponseEntity<Benefit>getBenefitById(@PathVariable Integer id)
    {
        Benefit benefit = benefitService.getById(id);
        if(benefit ==null)
            return ResponseEntity.notFound().build();
        else
            return (ResponseEntity.ok(benefit));
    }
}
