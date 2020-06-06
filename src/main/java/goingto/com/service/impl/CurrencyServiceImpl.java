package goingto.com.service.impl;

import goingto.com.exception.ResourceNotFoundException;
import goingto.com.model.Currency;
import goingto.com.repository.CountryRepository;
import goingto.com.repository.CurrencyRepository;
import goingto.com.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
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
    public Page<Currency> getAllCurrenciesByCountryId(Integer countryId, Pageable pageable) {
        return countryRepository.findById(countryId).map(country -> {
            List<Currency> currencies = country.getCurrencies();
            int currenciesCount = currencies.size();
            return new PageImpl<>(currencies, pageable, currenciesCount);
        })
                .orElseThrow(() -> new ResourceNotFoundException("Country", "Id",countryId));
    }

    @Override
    public Currency getCurrencyById(Integer currencyId) {
        return currencyRepository.findById(currencyId)
                .orElseThrow(() -> new ResourceNotFoundException("Currency", "Id", currencyId));
    }
}
