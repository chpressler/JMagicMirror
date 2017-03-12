package io.github.chpressler.jmagicmirror;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Created by christian on 2/12/17.
 */
public class PureJavaMain extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Button btn = new Button("click me...");
        //btn.setOnAction(buttonClicked());
        StackPane pane = new StackPane(btn);

        Scene scene = new Scene(pane, 200, 50);
        stage.setScene(scene);
        stage.show();
    }

    public void buttonClicked() {
        System.out.println("button clicked...");
    }

    public static void main(String[] args) {
        launch(args);
    }

}
