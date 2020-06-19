package goingto.com.service;

import goingto.com.model.account.PlanUser;

import java.util.List;

public interface PlanUserService {
    List<PlanUser> getAll();
    PlanUser getById(Integer id);
}
