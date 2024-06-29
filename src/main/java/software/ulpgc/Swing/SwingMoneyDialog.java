package software.ulpgc.Swing;

import software.ulpgc.CurrencyDialog;
import software.ulpgc.Model.Currency;
import software.ulpgc.Model.Money;
import software.ulpgc.MoneyDialog;

import javax.swing.*;
import java.util.Set;

public class SwingMoneyDialog extends JPanel implements MoneyDialog {

    private final JTextField amountField;

    private final SwingCurrencyDialog currencyDialog;

    public SwingMoneyDialog(){
        amountField = createTextField();
        add(amountField);

        currencyDialog = new SwingCurrencyDialog();
    }

    private JTextField createTextField(){
        JTextField field = new JTextField();
        field.setColumns(6);
        return field;
    }

    @Override
    public MoneyDialog define(Set<Currency> currencies){
        currencyDialog.define(currencies);
        add(this.currencyDialog);
        return this;
    }

    @Override
    public Money get() {
        return new Money(Double.parseDouble(amountField.getText()), currencyDialog.get());
    }
}
