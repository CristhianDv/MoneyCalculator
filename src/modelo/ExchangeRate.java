package modelo;

public class ExchangeRate {
    private final Currency currencyFrom;
    private final Currency currencyTo;
    private final double tasaDeCambio;

    public ExchangeRate(Currency currencyFrom, Currency currencyTo, double TasaDeCambio) {
        this.currencyFrom = currencyFrom;
        this.currencyTo = currencyTo;
        this.tasaDeCambio = TasaDeCambio;
    }

    public Currency getCurrencyFrom() {
        return currencyFrom;
    }

    public Currency getCurrencyTo() {
        return currencyTo;
    }

    public double getTasaDeCambio() {
        return tasaDeCambio;
    }
    
    
    
    
}
