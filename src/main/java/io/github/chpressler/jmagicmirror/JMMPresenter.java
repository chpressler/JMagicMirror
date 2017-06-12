package io.github.chpressler.jmagicmirror;

import io.github.chpressler.jmagicmirror.services.stocks.FinanceService;
import io.github.chpressler.jmagicmirror.services.weather.Weather;
import io.github.chpressler.jmagicmirror.services.weather.WeatherService;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.util.Duration;

import javax.inject.Inject;
import java.net.URL;
import java.util.Calendar;
import java.util.Formatter;
import java.util.ResourceBundle;

public class JMMPresenter implements Initializable {

    @FXML
    private Label time;
    @FXML
    private Label meridiem;
    @FXML
    private Label date;
    @FXML
    private Label day;
    @FXML
    private Label rate;
    @FXML
    private Label weather;

    @Inject
    FinanceService financeService;
    @Inject
    WeatherService weatherService;

    private Calendar c;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        setLabels();
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(60),
                        new EventHandler<ActionEvent>() {
                            public void handle(ActionEvent actionEvent) {
                                setLabels();
                            }
                        }
                ),
                new KeyFrame(Duration.seconds(1))
        );
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private void setLabels() {
        setTime();
        setMeridiem();
        setDate();
        setDay();
        setRate();
        setWeather();
    }

    private void setTime() {
        Calendar c = Calendar.getInstance();
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb);
        String t = formatter.format("%tl:%tM", c, c).toString();
        time.setText(t);
    }

    private void setMeridiem() {
        Calendar c = Calendar.getInstance();
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb);
        String t = formatter.format("%tp%n", c).toString();
        meridiem.setText(t);
    }

    private void setDate() {
        Calendar c = Calendar.getInstance();
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb);
        String d = formatter.format("%tB %te", c, c).toString();//"%tB %te, %tY%n", c, c, c
        date.setText(d);
    }

    private void setDay() {
        Calendar c = Calendar.getInstance();
        String[] strDays = new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
        day.setText(strDays[c.get(Calendar.DAY_OF_WEEK) - 1]);
    }

    private void setRate() {
        rate.setText(financeService.getExchangeRate("USD", "EUR"));
    }

    String icon = "";
    private void setWeather() {
        Weather w =  weatherService.getWeather("60564");
        weather.getStyleClass().remove(icon);
        icon = w.getCondition().toString();
        weather.getStyleClass().add(icon);
        weather.setText(w.getTemp());
    }

}
