package io.github.chpressler.jmagicmirror;

import com.airhacks.afterburner.injection.Injector;
import io.github.chpressler.jmagicmirror.services.stocks.FinanceService;
import io.github.chpressler.jmagicmirror.services.weather.WeatherService;
import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Map<Object, Object> context = new HashMap<>();
        context.put( "stockService", new FinanceService());
        context.put( "weatherService", new WeatherService());
        Injector.setConfigurationSource( context::get );

        JMMView appView = new JMMView();
        Scene scene = new Scene(appView.getView());

        //Parent root = FXMLLoader.load(getClass().getResource("/io/github/chpressler/jmagicmirror/jmm.fxml"));
        primaryStage.setTitle("JMagicMirror");
        //Scene scene = new Scene(root, 0, 0, Color.BLACK);//new Scene(root, 300, 275, Color.BLACK);
        scene.setCursor(Cursor.NONE);
        //scene.getStylesheets().add(getClass().getResource("/jmm.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
        primaryStage.setMaximized(true);

        primaryStage.show();
    }

    public static void main( String[] args ) throws Exception {
        launch(args);
    }

}
