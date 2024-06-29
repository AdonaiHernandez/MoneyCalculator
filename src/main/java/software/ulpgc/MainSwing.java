package software.ulpgc;

import software.ulpgc.Api.ExchangeRateLoaderAPI;
import software.ulpgc.Mock.MockCurrencyLoader;
import software.ulpgc.Mock.MockExchangeRateLoader;
import software.ulpgc.Model.Currency;
import software.ulpgc.Swing.MainJFrame;

import javax.swing.*;
import java.util.Set;

public class MainSwing {
    public static void main(String[] args) {

        ExchangeRateLoaderAPI api = new ExchangeRateLoaderAPI();
        CurrencyLoader currencyLoader = new MockCurrencyLoader(api.getListOfCurrencies());

        Set<Currency> currencies = currencyLoader.load();

        ExchangeRateLoader exchangeRateLoader = new MockExchangeRateLoader(api);

        JFrame mainFrame = new MainJFrame(currencies, exchangeRateLoader);
        mainFrame.setVisible(true);
    }
}
