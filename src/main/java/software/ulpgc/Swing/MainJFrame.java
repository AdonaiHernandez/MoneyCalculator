package software.ulpgc.Swing;

import software.ulpgc.Control.ExchangeCommand;
import software.ulpgc.CurrencyDialog;
import software.ulpgc.ExchangeRateLoader;
import software.ulpgc.Model.Currency;
import software.ulpgc.MoneyDialog;
import software.ulpgc.MoneyDisplay;

import javax.swing.*;
import java.awt.*;
import java.util.Set;

public class MainJFrame extends JFrame {

    private final MoneyDialog moneyDialog;
    private final MoneyDisplay moneyDisplay;
    private final CurrencyDialog currencyDialog;
    private final ExchangeRateLoader exchangeRateLoader;
    private final ExchangeCommand command;
    public MainJFrame(Set<Currency> currencies, ExchangeRateLoader exchangeRateLoader){

        setTitle("Money Calculator");
        setSize(400,300);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.exchangeRateLoader = exchangeRateLoader;

        moneyDialog = new SwingMoneyDialog().define(currencies);
        currencyDialog = new SwingCurrencyDialog().define(currencies);
        moneyDisplay = new SwingMoneyDisplay();

        add((Component) moneyDialog);
        add((Component) currencyDialog);
        add((Component) moneyDisplay);

        command = new ExchangeCommand(moneyDialog, currencyDialog, this.exchangeRateLoader, moneyDisplay);

        JButton button = new JButton("Exchange");
        button.addActionListener(l -> command.execute());
        add(button);

    }

}
