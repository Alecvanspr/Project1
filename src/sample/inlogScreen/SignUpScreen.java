package sample.inlogScreen;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.ButtonSettings;
import sample.GoToScreens;

public class SignUpScreen extends Application {
    Scene SignUpp;
    Main main = new Main();
    ButtonSettings buttonSettings = new ButtonSettings();
    GoToScreens goToScreens = new GoToScreens();
    Pane pane = new Pane();
    CheckBox docterCheck = new CheckBox("Docter?");
    TextField docterName = new TextField("What is your name");
    Label ErrorMessage = new Label("");
    ComboBox securityQuestions = new ComboBox();
    TextField textFieldUserName = new TextField();
    PasswordField passwordField = new PasswordField();
    PasswordField passwordFieldConf = new PasswordField();
    TextField textFieldBirth = new TextField();
    TextField securityAnswer = new TextField();
    Boolean isDoctor;


    public void start(Stage stage) throws Exception{
        makeTextFields();
        makeLabels();
        makeButtons(stage);
        fin(stage);
    }
    public void fin(Stage stage){
        SignUpp = new Scene(pane, 800,600);
        stage.setTitle("Sign up");
        stage.setScene(SignUpp);
        stage.show();
    }
    public void makeTextFields(){
        pane.getChildren().addAll(textFieldUserName, passwordField, passwordFieldConf,textFieldBirth,
                securityQuestions, securityAnswer);
        textFieldUserName.relocate(100,70);
        passwordField.relocate(100,115);
        passwordFieldConf.relocate(100,160);
        textFieldBirth.relocate(100,205);
        securityQuestions.relocate(100,250);
        securityAnswer.relocate(100, 278);
    }
    public void makeLabels(){
        Label lblUserName = new Label("Username");
        Label lblPassWord = new Label("Password");
        Label lblPassWordConf = new Label("Confirm password");
        Label lblBirthdate = new Label("Birth date");
        Label lblSecurity = new Label("Security question in case you forget your password");
        securityQuestions.getItems().addAll("What is your favorite colour?","What was the name of your first pet?","What was your first city of residence?");
        lblUserName.relocate(100,50);
        lblSecurity.relocate(100,230);
        lblPassWord.relocate(100,95);
        lblBirthdate.relocate(100,185);
        lblPassWordConf.relocate(100, 140);
        ErrorMessage.relocate(100,265);
        pane.getChildren().addAll(lblUserName,lblPassWord,lblPassWordConf,lblBirthdate,lblSecurity,docterCheck,docterName,ErrorMessage);
    }
    public void makeButtons(Stage stage){
        makeBtnRegister(stage);
        makeBtnBack(stage);
    }
    public void makeBtnBack(Stage stage){
        Button btnBack = new Button("Back");
        btnBack.relocate(0, 570);

        btnBack.setOnAction(e -> { //dit wordt zo een OK knop.
            goToScreens.goMain(stage);
        });
        buttonSettings.onMouse(btnBack);
        pane.getChildren().add(btnBack);
    }
    public void makeBtnRegister(Stage stage){
        Button btnRegister = new Button("Register");
        btnRegister.setOnAction(e->{
            Object registerData[] = {passwordField.getText(),passwordFieldConf.getText(),textFieldUserName.getText(),
                    textFieldBirth.getText(),securityAnswer.getText(),securityQuestions.getSelectionModel().getSelectedItem().toString(),docterCheck.isSelected()};
            register(stage,registerData);
        });
        buttonSettings.onMouse(btnRegister);
        btnRegister.relocate(100,320);
        pane.getChildren().add(btnRegister);
    }

    //deze laat ik er in omdat het een javaFX class is.
    public void register(Stage stage,Object registerData[]){
        if((!(registerData[0].equals("")))&&(!(registerData[2].equals("")))){
            if(registerData[0].equals(registerData[1])) {
                main.arraykeeper.SignUpData(registerData);
                toDocter(Boolean.parseBoolean(registerData[6].toString()),stage);
            }else {
                ErrorMessage.setText("Passwords don't match");
            }
        }else{
            ErrorMessage.setText("Fields are empty");
        }
    }
    public void toDocter(boolean isDocter,Stage stage){
        if(isDocter) {
            goToScreens.goSignUpDoctorScreen(stage);
        }else{
            goToScreens.goMain(stage);
        }
    }
}
