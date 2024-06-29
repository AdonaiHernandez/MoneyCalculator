package software.ulpgc.Swing;

import software.ulpgc.CurrencyDialog;
import software.ulpgc.Model.Currency;

import javax.swing.*;
import java.util.HashSet;
import java.util.Set;

public class SwingCurrencyDialog extends JPanel implements CurrencyDialog {

    private final Set<Currency> currencies;
    private final JList<Currency> currencyJList;

    public SwingCurrencyDialog(){
        currencies = new HashSet<>();
        currencyJList = new JList<>();
    }

    private void poblateCurrencyList(Set<Currency> currencies){
        DefaultListModel<Currency> list = new DefaultListModel<>();
        currencies.forEach(list::addElement);
        currencyJList.setModel(list);
    }

    @Override
    public CurrencyDialog define(Set<Currency> currencies) {
        poblateCurrencyList(currencies);

        JScrollPane pane = new JScrollPane();
        pane.setViewportView(currencyJList);
        add(pane);
        return this;
    }

    @Override
    public Currency get() {
        return currencyJList.getSelectedValue();
    }
}
