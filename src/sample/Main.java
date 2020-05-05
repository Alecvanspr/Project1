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

import java.util.ArrayList;

public class Main extends Application {
    public ArrayList<String> Usernames = new ArrayList<>();
    private String gebruiker;
    public ArrayList<String> Passwords = new ArrayList<>();
    Scene loginScene;

    @Override
    public void start(Stage primaryStage) throws Exception{

        //Login screen stuff
        Label lblUserName = new Label("Username");
        Label lblPassWord = new Label("Password");
        Button btnLogin = new Button("Log in");
        Button btnSignUp = new Button("Create an account");

        //array vullen, later moet dit weg
        Usernames.add("Admin");
        Passwords.add("Admin");
        Usernames.add("Alec");
        Passwords.add("1234");

        TextField textFieldUserName = new TextField();
        PasswordField passwordField = new PasswordField();
        Pane login = new Pane();
        login.getChildren().addAll(lblUserName,lblPassWord,btnSignUp, btnLogin,textFieldUserName,passwordField);
        lblUserName.relocate(100,50);
        textFieldUserName.relocate(100,70);
        lblPassWord.relocate(100,95);
        passwordField.relocate(100,115);
        btnLogin.relocate(100,145);
        btnSignUp.relocate(150,145);

        btnSignUp.setOnAction(e -> {
            SignUpScreen signUpScreen = new SignUpScreen();
            try{
                signUpScreen.start(primaryStage);
            } catch (Exception ex){
                ex.printStackTrace();
            }
        });

        btnLogin.setOnAction(e -> {
            System.out.println(textFieldUserName.getText());
            System.out.println(passwordField.getText());
            if(gegevensCheck(passwordField.getText(),(textFieldUserName.getText()))){
            Homescreen home = new Homescreen();
            try {
                home.start(primaryStage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }}
            else{
                Label error = new Label("Sorry, try again");
                login.getChildren().add(error);
                error.relocate(400,400);
            }
        });

        loginScene = new Scene(login,800,600);


        primaryStage.setScene(loginScene);
        primaryStage.setTitle("Title here");
        primaryStage.show();
    }

    public boolean gegevensCheck(String password,String username){
        boolean ret = false;
        for(int i=0;i<Usernames.size();i++){
            if(Usernames.get(i).equals(username)&&(Passwords.get(i).equals(password))){
                ret = true;
            }
        }
        return ret;
    }
    public void setGebruiker(String gebruiker){
        this.gebruiker = gebruiker;
    }
    public String getGebruiker(){
        return gebruiker;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
