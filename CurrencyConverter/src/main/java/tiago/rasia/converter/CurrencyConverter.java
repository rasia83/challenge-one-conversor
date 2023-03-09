package tiago.rasia.converter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Rasia
 */
public class CurrencyConverter {
    
    

    public static void main(String[] args) {
        /*
        String fromCurrency = "USD";
        String toCurrency = "BRL";
        double amount = 100;

        double exchangeRate = getExchangeRate(fromCurrency, toCurrency);
        double convertedAmount = amount * exchangeRate;
        System.out.println(exchangeRate);

        System.out.printf("%.2f %s = %.2f %s", amount, fromCurrency, convertedAmount, toCurrency);
        */
        // double amount = 1;
        
        //System.out.println(getExchangeRate("BRL", "USD"));
        
    }

    private static double getExchangeRate(String fromCurrency, String toCurrency) {
        try {
            String url = String.format("https://api.exchangerate-api.com/v4/latest/%s", fromCurrency);
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            //System.out.println(response.toString());
        
            JSONObject json = new JSONObject(response.toString());
            double exchangeRate = json.getJSONObject("rates").getDouble(toCurrency);
            
            return exchangeRate;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        
        
    }
                
    public static Map<String,Double> getExchangeRateBRL() {
        
        Map<String,Double> rateBRL = new HashMap<>();
        
        try {

            String url = String.format("https://api.exchangerate-api.com/v4/latest/%s", "BRL");
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            
            JSONObject json = new JSONObject(response.toString());
            
            // System.out.println("USD "+json.getJSONObject("rates").getDouble("USD"));
            
            rateBRL.put("BRL", 1.0);
            rateBRL.put("USD", json.getJSONObject("rates").getDouble("USD"));
            rateBRL.put("EUR", json.getJSONObject("rates").getDouble("EUR"));
            rateBRL.put("GBP", json.getJSONObject("rates").getDouble("GBP"));
            rateBRL.put("ARS", json.getJSONObject("rates").getDouble("ARS"));
            rateBRL.put("CLP", json.getJSONObject("rates").getDouble("CLP"));
            
            // System.out.println(rateBRL.get("USD"));
        
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        
        return rateBRL;
    }
            
}
