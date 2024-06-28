package software.ulpgc.Mock;

import software.ulpgc.CurrencyLoader;
import software.ulpgc.Model.Currency;

import java.util.HashSet;
import java.util.Set;

public class MockCurrencyLoader implements CurrencyLoader {

    Set<Currency> currencies;

    public MockCurrencyLoader(Set<String> codes){
        currencies = new HashSet<>();
        codes.stream().forEach((code) -> currencies.add(new Currency(code)));
    }

    @Override
    public Set<Currency> load() {
        return currencies;
    }
}
