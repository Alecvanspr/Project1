package sample.profileSettings;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class EditSettingsScreen extends Application {
    Scene changeSettings;
    EditSettings editSetings = new EditSettings();
    public void start(Stage stage) throws Exception {
        //De code hieronder heeft te maken met de knoppen voor het edit Scherm
        Pane eSettings = new Pane();
        Label text = new Label("Settings to change user settings");
        Button btnChangeUsername = new Button("Change username");
        Button btnChangeName = new Button("Change name");
        Button btnChangePassword = new Button("Change password");
        Button btnChangeBirthday = new Button("Change Birthday");
        Button btnChagnePhonenumber = new Button("Change phonenumber");
        Button btnChangeSecurityQuestion = new Button("Change Security question");
        Button btnApplyAll = new Button("Apply all");
        Button btnChangeGender = new Button("Change Gender");

        TextField txtNewUsername = new TextField();
        TextField txtNewName = new TextField();
        PasswordField txtNewPassword = new PasswordField();
        PasswordField txtNewPasswordConfrm = new PasswordField();
        TextField txtNewBirthday = new TextField();
        TextField txtNewPhoneNumber = new TextField();
        TextField txtSecurityQuestion = new TextField();
        TextField txtChangeGender = new TextField();

        eSettings.getChildren().addAll(txtNewUsername, btnChangeUsername,txtNewName,btnChangeName,txtNewPassword,txtNewPasswordConfrm,
                btnChangePassword,txtNewBirthday,btnChangeBirthday,txtSecurityQuestion,btnChangeSecurityQuestion,
                txtNewPhoneNumber,btnChagnePhonenumber,txtChangeGender,btnChangeGender,btnApplyAll);

        txtNewUsername.relocate(100,100);
        btnChangeUsername.relocate(300,100);
        txtNewName.relocate(100,135);
        btnChangeName.relocate(300,135);
        txtNewPassword.relocate(100,170);
        txtNewPasswordConfrm.relocate(100,195);
        btnChangePassword.relocate(300,195);
        txtNewBirthday.relocate(100,230);
        btnChangeBirthday.relocate(300,230);
        txtSecurityQuestion.relocate(100,265);
        btnChangeSecurityQuestion.relocate(300,265);
        txtNewPhoneNumber.relocate(100,300);
        btnChagnePhonenumber.relocate(300,300);
        txtChangeGender.relocate(100,335);
        btnChangeGender.relocate(300,335);
        btnApplyAll.relocate(300,370);

        Button btnBack = new Button("Back");

        eSettings.getChildren().addAll(text, btnBack);
        text.relocate(100,65);

        //De code hieronder heeft te maken met de actie van de knoppen.
        btnChangeUsername.setOnAction(E->{
            editSetings.changeUsername(txtNewUsername.getText());
            goProfileSettingScreen(stage);
        });

        btnChangePassword.setOnAction(E->{
            editSetings.changePassword(txtNewPassword.getText(),txtNewPasswordConfrm.getText());
            goProfileSettingScreen(stage);
        });
        btnChangeBirthday.setOnAction(E->{
            editSetings.changeBirthday(txtNewBirthday.getText());
            goProfileSettingScreen(stage);
        });
        btnChagnePhonenumber.setOnAction(E->{
            editSetings.changePhone(txtNewPhoneNumber.getText());
            goProfileSettingScreen(stage);
        });
        btnChangeSecurityQuestion.setOnAction(E->{
            editSetings.changeSecurityAnswer(txtSecurityQuestion.getText());
            goProfileSettingScreen(stage);
        });
        btnChangeGender.setOnAction(E->{
            editSetings.changeGender(txtChangeGender.getText());
            goProfileSettingScreen(stage);
        });
        btnChangeName.setOnAction(E->{

        });
        btnApplyAll.setOnAction(E->{
            editSetings.changeUsername(txtNewUsername.getText());
            editSetings.changeName(txtNewName.getText());
            editSetings.changePassword(txtNewPassword.getText(),txtNewPasswordConfrm.getText());
            editSetings.changePhone(txtNewPhoneNumber.getText());
            editSetings.changeBirthday(txtNewBirthday.getText());
            editSetings.changeSecurityAnswer(txtSecurityQuestion.getText());
            editSetings.changeGender(txtChangeGender.getText());
            goProfileSettingScreen(stage);
        });

        btnBack.relocate(0,570);
        btnBack.setOnAction(e -> {
            goProfileSettingScreen(stage);
        });
        btnBack.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                btnBack.setScaleX(1.2);
                btnBack.setScaleY(1.2);

            }
        });
        btnBack.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                btnBack.setScaleX(1);
                btnBack.setScaleY(1);

            }
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
