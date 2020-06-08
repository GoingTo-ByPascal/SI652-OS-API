package goingto.com.service;

import goingto.com.model.Locatable;
import goingto.com.model.Tip;
import goingto.com.model.Tip;
import goingto.com.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TipService {

    List<Tip> getAllTips();
    List<Tip> getAllTipsByUserId(Integer userId);
    List<Tip> getAllTipsByLocatableId(Integer locatableId);
    Tip getTipById(Integer tipId);
    Tip createTip(Tip tip);
    Tip updateTip(Integer tipId, Tip tipDetails);
    ResponseEntity<?> deleteTip(Integer tipId);
}
