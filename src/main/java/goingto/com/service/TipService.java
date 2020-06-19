package goingto.com.service;

import goingto.com.model.account.Favourite;
import goingto.com.model.interaction.Tip;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TipService {

    List<Tip> getAllTips();
    List<Tip> getAllTipsByUserId(Integer userId);
    List<Tip> getAllTipsByLocatableId(Integer locatableId);
    List<Tip> getByUserIdAndLocatableId(Integer userId, Integer locatableId);
    Tip getTipById(Integer tipId);
    Tip createTip(Tip tip);
    Tip updateTip(Integer tipId, Tip tipDetails);
    ResponseEntity<?> deleteTip(Integer tipId);
}
