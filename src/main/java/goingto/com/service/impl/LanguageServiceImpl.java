package goingto.com.service.impl;

import goingto.com.exception.ResourceNotFoundException;
import goingto.com.model.Language;
import goingto.com.repository.CountryRepository;
import goingto.com.repository.LanguageRepository;
import goingto.com.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageServiceImpl implements LanguageService {
    @Autowired
    private LanguageRepository languageRepository;
    @Autowired
    private CountryRepository countryRepository;

    @Override
    public Page<Language> getAllLanguages(Pageable pageable) {
        return languageRepository.findAll(pageable);
    }

    @Override
    public Page<Language> getAllLanguagesByCountryId(Integer countryId, Pageable pageable) {
        return countryRepository.findById(countryId).map(country -> {
            List<Language> languages = country.getLanguages();
            int languagesCount = languages.size();
            return new PageImpl<>(languages, pageable, languagesCount);
        })
                .orElseThrow(() -> new ResourceNotFoundException("Country", "Id",countryId));
    }

    @Override
    public Language getLanguageById(Integer languageId) {
        return languageRepository.findById(languageId)
                .orElseThrow(() -> new ResourceNotFoundException("Language", "Id", languageId));
    }
}
