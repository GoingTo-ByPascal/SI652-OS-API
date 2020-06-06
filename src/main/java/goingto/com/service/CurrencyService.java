package goingto.com.service;

import goingto.com.model.Currency;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CurrencyService {
    List<Currency> getAllCurrencies();
    Page<Currency> getAllCurrenciesByCountryId(Integer countryId, Pageable pageable);
    Currency getCurrencyById(Integer currencyId);
}
