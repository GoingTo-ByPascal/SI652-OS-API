package goingto.com.controller;

import goingto.com.model.geographic.Language;
import goingto.com.resource.geographic.LanguageResource;
import goingto.com.resource.geographic.SaveLanguageResource;
import goingto.com.resource.converter.LanguageConverter;
import goingto.com.service.LanguageService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class LanguageController {

    @Autowired
    private LanguageConverter mapper;

    @Autowired
    private LanguageService languageService;

    @ApiOperation("Return all Languages")
    @GetMapping("/languages")
    public ResponseEntity<List<Language>> getAllLanguages() {
        List<Language> languages = new ArrayList<>();
        languages = languageService.getAllLanguages();
        return ResponseEntity.ok(languages);

    }

    @ApiOperation("Return Language by id")
    @GetMapping("/languages/{id}")
    public LanguageResource getLanguageById(@PathVariable(name = "id") Integer languageId) {
        return mapper.convertToResource(languageService.getLanguageById(languageId));
    }

    @ApiOperation("Create new Language")
    @PostMapping("/languages")
    public LanguageResource createLanguage(@Valid @RequestBody SaveLanguageResource resource) {
        return mapper.convertToResource(languageService.createLanguage(mapper.convertToEntity(resource)));
    }

    @ApiOperation("Update existing Language by id")
    @PutMapping("/languages/{id}")
    public LanguageResource updateLanguage(@PathVariable(name = "id") Integer languageId, @Valid @RequestBody SaveLanguageResource resource) {
        return mapper.convertToResource(languageService.updateLanguage(languageId, mapper.convertToEntity(resource)));
    }

    @ApiOperation("Delete existing Language by id")
    @DeleteMapping("/languages/{id}")
    public ResponseEntity<?> deleteLanguage(@PathVariable(name = "id") Integer LanguageId) {
        return languageService.deleteLanguage(LanguageId);
    }

}
