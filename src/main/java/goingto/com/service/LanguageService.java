package goingto.com.service;

import goingto.com.model.Language;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LanguageService {
    Page<Language> getAllLanguages(Pageable pageable);
    Page<Language> getAllLanguagesByCountryId(Integer countryId, Pageable pageable);
    Language getLanguageById(Integer languageId);
}
