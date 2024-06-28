package software.ulpgc.Mock;

import software.ulpgc.CurrencyDialog;
import software.ulpgc.Model.Currency;

import java.util.Scanner;
import java.util.Set;

public class MockCurrencyDialog implements CurrencyDialog {

    private Set<Currency> currencies;

    @Override
    public CurrencyDialog define(Set<Currency> currencies){
        this.currencies = currencies;
        return this;
    }

    @Override
    public Currency get(){
        while (true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Introduce una divisa de la lista:");
            System.out.println(this.currencies);
            String userCurrency = scanner.next();

            if (currenciExist(userCurrency)){
                return new Currency(userCurrency);
            }

            System.out.println("La divisa no está en la lista");
        }
    }

    boolean currenciExist(String code) {
        return currencies.stream().anyMatch((s) -> code.equals(s.code()));
    }

}
