package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import sample.inlogScreen.Main;


public class Homescreen extends Application {
    ButtonSettings buttonSettings = ButtonSettings.getInstance();
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
        Label userLabel = new Label("Welcome back " + ArrayKeeper.getData().get(ArrayKeeper.getCurrentUser()).getUsername());
        welcome.setFont(Font.font("Arial",30));
        home.setStyle("-fx-background-color:#e6d8ad");
        home.getChildren().addAll(welcome,btnLogOut,btnProfile,btnContacts,
                btnMarketPlace,btnLiveStock,userLabel,btnEducative,btnMedicalSection);
        welcome.relocate(200,100);
        userLabel.relocate(660,35);
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
        buttonSettings.setButtonLayout(btnEducative);
        btnEducative.relocate(340,320);
        buttonSettings.onMouse(btnEducative);
        btnEducative.setOnAction(E->{
            goToScreens.goEducativeScreen(stage);
        });
    }
    public void makeBtnMedicalSection(Stage stage){
        buttonSettings.setButtonLayout(btnMedicalSection);
        btnMedicalSection.relocate(340,200);
        buttonSettings.onMouse(btnMedicalSection);
        btnMedicalSection.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                goToScreens.goMedicalSection(stage);
            }
        });
    }
    public void makeBtnLivestock(Stage stage){
        buttonSettings.setButtonLayout(btnLiveStock);
        buttonSettings.onMouse(btnLiveStock);
        btnLiveStock.relocate(450,320);
        btnLiveStock.setOnAction(e -> {
            goToScreens.goLiveStock(stage);
        });
    }
    public void makeBtnMarketplace(Stage stage){
        buttonSettings.setButtonLayout(btnMarketPlace);
        buttonSettings.onMouse(btnMarketPlace);
        btnMarketPlace.relocate(450,200);
        btnMarketPlace.setOnAction(e ->{
            goToScreens.goMarketplace(stage);
        });
    }
    public void makeBtnContacts(Stage stage){
        buttonSettings.onMouse(btnContacts);
        buttonSettings.setButtonLayout(btnContacts);
        btnContacts.relocate(225,320);
        btnContacts.setOnAction(e -> {
            goToScreens.goContactsScreen(stage);
        });
    }
    public void makeBtnProfile(Stage stage){
        buttonSettings.setButtonLayout(btnProfile);
        buttonSettings.onMouse(btnProfile);
        btnProfile.relocate(225,200);
        btnProfile.setOnAction(e -> {
            goToScreens.goProfileScreen(stage);
        });
    }
    public void makeBtnLogOut(Stage stage){
        btnLogOut.relocate(738,5);
        buttonSettings.onMouse(btnLogOut);
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