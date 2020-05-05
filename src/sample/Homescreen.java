package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Homescreen extends Application {
    Scene homeScene;
    @Override
    public void start(Stage stage) throws Exception {
        Label welcome = new Label("Welcome to the homescreen");
        Pane home = new Pane();
        home.getChildren().add(welcome);
        welcome.relocate(400,300);

        homeScene = new Scene(home,800,600);
        stage.setScene(homeScene);
        stage.show();
    }
}
