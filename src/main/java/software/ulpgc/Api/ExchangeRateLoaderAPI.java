package software.ulpgc.Api;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ExchangeRateLoaderAPI {

    private final static String KEY = "82fbb7d85bb248639400d46f7fafe015";
    private final static String URL = "https://openexchangerates.org/api/latest.json?app_id=";

    private static Map<String, Double> exchangeList;

    public ExchangeRateLoaderAPI() {
        ExchangeRateLoaderAPI.exchangeList = new HashMap<>();

        try {
            poblateExchangeList();
        } catch (IOException e){

        }

    }

    public double exchange(String from, String to){

        if (from.equals("USD")){
            return ExchangeRateLoaderAPI.exchangeList.get(to);
        }

        double usdChange = ExchangeRateLoaderAPI.exchangeList.get(from);
        return ExchangeRateLoaderAPI.exchangeList.get(to)*usdChange;

    }

    public Set<String> getListOfCurrencies(){
        return ExchangeRateLoaderAPI.exchangeList.keySet();
    }

    private void poblateExchangeList() throws IOException{
         new Gson()
            .fromJson(request(), JsonObject.class)
            .get("rates")
            .getAsJsonObject()
                 .asMap().forEach((k, v) -> {
                     ExchangeRateLoaderAPI.exchangeList.put(k, v.getAsDouble());
            });

    }

    private String request() throws IOException{

        try (InputStream stream = new URL(URL+KEY).openStream()){
            return new String(stream.readAllBytes());
        }

    }

}
