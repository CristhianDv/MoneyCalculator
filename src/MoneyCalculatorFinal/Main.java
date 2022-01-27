package MoneyCalculatorFinal;
import modelo.*;
import control.*;
import java.text.DecimalFormat;
import vista.*;

public class Main {
    
    public static void main(String[] args) {
        Calculator ventanaPrincipal = new Calculator();
        
        DecimalFormat moneyFormat = new DecimalFormat("#.0000");
        ExchangeRateLoaderWeb tasaActual = new ExchangeRateLoaderWeb();
        Currency currencyFrom = (Currency) ventanaPrincipal.getCurrencyFromList().getSelectedItem();
        Currency currencyTo = (Currency) ventanaPrincipal.getCurrencyToList().getSelectedItem();
        ExchangeRate exchangeRate = new ExchangeRate(currencyFrom, currencyTo, 1);
        Money moneyInput = null;
        
        MoneyCalculatorControl controlador = new MoneyCalculatorControl(ventanaPrincipal, currencyFrom, currencyTo, exchangeRate, moneyInput, tasaActual, moneyFormat);
        controlador.ViewControllers();
    }
    
}
