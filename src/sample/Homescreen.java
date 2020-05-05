package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Homescreen extends Application {
    Scene homeScene;
    @Override
    public void start(Stage stage) throws Exception {
        Label welcome = new Label("Welcome to the homescreen");
        //buttons to navigate to different things
        Button btnLogOut = new Button("Log out");
        Button btnProfile = new Button("Profile settings");
        Button btnContacts = new Button("Contacts");
        Button btnMarketPlace = new Button("Marketplace");
        Button btnLiveStock = new Button("Livestock");
        Pane home = new Pane();
        home.getChildren().addAll(welcome,btnLogOut,btnProfile,btnContacts,
                btnMarketPlace,btnLiveStock);
        welcome.relocate(350,300);

        btnLogOut.relocate(738,5);
        btnLogOut.setOnAction(e -> {
            Main main = new Main();
            try {
                main.start(stage);
            } catch (Exception ex){
                ex.printStackTrace();
            }
        });

        btnProfile.relocate(330,325);
        btnProfile.setOnAction(e -> {
            ProfileSettingsScreen pScreen = new ProfileSettingsScreen();
            try {
                pScreen.start(stage);
            } catch (Exception ex){
                ex.printStackTrace();
            }
        });

        btnContacts.relocate(330,355);
        btnContacts.setOnAction(e -> {
            Contacts contacts = new Contacts();
            try {
                contacts.start(stage);
            } catch (Exception ex){
                ex.printStackTrace();
            }
        });

        btnMarketPlace.relocate(430,325);
        btnMarketPlace.setOnAction(e ->{
            Marketplace markt = new Marketplace();
            try {
                markt.start(stage);
            } catch (Exception ex){
                ex.printStackTrace();
            }
        });

        btnLiveStock.relocate(430,355);
        btnLiveStock.setOnAction(e -> {
            Livestock livestock = new Livestock();
            try {
                livestock.start(stage);
            } catch (Exception ex){
                ex.printStackTrace();
            }
        });

        homeScene = new Scene(home,800,600);
        stage.setScene(homeScene);
        stage.show();
    }
}
