package io.github.chpressler.jmagicmirror.services.stocks;

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
public class FinanceService {

    public String getExchangeRate(String base, String rate) {
        InputStream in = null;
        try {
            URL url = new URL("http://api.fixer.io/latest?base="+base);
            URLConnection conn = url.openConnection();
            in = conn.getInputStream();
            String result = getString(in);
            JsonObject jsonObject = new JsonParser().parse(result).getAsJsonObject();
            return jsonObject.get("rates").getAsJsonObject().get(rate).getAsString();
        } catch(Exception e) {
            e.printStackTrace();
            return "ERROR";
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

}
