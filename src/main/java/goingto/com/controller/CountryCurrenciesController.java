package goingto.com.controller;

import goingto.com.model.Country;
import goingto.com.model.Currency;
import goingto.com.resource.CountryResource;
import goingto.com.resource.CurrencyResource;
import goingto.com.resource.converter.CurrencyConverter;
import goingto.com.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/country/{countryId}/currencies")
public class CountryCurrenciesController {

    @Autowired
    private CurrencyService currencyService;
    @Autowired
    private CurrencyConverter mapper;
    @GetMapping
    public Page<CurrencyResource> getAllCurrenciesByCountryId(@PathVariable Integer countryId, Pageable pageable) {
        Page<Currency> currencyPage = currencyService.getAllCurrenciesByCountryId(countryId, pageable);
        List<CurrencyResource> resources = currencyPage.getContent().stream().map(mapper::convertToResource).collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }



}
