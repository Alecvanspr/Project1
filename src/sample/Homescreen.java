package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
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
    //ButtonSettings buttonSettings = new ButtonSettings();
    GoToScreens goToScreens = GoToScreens.getInstance();
    Scene homeScene;
    Main main;
    ArrayKeeper arrayKeeper;
    Label welcome = new Label("Welcome to the homescreen");
    //buttons to navigate to different things
    Button btnLogOut = new Button("Log out");
    Button btnProfile = new Button("Profile");
    Button btnContacts = new Button("Contacts");
    Button btnMarketPlace = new Button("Marketplace");
    Button btnLiveStock = new Button("Livestock");
    Button btnEducative = new Button("Education");
    Button btnMedicalSection = new Button("Medical Section");
    Pane home = new Pane();


    @Override
    public void start(Stage stage) throws Exception {
        Label user = new Label("Welcome back " + ArrayKeeper.getData().get(ArrayKeeper.getCurrentUser()).getUsername());
        welcome.setFont(Font.font("Arial",30));
        home.getChildren().addAll(welcome,btnLogOut,btnProfile,btnContacts,
                btnMarketPlace,btnLiveStock,user,btnEducative,btnMedicalSection);
        welcome.relocate(225,100);
        user.relocate(660,35);
        makeButtons(stage);
        fin(stage);
    }
    public void makeButtons(Stage stage){
        makeBtnLogOut(stage);
        makeBtnProfile(stage);
        makeBtnContacts(stage);
        makeBtnMarketplace(stage);
        makeBtnLivestock(stage);
        makeBtnEducative(stage);
        makeBtnMedicalSection(stage);
    }

    public void makeBtnEducative(Stage stage){
        btnEducative.relocate(400,400);
        ButtonSettings.onMouse(btnEducative);
        btnEducative.setOnAction(E->{
            goToScreens.goEducativeScreen(stage);
        });
    }
    public void makeBtnMedicalSection(Stage stage){
        btnMedicalSection.relocate(500,500);
        ButtonSettings.onMouse(btnMedicalSection);
        btnMedicalSection.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                goToScreens.goMedicalSection(stage);
            }
        });
    }
    public void makeBtnLivestock(Stage stage){
        ButtonSettings.setButtonLayout(btnLiveStock);
        ButtonSettings.onMouse(btnLiveStock);
        btnLiveStock.relocate(450,400);
        btnLiveStock.setOnAction(e -> {
            goToScreens.goLiveStock(stage);
        });
    }
    public void makeBtnMarketplace(Stage stage){
        ButtonSettings.setButtonLayout(btnMarketPlace);
        ButtonSettings.onMouse(btnMarketPlace);
        btnMarketPlace.relocate(450,200);
        btnMarketPlace.setOnAction(e ->{
            goToScreens.goMarketplace(stage);
        });
    }
    public void makeBtnContacts(Stage stage){
        //Contact button
        ButtonSettings.onMouse(btnContacts);
        ButtonSettings.setButtonLayout(btnContacts);
        btnContacts.relocate(225,400);
        btnContacts.setOnAction(e -> {
            goToScreens.goContacts(stage);
        });
    }
    public void makeBtnProfile(Stage stage){
        //Profile Button
        ButtonSettings.setButtonLayout(btnProfile);
        ButtonSettings.onMouse(btnProfile);
        btnProfile.relocate(225,200);
        btnProfile.setOnAction(e -> {
            goToScreens.goProfile(stage);
        });
    }
    public void makeBtnLogOut(Stage stage){
        btnLogOut.relocate(738,5);
        ButtonSettings.onMouse(btnLogOut);
        btnLogOut.setOnAction(e -> {
            goToScreens.goMain(stage);
        });
    }
    public void fin(Stage stage){
        homeScene = new Scene(home,800,600);
        stage.setTitle("Homescreen");
        stage.setScene(homeScene);
        stage.show();
    }
}




