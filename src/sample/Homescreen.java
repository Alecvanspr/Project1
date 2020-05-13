package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.contacts.Contacts;
import sample.inlogScreen.Main;
import sample.livestock.Livestock;
import sample.market.Marketplace;
import sample.profileSettings.ProfileSettingsScreen;

public class Homescreen extends Application {
    Scene homeScene;
    Main main;
    ArrayKeeper arrayKeeper;
    @Override
    public void start(Stage stage) throws Exception {
        Label welcome = new Label("Welcome to the homescreen");
        //buttons to navigate to different things
        Button btnLogOut = new Button("Log out");
        Label user = new Label("Welcome back " + ArrayKeeper.Data.get(ArrayKeeper.getCurrentUser()).getUsername());//en dit zou dan de naam weer moeten geven
        Button btnProfile = new Button("Profile");
        Button btnContacts = new Button("Contacts");
        Button btnMarketPlace = new Button("Marketplace");
        Button btnLiveStock = new Button("Livestock");
        Pane home = new Pane();

        home.getChildren().addAll(welcome,btnLogOut,btnProfile,btnContacts,
                btnMarketPlace,btnLiveStock,user);
        welcome.relocate(350,300);

        user.relocate(660,35);

        btnLogOut.relocate(738,5);
        btnLogOut.setOnAction(e -> {
            goMain(stage);
        });

        btnProfile.relocate(330,325);
        btnProfile.setOnAction(e -> {
            goProfile(stage);
        });

        btnContacts.relocate(330,355);
        btnContacts.setOnAction(e -> {
            goContacts(stage);
        });

        btnMarketPlace.relocate(430,325);
        btnMarketPlace.setOnAction(e ->{
            goMarket(stage);
        });

        btnLiveStock.relocate(430,355);
        btnLiveStock.setOnAction(e -> {
            goLivestock(stage);
        });

        homeScene = new Scene(home,800,600);
        stage.setTitle("Homescreen");
        stage.setScene(homeScene);
        stage.show();
    }

    public void goMain(Stage stage){
        Main main = new Main();
        try {
            main.start(stage);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void goMarket(Stage stage){
        Marketplace markt = new Marketplace();
        try {
            markt.start(stage);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void goProfile(Stage stage){
        ProfileSettingsScreen pScreen = new ProfileSettingsScreen();
        try {
            pScreen.start(stage);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void goContacts(Stage stage){
        Contacts contacts = new Contacts();
        try {
            contacts.start(stage);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void goLivestock(Stage stage){
        Livestock livestock = new Livestock();
        try {
            livestock.start(stage);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}




