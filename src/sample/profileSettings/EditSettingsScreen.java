package sample.profileSettings;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.ButtonSettings;
import sample.GoToScreens;

public class EditSettingsScreen extends Application {
    Scene changeSettings;
    EditSetings editSetings = new EditSetings();
    GoToScreens goToScreens = new GoToScreens();
    //ButtonSettings ButtonSettings = new ButtonSettings();
    Pane eSettings = new Pane();

    Label text = new Label("Settings to change user settings");
    TextField txtNewUsername = new TextField();
    TextField txtNewName = new TextField();
    PasswordField txtNewPassword = new PasswordField();
    PasswordField txtNewPasswordConfrm = new PasswordField();
    TextField txtNewBirthday = new TextField();
    TextField txtNewPhoneNumber = new TextField();
    TextField txtSecurityQuestion = new TextField();
    TextField txtChangeGender = new TextField();
        public void start(Stage stage) throws Exception {
        //De code hieronder heeft te maken met de knoppen voor het edit Scherm

        eSettings.getChildren().addAll(txtNewUsername,txtNewName,txtNewPassword,txtNewPasswordConfrm,
                txtNewBirthday,txtSecurityQuestion,text,txtNewPhoneNumber,txtChangeGender);

        relocateLabels();
        makeButtons(stage);
        fin(stage);
    }
    public void fin(Stage stage){
        changeSettings = new Scene(eSettings,800,600);
        stage.setTitle("Change Settings");
        stage.setScene(changeSettings);
        stage.show();
    }
    public void relocateLabels(){
        txtNewUsername.relocate(100,100);
        txtNewName.relocate(100,135);
        txtNewPassword.relocate(100,170);
        txtNewPasswordConfrm.relocate(100,195);
        txtNewBirthday.relocate(100,230);
        txtSecurityQuestion.relocate(100,265);
        txtNewPhoneNumber.relocate(100,300);
        txtChangeGender.relocate(100,335);
        text.relocate(100,65);
    }
    public void makeButtons(Stage stage){
        makeBtnApplyAll(stage);
        makeBtnBack(stage);
        makeBtnChangeName(stage);
        makeBtnUserName(stage);
        makeBtnChangePassword(stage);
        makeBtnChangeBirthday(stage);
        makeBtnChangeGender(stage);
        makeBtnChangePhoneNumber(stage);
        makeBtnSecurityQuestion(stage);
    }
    public void makeBtnApplyAll(Stage stage){
        Button btnApplyAll = new Button("Apply all");
        btnApplyAll.relocate(300,370);
        btnApplyAll.setOnAction(E->{
            editSetings.changeUsername(txtNewUsername.getText());
            editSetings.changeName(txtNewName.getText());
            editSetings.changePassword(txtNewPassword.getText(),txtNewPasswordConfrm.getText());
            editSetings.changePhone(txtNewPhoneNumber.getText());
            editSetings.changeBirthday(txtNewBirthday.getText());
            editSetings.changeSecurityAnswer(txtSecurityQuestion.getText());
            editSetings.changeGender(txtChangeGender.getText());
            goToScreens.goProfileSettingScreen(stage);
        });
        ButtonSettings.onMouse(btnApplyAll);
        eSettings.getChildren().add(btnApplyAll);
    }
    public void makeBtnBack(Stage stage){
        Button btnBack = new Button("Back");
        ButtonSettings.onMouse(btnBack);
        btnBack.relocate(0,570);
        btnBack.setOnAction(e -> {
            goToScreens.goProfileSettingScreen(stage);
        });
        eSettings.getChildren().add(btnBack);
    }
    public void makeBtnChangeName(Stage stage){
        Button btnChangeName = new Button("Change name");
        ButtonSettings.onMouse(btnChangeName);
        btnChangeName.setOnAction(E->{
            editSetings.changeName(txtNewName.getText());
            goToScreens.goProfileSettingScreen(stage);
        });
        btnChangeName.relocate(300,135);
        eSettings.getChildren().add(btnChangeName);
    }
    public void makeBtnUserName(Stage stage){
        Button btnChangeUsername = new Button("Change Username");
        ButtonSettings.onMouse(btnChangeUsername);
        btnChangeUsername.setOnAction(E->{
            editSetings.changeUsername(txtNewUsername.getText());
            goToScreens.goProfileSettingScreen(stage);
        });
        btnChangeUsername.relocate(300,100);
        eSettings.getChildren().add(btnChangeUsername);
    }
    public void makeBtnChangePassword(Stage stage){
        Button btnChangePassword = new Button("Change password");
        ButtonSettings.onMouse(btnChangePassword);
        btnChangePassword.setOnAction(E->{
            editSetings.changePassword(txtNewPassword.getText(),txtNewPasswordConfrm.getText());
            goToScreens.goProfileSettingScreen(stage);
        });
        btnChangePassword.relocate(300,195);
        eSettings.getChildren().add(btnChangePassword);
    }
    public void makeBtnChangeGender(Stage stage){
        Button btnChangeGender = new Button("Change Gender");
        btnChangeGender.relocate(300,335);
        btnChangeGender.setOnAction(E->{
            editSetings.changeGender(txtChangeGender.getText());
            goToScreens.goProfileSettingScreen(stage);
        });
        ButtonSettings.onMouse(btnChangeGender);
        eSettings.getChildren().add(btnChangeGender);
    }
    public void makeBtnChangeBirthday(Stage stage){
        Button btnChangeBirthday = new Button("Change Birthday");
        ButtonSettings.onMouse(btnChangeBirthday);
        btnChangeBirthday.relocate(300,230);
        btnChangeBirthday.setOnAction(E->{
            editSetings.changeBirthday(txtNewBirthday.getText());
            goToScreens.goProfileSettingScreen(stage);
        });
        eSettings.getChildren().add(btnChangeBirthday);
    }
    public void makeBtnChangePhoneNumber(Stage stage){
        Button btnChagnePhonenumber = new Button("Change phonenumber");
        ButtonSettings.onMouse(btnChagnePhonenumber);
        btnChagnePhonenumber.setOnAction(E->{
            editSetings.changePhone(txtNewPhoneNumber.getText());
            goToScreens.goProfileSettingScreen(stage);
        });
        btnChagnePhonenumber.relocate(300,300);
        eSettings.getChildren().add(btnChagnePhonenumber);
    }
    public void makeBtnSecurityQuestion(Stage stage){
        Button btnChangeSecurityQuestion = new Button("Change Security question");
        ButtonSettings.onMouse(btnChangeSecurityQuestion);
        btnChangeSecurityQuestion.relocate(300,265);
        btnChangeSecurityQuestion.setOnAction(E->{
            editSetings.changeSecurityAnswer(txtSecurityQuestion.getText());
            goToScreens.goProfileSettingScreen(stage);
        });
        eSettings.getChildren().add(btnChangeSecurityQuestion);
    }
}
