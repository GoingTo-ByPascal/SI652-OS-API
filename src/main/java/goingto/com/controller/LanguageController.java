package goingto.com.controller;

import goingto.com.model.Language;
import goingto.com.model.Locatable;
import goingto.com.resource.LanguageResource;
import goingto.com.resource.converter.LanguageConverter;
import goingto.com.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/languages")
public class LanguageController {

    @Autowired
    private LanguageService languageService;

    @GetMapping
    public ResponseEntity<List<Language>> listLanguage(){
        List<Language> languages = new ArrayList<>();

        languages = languageService.getAllLanguages();

        if(languages.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(languages);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Language>getById(@PathVariable Integer id)
    {
        Language language = languageService.getLanguageById(id);
        if(language ==null)
            return ResponseEntity.notFound().build();
        else
            return (ResponseEntity.ok(language));
    }

}
