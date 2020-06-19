package goingto.com.controller;

import goingto.com.model.account.PlanUser;
import goingto.com.service.PlanUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class PlanUserController {
    
    @Autowired
    PlanUserService planUserService;


    @ApiOperation("Return all Plan Users")
    @GetMapping("/plan_users")
    public ResponseEntity<List<PlanUser>> getAllPlanUsers(){
        List<PlanUser> planUsers = new ArrayList<>();
        planUsers = planUserService.getAll();
        return ResponseEntity.ok(planUsers);
    }

    @ApiOperation("Return Plan User by id")
    @GetMapping("/plan_users/{id}")
    public ResponseEntity<PlanUser>getPlanUserById(@PathVariable Integer id)
    {
        PlanUser planUser = planUserService.getById(id);
        if(planUser ==null)
            return ResponseEntity.notFound().build();
        else
            return (ResponseEntity.ok(planUser));
    }
}
