package goingto.com.service.impl;

import goingto.com.exception.ResourceNotFoundException;
import goingto.com.model.geographic.Language;
import goingto.com.repository.CountryRepository;
import goingto.com.repository.LanguageRepository;
import goingto.com.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageServiceImpl implements LanguageService {
    @Autowired
    private LanguageRepository languageRepository;
    @Autowired
    private CountryRepository countryRepository;


    @Override
    public List<Language> getAllLanguages() {
        return languageRepository.findAll();
    }

    @Override
    public List<Language> getAllLanguagesByCountryId(Integer countryId) {
        return countryRepository.findById(countryId).map(country -> {
            List<Language> languages = country.getLanguages();
            return languages;
    }).orElseThrow(() -> new ResourceNotFoundException("Country", "Id",countryId));
    }

    @Override
    public Language getLanguageById(Integer languageId) {
        return languageRepository.findById(languageId)
                .orElseThrow(() -> new ResourceNotFoundException("Language", "Id", languageId));
    }

    @Override
    public Language createLanguage(Language language) {
        return languageRepository.save(language);
    }

    @Override
    public Language updateLanguage(Integer languageId, Language languageDetails) {
        return languageRepository.findById(languageId).map(language -> {
            language.setFullName(languageDetails.getFullName());
            language.setShortName(languageDetails.getShortName());
            return languageRepository.save(language);
        }).orElseThrow(() -> new ResourceNotFoundException("Language", "Id", languageId));
    }

    @Override
    public ResponseEntity<?> deleteLanguage(Integer languageId) {
        return languageRepository.findById(languageId).map(language -> {
            languageRepository.delete(language);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Language", "Id", languageId));
    }

}

