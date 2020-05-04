package sample;

import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Pane root = new Pane();
        primaryStage.setTitle("zeroXess");
        primaryStage.setScene(new Scene(root, 600, 800));
        primaryStage.show();

        //ik maak morgen een pane aan voor het inlogscherm.
    }
    public static void main(String[] args) {
        launch(args);
    }
}
