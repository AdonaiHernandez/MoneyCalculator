package software.ulpgc;

import software.ulpgc.Model.Currency;

import java.util.Set;

public interface CurrencyLoader {
    Set<Currency> load();
}
