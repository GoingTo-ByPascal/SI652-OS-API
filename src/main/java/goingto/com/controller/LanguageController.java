package goingto.com.controller;

import goingto.com.model.Language;
import goingto.com.resource.LanguageResource;
import goingto.com.resource.converter.LanguageConverter;
import goingto.com.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/languages")
public class LanguageController {
    @Autowired
    private LanguageConverter mapper;

    @Autowired
    private LanguageService languageService;

    @GetMapping
    public Page<LanguageResource> getAllLanguages(Pageable pageable) {
        List<LanguageResource> languages = languageService.getAllLanguages(pageable).getContent().stream().map(mapper::convertToResource).collect(Collectors.toList());
        int languagesCount = languages.size();
        return new PageImpl<>(languages, pageable, languagesCount);
    }

    @GetMapping("/countries/{countryId}/languages")
    public Page<LanguageResource> getAllTagsByPostId(@PathVariable(name = "countryId") Integer countryId, Pageable pageable) {
        List<LanguageResource> languages = languageService.getAllLanguagesByCountryId(countryId, pageable).getContent().stream().map(mapper::convertToResource).collect(Collectors.toList());
        int languageCount = languages.size();
        return new PageImpl<>(languages, pageable, languageCount);
    }

    @GetMapping("/languages/{id}")
    public LanguageResource getTagById(@PathVariable(name = "id") Integer languageId) {
        return mapper.convertToResource(languageService.getLanguageById(languageId));
    }

}
