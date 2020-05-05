package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SignUpScreen extends Application {
    Scene SignUpp;
    Main main;
    ArrayKeeper arrayKeeper;
    public void start(Stage stage) throws Exception{
        Label lblUserName = new Label("Username");
        Label lblPassWord = new Label("Password");
        Label lblPassWordConf = new Label("Confirm password");
        Label lblBirthdate = new Label("Birth date");
        TextField textFieldUserName = new TextField();
        PasswordField passwordField = new PasswordField();
        PasswordField passwordFieldConf = new PasswordField();
        TextField textFieldBirth = new TextField();
        textFieldBirth.autosize();
        Button btnRegister = new Button("Register");
        Pane register = new Pane();

        register.getChildren().addAll(lblUserName,lblPassWord,lblPassWordConf
                , textFieldUserName, passwordField, passwordFieldConf, btnRegister,textFieldBirth,lblBirthdate);

        lblUserName.relocate(100,50);
        textFieldUserName.relocate(100,70);
        lblPassWord.relocate(100,95);
        passwordField.relocate(100,115);
        lblPassWordConf.relocate(100, 140);
        passwordFieldConf.relocate(100,160);
        lblBirthdate.relocate(100,185);
        textFieldBirth.relocate(100,205);
        btnRegister.relocate(100,235);

        btnRegister.setOnAction(e->{
            if((!(passwordField.getText().equals("")))&&(!(textFieldUserName.getText().equals("")))){
                if(passwordField.getText().equals(passwordFieldConf.getText())) {
                    arrayKeeper.SignUpData(textFieldUserName.getText(), passwordField.getText(), textFieldBirth.getText());
                }else {
                    Label passwordWrong = new Label("Passwords don't match");
                    passwordWrong.relocate(100,265);
                    register.getChildren().add(passwordWrong);
                }
            }else{
                    Label emptyFields = new Label("Fields are empty");
                    emptyFields.relocate(100,265);
                    register.getChildren().add(emptyFields);
            }
            Main main = new Main();
            try {
                main.start(stage);
            } catch (Exception ex){
                ex.printStackTrace();
            }
        });

        SignUpp = new Scene(register, 800,600);
        stage.setScene(SignUpp);
        stage.show();
    }
}