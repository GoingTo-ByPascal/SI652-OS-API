package goingto.com.controller;

import goingto.com.model.geographic.Country;
import goingto.com.resource.converter.CurrencyConverter;
import goingto.com.service.CountryService;
import goingto.com.service.CurrencyService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CountryCurrenciesController {

    @Autowired
    private CurrencyService currencyService;

    @Autowired
    private CountryService countryService;

    @Autowired
    private CurrencyConverter mapper;

    @ApiOperation("Return Currencies by Country id")
    @GetMapping("/countries/{countryId}/currencies")
    public ResponseEntity<?> getAllCurrenciesByCountryId(@PathVariable(name = "countryId") Integer countryId) {
            Country existingCountry = countryService.getCountryById(countryId);
            if(existingCountry==null)
                return ResponseEntity.notFound().build();
            var currencies = currencyService.getAllCurrenciesByCountryId(countryId);
            var result = currencies.stream().map(mapper::convertToResource).collect(Collectors.toList());
            return ResponseEntity.ok(result);
        }
}
