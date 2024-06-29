package software.ulpgc.Swing;

import software.ulpgc.Model.Money;
import software.ulpgc.MoneyDisplay;

import javax.swing.*;

public class SwingMoneyDisplay extends JPanel implements MoneyDisplay {

    private final JLabel convertedMoney;

    public SwingMoneyDisplay(){
        convertedMoney = new JLabel();
        add(convertedMoney);
    }

    @Override
    public void show(Money money) {
        convertedMoney.setText(money.toString());
    }
}
