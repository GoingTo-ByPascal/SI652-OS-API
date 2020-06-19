package goingto.com.service.impl;

import goingto.com.exception.ResourceNotFoundException;
import goingto.com.model.business.Plan;
import goingto.com.repository.business.PlanRepository;
import goingto.com.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanServiceImpl implements PlanService {

    @Autowired
    PlanRepository planRepository;

    @Override
    public List<Plan> getAll() {
        return planRepository.findAll();
    }

    @Override
    public Plan getById(Integer id) {
        return planRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Plan","ID",id));
    }
}
