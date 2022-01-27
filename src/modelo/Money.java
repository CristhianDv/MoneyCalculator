package modelo;

public class Money {
    private double amount; 
    private Currency divisa;

    public Money(double amount, Currency divisa) {
        this.amount = amount;
        this.divisa = divisa;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Currency getDivisa() {
        return divisa;
    }

    public void setDivisa(Currency divisa) {
        this.divisa = divisa;
    }
    
    
    
}
