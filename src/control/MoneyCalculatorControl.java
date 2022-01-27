package control;
import modelo.*;
import vista.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class MoneyCalculatorControl {
    private Calculator ventanaPrincipal;
    private Currency currencyFrom, currencyTo;
    private ExchangeRate exchangeRate;
    private Money moneyInput;
    private final ExchangeRateLoaderWeb tasaActual;
    private DecimalFormat moneyFormat;

    public MoneyCalculatorControl(Calculator ventanaPrincipal, Currency currencyFrom, Currency currencyTo, ExchangeRate exchangeRate, Money moneyInput, ExchangeRateLoaderWeb tasaActual, DecimalFormat moneyFormat) {
        this.ventanaPrincipal = ventanaPrincipal;
        this.currencyFrom = currencyFrom;
        this.currencyTo = currencyTo;
        this.exchangeRate = exchangeRate;
        this.moneyInput = moneyInput;
        this.tasaActual = tasaActual;
        this.moneyFormat = moneyFormat;
    }
    
    public void ViewControllers() {
        ventanaPrincipal.setVisible(true);
        ventanaPrincipal.getMoneyInput().getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent documentEvent) {
                printIt();
            }
            @Override
            public void insertUpdate(DocumentEvent documentEvent) {
                printIt();
            }
            @Override
            public void removeUpdate(DocumentEvent documentEvent) {
                printIt();
            }
       });
        ventanaPrincipal.getCurrencyFromList().addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                currencyFromListItemStateChanged(e);
            }
        });
        
        ventanaPrincipal.getCurrencyToList().addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                currencyToListItemStateChanged(e);
        }
        });
        
     
    }
    
    private void currencyFromListItemStateChanged(java.awt.event.ItemEvent evt) {                                                  
        if(evt.getStateChange() == ItemEvent.DESELECTED) return;
                currencyFrom = (Currency) evt.getItem();
                printIt();
    }
    
    private void currencyToListItemStateChanged(java.awt.event.ItemEvent evt) {                                                
        if(evt.getStateChange() == ItemEvent.DESELECTED) return;
                currencyTo = (Currency) evt.getItem();
                printIt();
    }
    
    private void printIt() {
            if (isNumber(ventanaPrincipal.getMoneyInput().getText())) {
                double moneyFrom = Double.parseDouble(ventanaPrincipal.getMoneyInput().getText());
                moneyInput = new Money(moneyFrom, currencyTo);
                exchangeRate = tasaActual.changeCurrency(currencyFrom, currencyTo);
                double tasaLocalBigDecimal = exchangeRate.getTasaDeCambio();
                
                String resultado = String.valueOf(moneyFormat.format(moneyInput.getAmount() * tasaLocalBigDecimal));
                ventanaPrincipal.getMoneyOutput().setText(resultado);
            }
    }
    
    private static boolean isNumber(String numberString){
        return numberString.matches("-?\\d+(\\.\\d+)?");
    }
    
}
