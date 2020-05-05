package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    Scene loginScene;

    @Override
    public void start(Stage primaryStage) throws Exception{

        //Login screen stuff
        Label lblUserName = new Label("Username");
        Label lblPassWord = new Label("Password");
        Button btnLogin = new Button("Log in");
        btnLogin.setOnAction(e -> {
            Homescreen home = new Homescreen();
            try {
                home.start(primaryStage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        TextField textFieldUserName = new TextField();
        PasswordField passwordField = new PasswordField();
        Pane login = new Pane();
        login.getChildren().addAll(lblUserName,lblPassWord,btnLogin,textFieldUserName,passwordField);
        lblUserName.relocate(100,50);
        textFieldUserName.relocate(100,70);
        lblPassWord.relocate(100,95);
        passwordField.relocate(100,115);
        btnLogin.relocate(100,145);

        loginScene = new Scene(login,800,600);


        primaryStage.setScene(loginScene);
        primaryStage.setTitle("Title here");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
