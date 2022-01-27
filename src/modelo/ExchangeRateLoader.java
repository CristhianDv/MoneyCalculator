package modelo;

public interface ExchangeRateLoader {
    public ExchangeRate changeCurrency(Currency from, Currency to);
}
