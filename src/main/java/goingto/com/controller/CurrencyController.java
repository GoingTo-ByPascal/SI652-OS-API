package goingto.com.controller;

import goingto.com.model.Country;
import goingto.com.model.Currency;
import goingto.com.resource.converter.CurrencyConverter;
import goingto.com.service.CurrencyService;
import io.swagger.models.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/currencies")
public class CurrencyController {
    @Autowired
    private CurrencyService currencyService;

    @GetMapping
    public ResponseEntity<List<Currency>> listCurrency(){
        List<Currency> currencies = new ArrayList<>();

        currencies = currencyService.getAllCurrencies();

        if(currencies.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(currencies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Currency>getById(@PathVariable Integer id)
    {
        Currency currency = currencyService.getCurrencyById(id);
        if(currency ==null)
            return ResponseEntity.notFound().build();
        else
            return (ResponseEntity.ok(currency));
    }
}
