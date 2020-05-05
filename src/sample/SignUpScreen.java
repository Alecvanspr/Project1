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
    public void start(Stage stage) throws Exception{
        Label lblUserName = new Label("Username");
        Label lblPassWord = new Label("Password");
        Label lblPassWordConf = new Label("Confirm password");
        TextField textFieldUserName = new TextField();
        PasswordField passwordField = new PasswordField();
        PasswordField passwordFieldConf = new PasswordField();
        Button btnRegister = new Button("Register");
        Pane register = new Pane();

        register.getChildren().addAll(lblUserName,lblPassWord,lblPassWordConf
        , textFieldUserName, passwordField, passwordFieldConf, btnRegister);

        lblUserName.relocate(100,50);
        textFieldUserName.relocate(100,70);
        lblPassWord.relocate(100,95);
        passwordField.relocate(100,115);
        lblPassWordConf.relocate(100, 140);
        passwordFieldConf.relocate(100,160);
        btnRegister.relocate(100,190);

        SignUpp = new Scene(register, 800,600);
        stage.setScene(SignUpp);
        stage.show();
    }
}
