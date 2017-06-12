package io.github.chpressler.jmagicmirror.services.weather;

import javafx.scene.image.Image;

/**
 * Created by christian on 3/25/17.
 */
public class Weather {

    String temp;
    Image icon;
    static condition condition;
    public enum condition {SUNNY, RAINY, CLOUDY, SNOW, FOGGY, WINDY}

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public Image getIcon() {
        return icon;
    }

    public void setIcon(Image icon) {
        this.icon = icon;
    }

    public condition getCondition() {
        return condition;
    }

    public void setCondition(condition condtion) {
        this.condition = condtion;
    }
}
