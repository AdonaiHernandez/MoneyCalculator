package software.ulpgc;

import software.ulpgc.Api.ExchangeRateLoaderAPI;
import software.ulpgc.Control.ExchangeCommand;
import software.ulpgc.Mock.*;
import software.ulpgc.Model.Currency;

import java.util.Set;

public class Main {

    public static void main(String[] args) {
        ExchangeRateLoaderAPI api = new ExchangeRateLoaderAPI();
        CurrencyLoader currencyLoader = new MockCurrencyLoader(api.getListOfCurrencies());

        Set<Currency> currencies = currencyLoader.load();
        CurrencyDialog CDialog = new MockCurrencyDialog().define(currencies);
        MoneyDialog MDialog = new MockMoneyDialog().define(currencies);
        MoneyDisplay moneyDisplay = new MockMoneyDisplay();

        ExchangeRateLoader exchangeRateLoader = new MockExchangeRateLoader(api);
        ExchangeCommand command = new ExchangeCommand(MDialog, CDialog, exchangeRateLoader, moneyDisplay);
        command.execute();

    }

}
