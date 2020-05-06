package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Marketplace extends Application {
    Scene marktScene;
    Homescreen homescreen = new Homescreen();

    @Override
    public void start(Stage stage) throws Exception{
        Button btnBack = new Button("Back");
        Pane market = new Pane();
        market.getChildren().add(btnBack);
        btnBack.relocate(0,570);
        btnBack.setOnAction(e -> {
            try {
                homescreen.start(stage);
            } catch (Exception ex){
                ex.printStackTrace();
            }
        });
        marktScene = new Scene(market,800,600);
        stage.setScene(marktScene);
        stage.show();
    }
}
