package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class EditSettings extends Application {
    Scene changeSettings;
    public void start(Stage stage) throws Exception {
        Label text = new Label("Settings to change user settings");
        Button btnBack = new Button("Back");
        Pane eSettings = new Pane();
        eSettings.getChildren().addAll(text, btnBack);
        text.relocate(380,300);

        btnBack.relocate(0,570);

        btnBack.setOnAction(e -> {
            goProfileSettingScreen(stage);
        });

        changeSettings = new Scene(eSettings,800,600);
        stage.setTitle("Change Settings");
        stage.setScene(changeSettings);
        stage.show();
    }
    public void goProfileSettingScreen(Stage stage){
        ProfileSettingsScreen profileSettingsScreen = new ProfileSettingsScreen();
        try {
            profileSettingsScreen.start(stage);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
