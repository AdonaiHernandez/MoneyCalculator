package software.ulpgc;

import software.ulpgc.Model.Currency;
import software.ulpgc.Model.Money;

import java.util.Set;

public interface MoneyDialog {
    MoneyDialog define(Set<Currency> currencies);

    Money get();
}
