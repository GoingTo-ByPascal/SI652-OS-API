package goingto.com.service.impl;

import goingto.com.exception.ResourceNotFoundException;
import goingto.com.model.business.PlanBenefit;
import goingto.com.repository.business.PlanBenefitRepository;
import goingto.com.service.PlanBenefitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanBenefitServiceImpl implements PlanBenefitService {

    @Autowired
    PlanBenefitRepository planBenefitRepository;

    @Override
    public List<PlanBenefit> getAll() {
        return planBenefitRepository.findAll();
    }

    @Override
    public PlanBenefit getById(Integer id) {
        return planBenefitRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Plan Benefit", "ID",id));
    }
}
