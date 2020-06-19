package goingto.com.service;

import goingto.com.model.business.Benefit;

import java.util.List;

public interface BenefitService {
    List<Benefit> getAll();
    Benefit getById(Integer id);
}
