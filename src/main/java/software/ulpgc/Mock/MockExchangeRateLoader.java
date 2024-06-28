package software.ulpgc.Mock;

import software.ulpgc.Api.ExchangeRateLoaderAPI;
import software.ulpgc.ExchangeRateLoader;
import software.ulpgc.Model.Currency;
import software.ulpgc.Model.ExchangeRate;

public class MockExchangeRateLoader implements ExchangeRateLoader {
    private final ExchangeRateLoaderAPI api;

    public MockExchangeRateLoader(ExchangeRateLoaderAPI api) {
        this.api = api;
    }

    @Override
    public ExchangeRate load(Currency from, Currency to) {
        double rate = api.exchange(from.code(), to.code());
        return new ExchangeRate(from, to, rate);
    }
}
