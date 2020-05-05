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
        btnContacts.relocate(330,355);
        btnMarketPlace.relocate(430,325);
        btnLiveStock.relocate(430,355);

        homeScene = new Scene(home,800,600);
        stage.setScene(homeScene);
        stage.show();
    }
}
