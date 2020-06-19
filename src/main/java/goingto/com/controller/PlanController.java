package goingto.com.controller;

import goingto.com.model.account.UserProfile;
import goingto.com.model.business.Plan;
import goingto.com.service.PlanService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class PlanController {

    @Autowired
    PlanService planService;

    @ApiOperation("Return all Plans")
    @GetMapping("/plans")
    public ResponseEntity<List<Plan>> getAllPlans(){
        List<Plan> plans = new ArrayList<>();
        plans = planService.getAll();
        return ResponseEntity.ok(plans);
    }

    @ApiOperation("Return Plan by id")
    @GetMapping("/plans/{id}")
    public ResponseEntity<Plan>getPlanById(@PathVariable Integer id)
    {
        Plan plan = planService.getById(id);
        if(plan ==null)
            return ResponseEntity.notFound().build();
        else
            return (ResponseEntity.ok(plan));
    }
}
