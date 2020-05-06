package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Livestock extends Application {
    Scene stockScene;

    @Override
    public void start(Stage stage) throws Exception{
        Button btnBack = new Button("Back");
        Pane liveS = new Pane();
        liveS.getChildren().add(btnBack);
        btnBack.relocate(0,570);
        btnBack.setOnAction(e -> {
            Homescreen homescreen = new Homescreen();
            try {
                homescreen.start(stage);
            } catch (Exception ex){
                ex.printStackTrace();
            }
        });
        stockScene = new Scene(liveS,800,600);
        stage.setTitle("Livestock");
        stage.setScene(stockScene);
        stage.show();
    }
}
