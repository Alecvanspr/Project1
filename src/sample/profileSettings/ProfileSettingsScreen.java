package sample.profileSettings;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.ArrayKeeper;
import sample.ButtonSettings;
import sample.GoToScreens;
import sample.Homescreen;

public class ProfileSettingsScreen extends Application {
    Homescreen homescreen = new Homescreen();
    Scene Settings;
    GoToScreens goToScreens = GoToScreens.getInstance();
    Pane pane = new Pane();
    public int currentUser= ArrayKeeper.getCurrentUser();

    public void start(Stage stage) throws Exception{
        makeButtons(stage);
        makeLabels();
        fin(stage);
    }
    public void fin(Stage stage){
        Settings = new Scene(pane,800,600);
        stage.setTitle("Profile settings");
        stage.setScene(Settings);
        stage.show();
    }
    public void makeLabels(){
        Label textName = new Label("Username : " + ArrayKeeper.getData().get(currentUser).getUsername());
        Label txtRealName = new Label("Name : " + ArrayKeeper.getData().get(currentUser).getName());
        Label txtBirthDate = new Label("Birth date : "+ArrayKeeper.getData().get(currentUser).getDateOfBirth());
        Label textGender = new Label("Gender :" + ArrayKeeper.getData().get(currentUser).getGender());
        Label textPhoneNumber = new Label("Phone number : " + ArrayKeeper.getData().get(currentUser).getPhoneNumber());
        textName.relocate(100,100);
        txtRealName.relocate(100,125);
        txtBirthDate.relocate(100,150);
        textGender.relocate(100,175);
        textPhoneNumber.relocate(100,200);
        pane.getChildren().addAll(textName,txtRealName,txtBirthDate,textGender,textPhoneNumber);
    }
    public void makeButtons(Stage stage){
        Button btnBack = new Button("Back");
        Button btnEdit = new Button("Edit Profile");
        pane.getChildren().addAll( btnBack,btnEdit);
        btnBack.relocate(0,570);
        btnBack.setOnAction(e -> {
            goToScreens.goHomeScreen(stage);
        });
        btnEdit.relocate(100,235);
        btnEdit.setOnAction(e -> {
            goToScreens.goEditSettings(stage);
        });
        ButtonSettings.onMouse(btnBack);
        ButtonSettings.onMouse(btnEdit);
    }
}
