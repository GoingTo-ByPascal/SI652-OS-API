package goingto.com.controller;

import goingto.com.model.geographic.Currency;
import goingto.com.resource.CurrencyResource;
import goingto.com.resource.SaveCurrencyResource;
import goingto.com.resource.converter.CurrencyConverter;
import goingto.com.service.CurrencyService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @Autowired 
    CurrencyConverter mapper;

    @ApiOperation("Return all Currencies")
    @GetMapping("/currencies")
    public ResponseEntity<List<Currency>> getAllCurrencies() {
        List<Currency> currencies = new ArrayList<>();
        currencies = currencyService.getAllCurrencies();
        return ResponseEntity.ok(currencies);

    }

    @ApiOperation("Return Currency by id")
    @GetMapping("/currencies/{id}")
    public CurrencyResource getCurrencyById(@PathVariable(name = "id") Integer currencyId) {
        return mapper.convertToResource(currencyService.getCurrencyById(currencyId));
    }

    @ApiOperation("Create new Currency")
    @PostMapping("/currencies")
    public CurrencyResource createCurrency(@Valid @RequestBody SaveCurrencyResource resource) {
        return mapper.convertToResource(currencyService.createCurrency(mapper.convertToEntity(resource)));
    }
    @ApiOperation("Update existing Currency by id")
    @PutMapping("/currencies/{id}")
    public CurrencyResource updateCurrency(@PathVariable(name = "id") Integer CurrencyId, @Valid @RequestBody SaveCurrencyResource resource) {
        return mapper.convertToResource(currencyService.updateCurrency(CurrencyId, mapper.convertToEntity(resource)));
    }

    @ApiOperation("Delete existing Currency by id")
    @DeleteMapping("/currencies/{id}")
    public ResponseEntity<?> deleteCurrency(@PathVariable(name = "id") Integer CurrencyId) {
        return currencyService.deleteCurrency(CurrencyId);
    }
}
