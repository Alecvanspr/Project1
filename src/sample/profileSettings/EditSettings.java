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
import sample.ArrayKeeper;
import sample.inlogScreen.PersonalData;
import sample.profileSettings.ProfileSettingsScreen;

import java.util.ArrayList;

import static sample.ArrayKeeper.getCurrentUser;

public class EditSettings extends Application {
    Scene changeSettings;
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
            changeUsername(txtNewUsername.getText());
            goProfileSettingScreen(stage);
        });

        btnChangePassword.setOnAction(E->{
            changePassword(txtNewPassword.getText(),txtNewPasswordConfrm.getText());
            goProfileSettingScreen(stage);
        });
        btnChangeBirthday.setOnAction(E->{
            changeBirthday(txtNewBirthday.getText());
            goProfileSettingScreen(stage);
        });
        btnChagnePhonenumber.setOnAction(E->{
            changePhone(txtNewPhoneNumber.getText());
            goProfileSettingScreen(stage);
        });
        btnChangeSecurityQuestion.setOnAction(E->{
            changeSecurityAnswer(txtSecurityQuestion.getText());
            goProfileSettingScreen(stage);
        });
        btnChangeGender.setOnAction(E->{
            changeGender(txtChangeGender.getText());
            goProfileSettingScreen(stage);
        });
        btnChangeName.setOnAction(E->{

        });
        btnApplyAll.setOnAction(E->{
            changeUsername(txtNewUsername.getText());
            changeName(txtNewName.getText());
            changePassword(txtNewPassword.getText(),txtNewPasswordConfrm.getText());
            changePhone(txtNewPhoneNumber.getText());
            changeBirthday(txtNewBirthday.getText());
            changeSecurityAnswer(txtSecurityQuestion.getText());
            changeGender(txtChangeGender.getText());
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
    public void changeUsername(String newUsername){
        if(CheckFilled(newUsername)) {
            PersonalData personalData = new PersonalData();
            personalData = ArrayKeeper.Data.get(getCurrentUser());
            personalData.setUserName(newUsername);
            ArrayKeeper.Data.set(ArrayKeeper.getCurrentUser(), personalData);
        }
    }
    public void  changePassword(String newPassword,String confirmPassword){
        if(CheckFilled(newPassword)) {
            if (newPassword.equals(confirmPassword)) {
                PersonalData personalData = new PersonalData();
                personalData = ArrayKeeper.Data.get(getCurrentUser());
                personalData.setPassword(newPassword);
                ArrayKeeper.Data.set(getCurrentUser(), personalData);
            }
        }
    }
    public void changeName(String name){
        if (CheckFilled(name)) {
            PersonalData personalData = new PersonalData();
            personalData = ArrayKeeper.Data.get(getCurrentUser());
            personalData.setName(name);
            ArrayKeeper.Data.set(getCurrentUser(), personalData);
        }
    }
    public void changeBirthday(String birthday){
        if (CheckFilled(birthday)) {
            PersonalData personalData = new PersonalData();
            personalData = ArrayKeeper.Data.get(getCurrentUser());
            personalData.setBirthDate(birthday);
            ArrayKeeper.Data.set(getCurrentUser(), personalData);
        }
    }
    public void changePhone(String phoneNumber){
        if(CheckFilled(phoneNumber)) {
            PersonalData personalData = new PersonalData();
            personalData = ArrayKeeper.Data.get(getCurrentUser());
            personalData.setPhoneNumber(phoneNumber);
            ArrayKeeper.Data.set(getCurrentUser(), personalData);
        }
    }
    public void changeSecurityAnswer(String answer){
        if(CheckFilled(answer)) {
            PersonalData personalData = new PersonalData();
            personalData = ArrayKeeper.Data.get(getCurrentUser());
            personalData.setSecurityAnswer(answer);
            //personalData.setSecurtityQuestion();
            ArrayKeeper.Data.set(getCurrentUser(), personalData);
        }
    }
    public void changeGender(String gender){
        if(CheckFilled(gender)){
            PersonalData personalData = ArrayKeeper.Data.get(getCurrentUser());
            personalData.setGender(gender);
            ArrayKeeper.Data.set(getCurrentUser(), personalData);
        }
    }
    public boolean CheckFilled(String isempety){
        boolean ret = true;
        if(isempety.equals("")){
            ret = false;
        }
        return  ret;
    }
}
