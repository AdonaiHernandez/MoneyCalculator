package software.ulpgc.Mock;

import software.ulpgc.CurrencyDialog;
import software.ulpgc.Model.Currency;
import software.ulpgc.Model.Money;
import software.ulpgc.MoneyDialog;

import java.util.Scanner;
import java.util.Set;

public class MockMoneyDialog implements MoneyDialog {

    private CurrencyDialog currencyDialog;

    @Override
    public MoneyDialog define(Set<Currency> currencies) {
        currencyDialog = new MockCurrencyDialog().define(currencies);
        return this;
    }

    @Override
    public Money get() {
        return new Money(amount(), currencyDialog.get());
    }

    private double amount(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cantidad a convertir: ");
        return scanner.nextDouble();
    }
}
