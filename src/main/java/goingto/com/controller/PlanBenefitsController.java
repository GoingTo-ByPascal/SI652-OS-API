package goingto.com.controller;

import goingto.com.model.account.Permission;
import goingto.com.model.business.PlanBenefit;
import goingto.com.service.PlanBenefitService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class PlanBenefitsController {

    @Autowired
    PlanBenefitService planBenefitService;

    @ApiOperation("Return all Plan Benefits")
    @GetMapping("/plan_benefits")
    public ResponseEntity<List<PlanBenefit>> getAllPlanBenefits(){
        List<PlanBenefit> planBenefits = new ArrayList<>();
        planBenefits = planBenefitService.getAll();
        return ResponseEntity.ok(planBenefits);
    }

    @ApiOperation("Return Plan Benefit by id")
    @GetMapping("/plan_benefits/{id}")
    public ResponseEntity<PlanBenefit>getPlanBenefitById(@PathVariable Integer id)
    {
        PlanBenefit planBenefit = planBenefitService.getById(id);
        if(planBenefit ==null)
            return ResponseEntity.notFound().build();
        else
            return (ResponseEntity.ok(planBenefit));
    }
}
