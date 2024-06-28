package software.ulpgc;

import software.ulpgc.Model.Currency;

import java.util.Set;

public interface CurrencyDialog {
    CurrencyDialog define(Set<Currency> currencies);

    Currency get();
}
