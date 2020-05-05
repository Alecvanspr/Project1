package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ProfileSettingsScreen extends Application {
    Scene Settings;

    public void start(Stage stage) throws Exception{
        Label text = new Label("Settings to change user settings");
        Button btnBack = new Button("Back");
        Pane pSettings = new Pane();
        pSettings.getChildren().addAll(text, btnBack);
        text.relocate(380,300);

        btnBack.relocate(0,570);
        btnBack.setOnAction(e -> {
            Homescreen homescreen = new Homescreen();
            try {
                homescreen.start(stage);
            } catch (Exception ex){
                ex.printStackTrace();
            }
        });

        Settings = new Scene(pSettings,800,600);
        stage.setScene(Settings);
        stage.show();
    }
}
