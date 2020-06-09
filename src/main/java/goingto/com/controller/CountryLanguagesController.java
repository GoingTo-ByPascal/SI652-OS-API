package goingto.com.controller;

import goingto.com.model.geographic.Country;
import goingto.com.model.geographic.Language;
import goingto.com.resource.converter.LanguageConverter;
import goingto.com.service.CountryService;
import goingto.com.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class CountryLanguagesController {

    @Autowired
    private LanguageConverter mapper;

    @Autowired
    private CountryService countryService;

    @Autowired
    private LanguageService languageService;

    @GetMapping("/countries/{countryId}/languages")
    public ResponseEntity<?> getAllLanguagesByCountryId(@PathVariable(name = "countryId") Integer countryId) {
        Country existingCountry = countryService.getCountryById(countryId);
        if(existingCountry==null)
            return ResponseEntity.notFound().build();
        var languages = languageService.getAllLanguagesByCountryId(countryId);
        var result = languages.stream().map(mapper::convertToResource).collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }

}
