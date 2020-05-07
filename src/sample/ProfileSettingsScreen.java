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
        Label text = new Label("Settings to see your profile");
        Button btnBack = new Button("Back");
        Button btnEdit = new Button("Edit Profile");
        Pane pSettings = new Pane();
        pSettings.getChildren().addAll(text, btnBack,btnEdit);
        text.relocate(380,300);


        btnBack.relocate(0,570);
        btnBack.setOnAction(e -> {
            goHomeScreen(stage);
        });

        btnEdit.relocate(400,400);
        btnEdit.setOnAction(e -> {
            goEdit(stage);
        });

        Settings = new Scene(pSettings,800,600);
        stage.setTitle("Profile settings");
        stage.setScene(Settings);
        stage.show();
    }
    public void goHomeScreen(Stage stage){
        Homescreen homescreen = new Homescreen();
        try {
            homescreen.start(stage);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void goEdit(Stage stage){
        EditSettings editSettings = new EditSettings();
        try {
            editSettings.start(stage);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
