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

    @Override
    public List<Language> getAllLanguages() {
        return languageRepository.findAll();
    }

    @Override
    public Language getLanguageById(Integer languageId) {
        return languageRepository.findById(languageId)
                .orElseThrow(() -> new ResourceNotFoundException("Language", "Id", languageId));
    }
}
