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
import sample.contacts.ContactScreen;
import sample.educative.EducativeHomeScreen;
import sample.inlogScreen.Main;
import sample.livestock.Livestock;
import sample.market.MarketplaceScreen;
import sample.profileSettings.ProfileSettingsScreen;

public class Homescreen extends Application {
    ButtonSettings buttonSettings = new ButtonSettings();
    GoToScreens goToScreens = new GoToScreens();
    Scene homeScene;
    Main main;
    ArrayKeeper arrayKeeper;
    @Override
    public void start(Stage stage) throws Exception {
        Label welcome = new Label("Welcome to the homescreen");
        welcome.setFont(Font.font("Arial",30));
        //buttons to navigate to different things
        Button btnLogOut = new Button("Log out");
        Label user = new Label("Welcome back " + ArrayKeeper.Data.get(ArrayKeeper.getCurrentUser()).getUsername());
        Button btnProfile = new Button("Profile");
        Button btnContacts = new Button("Contacts");
        Button btnMarketPlace = new Button("Marketplace");
        Button btnLiveStock = new Button("Livestock");
        Button btnEducative = new Button("Education");
        Pane home = new Pane();

        home.getChildren().addAll(welcome,btnLogOut,btnProfile,btnContacts,
                btnMarketPlace,btnLiveStock,user,btnEducative);
        welcome.relocate(225,100);
        btnEducative.relocate(400,400);
        user.relocate(660,35);

        buttonSettings.onMouse(btnContacts);
        buttonSettings.onMouse(btnEducative);
        buttonSettings.onMouse(btnLiveStock);
        buttonSettings.onMouse(btnLogOut);
        buttonSettings.onMouse(btnMarketPlace);
        buttonSettings.onMouse(btnProfile);

        btnLogOut.relocate(738,5);
        btnLogOut.setOnAction(e -> {
            goToScreens.goMain(stage);
        });

        //Profile Button
        buttonSettings.setButtonLayout(btnProfile);
        btnProfile.relocate(225,200);
        btnProfile.setOnAction(e -> {
            goToScreens.goProfile(stage);
        });

        //Contact button
        buttonSettings.setButtonLayout(btnContacts);
        btnContacts.relocate(225,400);
        btnContacts.setOnAction(e -> {
            goToScreens.goContacts(stage);
        });

        //Market button
        buttonSettings.setButtonLayout(btnMarketPlace);
        btnMarketPlace.relocate(450,200);
        btnMarketPlace.setOnAction(e ->{
            goToScreens.goMarketplace(stage);
        });

        //Livestoch button
        buttonSettings.setButtonLayout(btnLiveStock);
        btnLiveStock.relocate(450,400);
        btnLiveStock.setOnAction(e -> {
            goToScreens.goLiveStock(stage);
        });
        btnEducative.setOnAction(E->{
            goToScreens.goEducativeScreen(stage);
        });

        homeScene = new Scene(home,800,600);
        stage.setTitle("Homescreen");
        stage.setScene(homeScene);
        stage.show();
    }
}




