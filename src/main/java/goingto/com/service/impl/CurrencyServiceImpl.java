package goingto.com.service.impl;

import goingto.com.exception.ResourceNotFoundException;
import goingto.com.model.geographic.Currency;
import goingto.com.repository.CountryRepository;
import goingto.com.repository.CurrencyRepository;
import goingto.com.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyServiceImpl implements CurrencyService {
    @Autowired
    private CurrencyRepository currencyRepository;
    @Autowired
    private CountryRepository countryRepository;

    @Override
    public List<Currency> getAllCurrencies() {
        return currencyRepository.findAll();
    }

    @Override
    public List<Currency> getAllCurrenciesByCountryId(Integer countryId) {
        return countryRepository.findById(countryId).map(country -> {
            List<Currency> currencies = country.getCurrencies();
            return currencies;
        }).orElseThrow(() -> new ResourceNotFoundException("Country", "Id",countryId));
    }

    @Override
    public Currency getCurrencyById(Integer currencyId) {
        return currencyRepository.findById(currencyId)
                .orElseThrow(() -> new ResourceNotFoundException("Currency", "Id", currencyId));
    }

    @Override
    public Currency createCurrency(Currency currency) {
        return currencyRepository.save(currency);
    }

    @Override
    public Currency updateCurrency(Integer currencyId, Currency currencyDetails) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteCurrency(Integer currencyId) {
        return currencyRepository.findById(currencyId).map(currency -> {
            currencyRepository.delete(currency);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Currency", "Id", currencyId));
    }
}
