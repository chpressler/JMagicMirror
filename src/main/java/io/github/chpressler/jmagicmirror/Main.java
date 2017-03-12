package io.github.chpressler.jmagicmirror;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Main extends Application {

    @FXML
    private Label time;

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("/jmm.fxml"));
        primaryStage.setTitle("JMagicMirror");

        Scene scene = new Scene(root, 0, 0, Color.BLACK);//new Scene(root, 300, 275, Color.BLACK);
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
