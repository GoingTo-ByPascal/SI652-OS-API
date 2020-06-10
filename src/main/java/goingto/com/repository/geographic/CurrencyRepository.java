package goingto.com.repository.geographic;

import goingto.com.model.geographic.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency, Integer> {
}
