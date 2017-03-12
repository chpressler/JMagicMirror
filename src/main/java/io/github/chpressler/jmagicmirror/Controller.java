package io.github.chpressler.jmagicmirror;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.net.URL;
import java.util.Calendar;
import java.util.Formatter;
import java.util.ResourceBundle;

public class Controller implements Initializable {

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

    private Calendar c;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        c = Calendar.getInstance();
        setLabels(c);
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(60),
                        new EventHandler<ActionEvent>() {
                            public void handle(ActionEvent actionEvent) {
                                setLabels(c);
                            }
                        }
                ),
                new KeyFrame(Duration.seconds(1))
        );
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private void setLabels(Calendar c) {
        setTime(c);
        setMeridiem(c);
        setDate(c);
        setDay(c);
        setRate();
        setWeather();
    }

    private void setTime(Calendar c) {
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb);
        String t = formatter.format("%tl:%tM", c, c).toString();
        time.setText(t);
    }

    private void setMeridiem(Calendar c) {
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb);
        String t = formatter.format("%tp%n", c).toString();
        meridiem.setText(t);
    }

    private void setDate(Calendar c) {
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb);
        String d = formatter.format("%tB %te", c, c).toString();//"%tB %te, %tY%n", c, c, c
        date.setText(d);
    }

    private void setDay(Calendar c) {
        String[] strDays = new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
        day.setText(strDays[c.get(Calendar.DAY_OF_WEEK) - 1]);
    }

    private void setRate() {
        //TODO -> inject Service for exchange rate and retrieve usd eur rate value
        rate.setText("0.956");
    }

    private void setWeather() {
        //TODO -> inject Service for weather from configurable location
        //use icons and temp. in label
        weather.setText("76°");
    }

}
