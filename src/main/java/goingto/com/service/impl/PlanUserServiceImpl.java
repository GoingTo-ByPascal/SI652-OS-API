package goingto.com.service.impl;

import goingto.com.exception.ResourceNotFoundException;
import goingto.com.model.account.PlanUser;
import goingto.com.repository.account.PlanUserRepository;
import goingto.com.service.PlanUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PlanUserServiceImpl implements PlanUserService {

    @Autowired
    PlanUserRepository planUserRepository;

    @Override
    public List<PlanUser> getAll() {
        return planUserRepository.findAll();
    }

    @Override
    public PlanUser getById(Integer id) {
        return planUserRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Plan User","ID",id));
    }
}
