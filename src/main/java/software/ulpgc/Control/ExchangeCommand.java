package software.ulpgc.Control;

import software.ulpgc.CurrencyDialog;
import software.ulpgc.ExchangeRateLoader;
import software.ulpgc.Model.*;
import software.ulpgc.MoneyDialog;
import software.ulpgc.MoneyDisplay;

public class ExchangeCommand implements Command{

    private final MoneyDialog moneyDialog;
    private final CurrencyDialog currencyDialog;
    private final ExchangeRateLoader exchangeRateLoader;
    private final MoneyDisplay display;

    public ExchangeCommand(MoneyDialog moneyDialog, CurrencyDialog currencyDialog, ExchangeRateLoader exchangeRateLoader, MoneyDisplay display){
        this.moneyDialog = moneyDialog;
        this.currencyDialog = currencyDialog;
        this.exchangeRateLoader = exchangeRateLoader;
        this.display = display;
    }

    @Override
    public void execute(){
        Money money = moneyDialog.get();
        Currency cur = currencyDialog.get();
        ExchangeRate rate = exchangeRateLoader.load(money.currency(), cur);
        Money newMoney = new Money(money.amount() * rate.rate(), cur );
        display.show(newMoney);
    }

}
