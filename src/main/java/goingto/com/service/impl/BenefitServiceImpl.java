package goingto.com.service.impl;

import goingto.com.exception.ResourceNotFoundException;
import goingto.com.model.business.Benefit;
import goingto.com.repository.business.BenefitRepository;
import goingto.com.service.BenefitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BenefitServiceImpl implements BenefitService {

    @Autowired
    BenefitRepository benefitRepository;

    @Override
    public List<Benefit> getAll() {
        return benefitRepository.findAll();
    }

    @Override
    public Benefit getById(Integer id) {
        return benefitRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Benefit","ID",id));
    }
}
