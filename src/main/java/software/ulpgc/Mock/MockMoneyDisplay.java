package software.ulpgc.Mock;

import software.ulpgc.Model.Money;
import software.ulpgc.MoneyDisplay;

public class MockMoneyDisplay implements MoneyDisplay {

    @Override
    public void show(Money money) {
        System.out.println(money);
    }
}
