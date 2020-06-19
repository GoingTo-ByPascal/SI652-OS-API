package goingto.com.service;

import goingto.com.model.geographic.Language;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LanguageService {
    List<Language> getAllLanguages();
    List<Language> getAllLanguagesByCountryId(Integer countryId);
    Language getLanguageById(Integer languageId);
    Language createLanguage(Language language);
    Language updateLanguage(Integer languageId, Language languageDetails);
    ResponseEntity<?> deleteLanguage(Integer languageId);
}
