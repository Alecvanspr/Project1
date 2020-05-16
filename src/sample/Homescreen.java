package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
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
        welcome.setFont(Font.font("Arial",30));
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
        welcome.relocate(225,100);

        user.relocate(660,35);

        btnLogOut.relocate(738,5);
        btnLogOut.setOnAction(e -> {
            goMain(stage);
        });

        //Profile Button
        setButtonLayout(btnProfile);
        btnProfile.relocate(225,200);
        btnProfile.setOnAction(e -> {
            goProfile(stage);
        });
        btnProfile.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setButtonScaleChange(btnProfile, 1.0);
            }
        });
        btnProfile.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setButtonScaleChange(btnProfile, 1.2);
            }
        });

        //Contact button
        setButtonLayout(btnContacts);
        btnContacts.relocate(225,400);
        btnContacts.setOnAction(e -> {
            goContacts(stage);
        });
        btnContacts.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setButtonScaleChange(btnContacts, 1.2);
            }
        });
        btnContacts.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setButtonScaleChange(btnContacts, 1.0);
            }
        });

        //Market button
        setButtonLayout(btnMarketPlace);
        btnMarketPlace.relocate(450,200);
        btnMarketPlace.setOnAction(e ->{
            goMarket(stage);
        });
        btnMarketPlace.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setButtonScaleChange(btnMarketPlace, 1.0);
            }
        });
        btnMarketPlace.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setButtonScaleChange(btnMarketPlace, 1.2);
            }
        });

        //Livestoch button
        setButtonLayout(btnLiveStock);
        btnLiveStock.relocate(450,400);
        btnLiveStock.setOnAction(e -> {
            goLivestock(stage);
        });
        btnLiveStock.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setButtonScaleChange(btnLiveStock, 1.2);
            }
        });
        btnLiveStock.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setButtonScaleChange(btnLiveStock, 1.0);
            }
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
    public void setButtonLayout(Button button){
        button.setPrefHeight(150);
        button.setPrefWidth(150);
    }
    public void setButtonScaleChange(Button button, Double scale){
        button.setScaleY(scale);
        button.setScaleX(scale);
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




