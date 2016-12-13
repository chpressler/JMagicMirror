package io.github.chpressler.jmagicmirror;

import com.sun.webkit.CursorManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.net.URL;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/sample.fxml"));
        primaryStage.setTitle("JMagicMirror");

        Scene scene = new Scene(root, 300, 275, Color.BLACK);
        scene.setCursor(Cursor.NONE);
        primaryStage.setScene(scene);

        primaryStage.setFullScreen(true);
        primaryStage.setMaximized(true);

        primaryStage.show();
    }

    public static void main( String[] args ) throws Exception {
        launch(args);
    }

}
