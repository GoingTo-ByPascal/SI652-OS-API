package goingto.com.service.impl;

import goingto.com.exception.ResourceNotFoundException;
import goingto.com.model.Locatable;
import goingto.com.model.Tip;
import goingto.com.model.User;
import goingto.com.repository.TipRepository;
import goingto.com.service.TipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipServiceImpl implements TipService {

    @Autowired
    private TipRepository tipRepository;

    @Override
    public Tip getTip(Integer tipId) {
        return tipRepository.findById(tipId)
                .orElseThrow(() -> new ResourceNotFoundException("Tip", "Id", tipId));
    }

    @Override
    public List<Tip> listAllTips() {
        return tipRepository.findAll();
    }

    @Override
    public List<Tip> getByUserId(User user) {
        return tipRepository.getByUserId(user);
    }

    @Override
    public List<Tip> getByLocatableId(Locatable locatable) {
        return tipRepository.getByLocatableId(locatable);
    }

    @Override
    public Tip save(Tip tip) {
        return tipRepository.save(tip);
    }

    @Override
    public void delete(int id) {
        tipRepository.deleteById(id);
    }
}
