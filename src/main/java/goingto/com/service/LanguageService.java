package goingto.com.service;

import goingto.com.model.Language;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LanguageService {
    List<Language> getAllLanguages();
    Language getLanguageById(Integer languageId);
}
