package goingto.com.service;

import goingto.com.model.business.PlanBenefit;

import java.util.List;

public interface PlanBenefitService {
    List<PlanBenefit> getAll();
    PlanBenefit getById(Integer id);
}
