package modelo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.stream.Collectors;

public class ExchangeRateLoaderWeb implements ExchangeRateLoader {

    @Override
    public ExchangeRate changeCurrency(Currency from, Currency to) {
        try {
            return new ExchangeRate(from, to, read(from.getCodigo(), to.getCodigo()));
        } catch (MalformedURLException ex) {
            System.out.print("ERROR ExchangeRateLoaderWeb::load (Mal formed URL)" + ex.getMessage());
            return null;
        } catch (IOException ex){
            System.out.print("ERROR ExchangeRateLoaderWeb::load (IOException)" + ex.getMessage());
            return null;
        }
    }
    
    private double read(String from, String to) throws MalformedURLException, IOException{
        if(from.equals(to))return 1;
        String line = read(new URL("https://freecurrencyapi.net/api/v2/latest?apikey=9eba2880-50a8-11ec-834d-e31b83e7c2d4&base_currency=" + from), to);
        return Double.parseDouble(line);
    }

    private String read(URL url, String to) throws IOException {
        InputStream is = url.openStream();
        String result = new BufferedReader(new InputStreamReader(is)).lines().collect(Collectors.joining("\n"));
        String currencyTo =  result.substring(result.indexOf(to)+13).equals("}") ? result.substring(result.indexOf(to)+5,result.indexOf("}", result.indexOf(to))) : result.substring(result.indexOf(to)+5,result.indexOf(",", result.indexOf(to))) ;
        return currencyTo;
    }
    
}