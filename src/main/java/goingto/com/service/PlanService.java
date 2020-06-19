package goingto.com.service;

import goingto.com.model.business.Plan;

import java.util.List;

public interface PlanService {
    List<Plan> getAll();
    Plan getById(Integer id);
}
