package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EditSettings extends Application {
    Scene changeSettings;
    public void start(Stage stage) throws Exception {
        Pane eSettings = new Pane();
        Label text = new Label("Settings to change user settings");
        Button btnChangeUsername = new Button("Change username");
        Button btnChangePassword = new Button("Change password");
        Button btnChangeBirthday = new Button("Change Birthday");
        Button btnChagnePhonenumber = new Button("Change phonenumber");
        Button btnChangeSecurityQuestion = new Button("Change Security question");

        TextField txtNewUsername = new TextField();
        PasswordField txtNewPassword = new PasswordField();
        PasswordField txtNewPasswordConfrm = new PasswordField();
        TextField txtNewBirthday = new TextField();
        TextField txtNewPhoneNumber = new TextField();
        TextField txtSecurityQuestion = new TextField();


        eSettings.getChildren().addAll(txtNewUsername, btnChangeUsername,txtNewPassword,txtNewPasswordConfrm,
                btnChangePassword,txtNewBirthday,btnChangeBirthday,txtSecurityQuestion,btnChangeSecurityQuestion,
                txtNewPhoneNumber,btnChagnePhonenumber);
        txtNewUsername.relocate(100,100);
        btnChangeUsername.relocate(300,100);
        txtNewPassword.relocate(100,135);
        txtNewPasswordConfrm.relocate(100,155);
        btnChangePassword.relocate(300,150);
        txtNewBirthday.relocate(100,175);
        btnChangeBirthday.relocate(300,175);
        txtSecurityQuestion.relocate(100,250);
        btnChangeSecurityQuestion.relocate(300,250);
        txtNewPhoneNumber.relocate(100,275);
        btnChagnePhonenumber.relocate(300,275);

        //dit veranderen naar 35 afstand en ik moet met het wachtwoord wat dichter te doen

        Button btnBack = new Button("Back");

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
