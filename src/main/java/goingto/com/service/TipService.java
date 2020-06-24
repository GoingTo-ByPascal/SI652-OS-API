package goingto.com.service;

import goingto.com.model.interaction.Tip;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TipService {

    List<Tip> getAllTips();
    List<Tip> getAllTipsByUserProfileId(Integer userProfileId);
    List<Tip> getAllTipsByLocatableId(Integer locatableId);
    List<Tip> getByUserProfileIdAndLocatableId(Integer userProfileId, Integer locatableId);
    Tip getTipById(Integer tipId);
    Tip createTip(Tip tip);
    Tip updateTip(Integer tipId, Tip tipDetails);
    ResponseEntity<?> deleteTip(Integer tipId);
}
