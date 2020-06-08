package goingto.com.service;

import goingto.com.model.Currency;
import goingto.com.model.Currency;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CurrencyService {

    List<Currency> getAllCurrencies();
    List<Currency> getAllCurrenciesByCountryId(Integer countryId);
    Currency getCurrencyById(Integer currencyId);
    Currency createCurrency(Currency currency);
    Currency updateCurrency(Integer currencyId, Currency currencyDetails);
    ResponseEntity<?> deleteCurrency(Integer currencyId);
}
