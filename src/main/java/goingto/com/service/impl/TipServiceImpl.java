package goingto.com.service.impl;

import goingto.com.exception.ResourceNotFoundException;
import goingto.com.model.interaction.Tip;
import goingto.com.repository.interaction.TipRepository;
import goingto.com.service.TipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipServiceImpl implements TipService {

    @Autowired
    private TipRepository tipRepository;

    @Override
    public List<Tip> getAllTips() {
        return tipRepository.findAll();
    }


    @Override
    public List<Tip> getAllTipsByUserId(Integer userId) {
        return tipRepository.getByUserId(userId);
    }

    @Override
    public List<Tip> getAllTipsByLocatableId(Integer locatableId) {
        return tipRepository.getByLocatableId(locatableId);
    }

    @Override
    public List<Tip> getByUserIdAndLocatableId(Integer userId, Integer locatableId) {
        return tipRepository.findByUserIdAndLocatableId(userId,locatableId);
    }

    @Override
    public Tip getTipById(Integer tipId) {
        return tipRepository.findById(tipId)
                .orElseThrow(() -> new ResourceNotFoundException("Tip", "Id", tipId));
    }

    @Override
    public Tip createTip(Tip tip) {
        return tipRepository.save(tip);
    }

    @Override
    public Tip updateTip(Integer tipId, Tip tipDetails) {
        return tipRepository.findById(tipId).map(Tip -> {
            Tip.setText(tipDetails.getText());
            return tipRepository.save(Tip);
        }).orElseThrow(() -> new ResourceNotFoundException("Tip", "Id", tipId));
    }

    @Override
    public ResponseEntity<?> deleteTip(Integer tipId) {
        return tipRepository.findById(tipId).map(Language -> {
            tipRepository.delete(Language);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Tip", "Id", tipId));
    }
}

