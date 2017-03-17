package io.github.chpressler.jmagicmirror.services.weather;

/**
 * Created by christian on 12/23/16.
 */
public class WeatherService {

    public enum TEMPUNIT {CENTIGRADE, FAHRENHEIT}

    public enum WEATHER {SUNNY, RAINY, CLOUDY, SNOW, FOGGY, WINDY}

    public String getTemperature(TEMPUNIT unit, String location) {
        return Long.toString(Math.round(Math.random() * 100))+"°";
    }

    public WEATHER getWeather(String location) {
        return WEATHER.values()[ (int)Math.round((Math.random()*5)) ];
    }

}
