package software.ulpgc;

import software.ulpgc.Model.Currency;
import software.ulpgc.Model.ExchangeRate;

public interface ExchangeRateLoader {
    ExchangeRate load(Currency from, Currency to);
}
