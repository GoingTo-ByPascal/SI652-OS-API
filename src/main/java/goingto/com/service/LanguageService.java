package goingto.com.service;

import goingto.com.model.Language;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface LanguageService {
    List<Language> getAllLanguages();
    List<Language> getAllLanguagesByCountryId(Integer countryId);
    Language getLanguageById(Integer languageId);
    Language createLanguage(Language language);
    Language updateLanguage(Integer languageId, Language languageDetails);
    ResponseEntity<?> deleteLanguage(Integer languageId);
}
