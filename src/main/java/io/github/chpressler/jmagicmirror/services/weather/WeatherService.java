package io.github.chpressler.jmagicmirror.services.weather;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by christian on 12/23/16.
 */
public class WeatherService {

   /* public enum TEMPUNIT {CENTIGRADE, FAHRENHEIT}

    public enum WEATHER {SUNNY, RAINY, CLOUDY, SNOW, FOGGY, WINDY}

    public String getTemperature(TEMPUNIT unit, String zip) {
        return Long.toString(Math.round(Math.random() * 100))+"°";
    }*/

    public Weather getWeather(String zip) {
        InputStream in = null;
        try {
            URL url = new URL("http://api.openweathermap.org/data/2.5/weather?zip="+zip+",us&units=imperial&appid=461cb68603cf019041d45374b78a2809");
            URLConnection conn = url.openConnection();
            in = conn.getInputStream();
            String result = getString(in);
            JsonObject jsonObject = new JsonParser().parse(result).getAsJsonObject();
            Weather w = new Weather();
            w.setTemp(Long.toString(Math.round(jsonObject.get("main").getAsJsonObject().get("temp").getAsDouble()))+"°");

            String code = jsonObject.get("weather").getAsJsonArray().get(0).getAsJsonObject().get("id").getAsString();
            if(code.startsWith("2") || code.startsWith("3") || code.startsWith("5")) {
                w.setCondition(Weather.condition.RAINY);
            }
            if(code.startsWith("6")) {
                w.setCondition(Weather.condition.SNOW);
            }
            if(code.startsWith("7")) {
                w.setCondition(Weather.condition.FOGGY);
            }
            if(code.startsWith("8")) {
                w.setCondition(Weather.condition.CLOUDY);
            }
            if(code.equals("800")) {
                w.setCondition(Weather.condition.SUNNY);
            }

            return w;
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if(in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    private String getString(InputStream in) throws Exception {
        StringBuffer sb = new StringBuffer();
        BufferedInputStream bin = new BufferedInputStream(in);
        try {
            byte[] ba = new byte[1024];
            while (bin.read(ba) > -1) {
                for (int c : ba) {
                    if (c > 0) {
                        sb.append((char) c);
                    }
                }
            }
            return sb.toString();
        } finally {
            bin.close();
        }
    }

  /*  public void test() {

       String yahooServer = "https://yboss.yahooapis.com/ysearch/";

// Please provide your consumer key here
      String consumer_key = "";

// Please provide your consumer secret here
       String consumer_secret = "";

*//** The HTTPS request object used for the connection *//*
        StHttpRequest httpsRequest = new StHttpRequest();

*//** Encode Format *//*
        final String ENCODE_FORMAT = "UTF-8";

*//** Call Type *//*
        final String callType = "web";

        final int HTTP_STATUS_OK = 200;

*//**
 *
 * @return
 *//*
        public int returnHttpData()
throws UnsupportedEncodingException,
                Exception{


            if(this.isConsumerKeyExists() && this.isConsumerSecretExists()) {

// Start with call Type
                String params = callType;

// Add query
                params = params.concat("?q=");

// Encode Query string before concatenating
                params = params.concat(URLEncoder.encode(this.getSearchString(), "UTF-8"));

// Create final URL
                String url = yahooServer + params;

// Create oAuth Consumer
                OAuthConsumer consumer = new DefaultOAuthConsumer(consumer_key, consumer_secret);

// Set the HTTPS request correctly
                httpsRequest.setOAuthConsumer(consumer);

                try {
                    log.info("sending get request to" + URLDecoder.decode(url, ENCODE_FORMAT));
                    int responseCode = httpsRequest.sendGetRequest(url);

// Send the request
                    if(responseCode == HTTP_STATUS_OK) {
                        log.info("Response ");
                    } else {
                        log.error("Error in response due to status code = " + responseCode);
                    }
                    log.info(httpsRequest.getResponseBody());

                } catch(UnsupportedEncodingException e) {
                    log.error("Encoding/Decording error");
                } catch (IOException e) {
                    log.error("Error with HTTP IO", e);
                } catch (Exception e) {
                    log.error(httpsRequest.getResponseBody(), e);
                    return 0;
                }


            } else {
                log.error("Key/Secret does not exist");
            }
            return 1;
        }

        private String getSearchString() {
            return "Yahoo";
        }

        private boolean isConsumerKeyExists() {
            if(consumer_key.isEmpty()) {
                log.error("Consumer Key is missing. Please provide the key");
                return false;
            }
            return true;
        }

        private boolean isConsumerSecretExists() {
            if(consumer_secret.isEmpty()) {
                log.error("Consumer Secret is missing. Please provide the key");
                return false;
            }
            return true;
        }



    }*/

}
