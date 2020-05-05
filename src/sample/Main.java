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
    public ArrayList<PersonalData> persons = new ArrayList<>();
    private int currentUser;
    private String gebruiker;
    Scene loginScene;

    @Override
    public void start(Stage primaryStage) throws Exception{

        //Login screen stuff
        Label lblUserName = new Label("Username");
        Label lblPassWord = new Label("Password");
        Button btnLogin = new Button("Log in");
        Button btnSignUp = new Button("Create an account");

        delettis();


        TextField textFieldUserName = new TextField();
        PasswordField passwordField = new PasswordField();
        Pane login = new Pane();
        login.getChildren().addAll(lblUserName,lblPassWord,btnLogin,textFieldUserName,passwordField,btnSignUp);
        lblUserName.relocate(100,50);
        textFieldUserName.relocate(100,70);
        lblPassWord.relocate(100,95);
        passwordField.relocate(100,115);
        btnLogin.relocate(100,145);
        btnSignUp.relocate(150,145);

        btnLogin.setOnAction(e -> {
            if(gegevensCheck(passwordField.getText(),(textFieldUserName.getText()))){
                Homescreen home = new Homescreen();
                try {
                    home.start(primaryStage);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }else{
                Label error = new Label("Sorry, try again");
                login.getChildren().add(error);
                error.relocate(400,400);
            }
        });
        btnSignUp.setOnAction(e -> {
            SignUpScreen signUpScreen = new SignUpScreen();
            try{
                signUpScreen.start(primaryStage);
            } catch (Exception ex){
                ex.printStackTrace();
            }
        });

        loginScene = new Scene(login,800,600);
        login.setMinSize(800,600);


        primaryStage.setScene(loginScene);
        primaryStage.setTitle("Log in");
        primaryStage.show();
    }

    public boolean gegevensCheck(String password,String username){
        boolean ret = false;
        int s = 0;
        for(int i = 0;i<persons.size();i++){
            System.out.println(persons.get(i).getName());
            System.out.println(persons.get(i).getPassword());
            if(persons.get(i).getName().equals(username)){
                if(persons.get(i).getPassword().equals(password)){
                    ret = true;
                    s = i;
                }
            }
        }
        setCurrentUser(s);
        return ret;
    }
    public void delettis(){
        //array vullen, later moet dit weg
        PersonalData Admin = new PersonalData();
        Admin.setName("admin");
        Admin.setPassword("admin");
        Admin.setBirthDate("admin");
        persons.add(Admin);
    }
    public int getCurrentUser(){
        return currentUser;
    }
    public void setCurrentUser(int currentUser){
        this.currentUser = currentUser;
    }
    //dit is de arraylist van die class.
    public ArrayList<PersonalData> getPersons(){
        return persons;
    }
    public static void main(String[] args) {
        launch(args);
    }
}
