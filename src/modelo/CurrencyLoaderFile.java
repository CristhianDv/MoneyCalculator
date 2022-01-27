package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CurrencyLoaderFile implements CurrencyLoader {
    private static final ArrayList<Currency> currencies = new ArrayList<>();
    
    @Override
    public void loadAllCurrency() {
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(new File("Divisas.txt")));
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] caracteristicasDivisa = linea.split(" , ");
                currencies.add(new Currency(caracteristicasDivisa[0],caracteristicasDivisa[1],caracteristicasDivisa[2]));
            } 
        } catch (FileNotFoundException e){
            System.out.println("Fichero no encontrado");
        } catch (IOException e2){
            System.out.println("Fallo en la lectura del fichero");
        }
    }

    public ArrayList<Currency> getCurrencies() {
        return currencies;
    }
    
    public String[] getStringCurrencies() {
        ArrayList<String> stringCurrencies = new ArrayList<>();
        for (Currency currency : currencies) {
            stringCurrencies.add(currency.toString());
        }
        return stringCurrencies.toArray(new String[0]);
    }
   
}
