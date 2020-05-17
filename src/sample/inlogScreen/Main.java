package sample.inlogScreen;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;
import sample.ArrayKeeper;
import sample.Homescreen;

public class Main extends Application {
    public ArrayKeeper arraykeeper = new ArrayKeeper();
    Homescreen home = new Homescreen();
    Stage window;
    public Pane login = new Pane();


    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        final int initWidth = 800;
        final int initheight = 600;
        final Pane root = new Pane();

        login.setPrefWidth(initWidth);
        login.setPrefHeight(initheight);
        root.getChildren().add(login);

        Scale scale = new Scale(1,1,0,0);
        scale.xProperty().bind(root.widthProperty().divide(initWidth));
        scale.yProperty().bind(root.heightProperty().divide(initheight));
        root.getTransforms().add(scale);

        //this are all the buttons
        Label lblUserName = new Label("Username");
        Label lblPassWord = new Label("Password");
        Button btnForgotPassword = new Button("Forgot Password");
        Button btnLogin = new Button("Log in");
        Button btnSignUp = new Button("Create an account");

        delettis(); //this is the demo account where we all can log in with, i used it to to test. but it need to be deleted afterwards

        TextField textFieldUserName = new TextField();
        PasswordField passwordField = new PasswordField();
        Label error = new Label("Sorry, try again");

        login.getChildren().addAll(textFieldUserName,passwordField,lblUserName,lblPassWord,btnLogin,btnSignUp, btnForgotPassword);
        lblUserName.relocate(100,50);
        textFieldUserName.relocate(100,70);
        lblPassWord.relocate(100,95);
        passwordField.relocate(100,115);
        btnLogin.relocate(100,145);
        btnSignUp.relocate(150,145);
        btnForgotPassword.relocate(100,175);


        textFieldUserName.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                login.getChildren().remove(error);
            }
        });

        btnLogin.setOnAction(e -> {
            if(gegevensCheck(passwordField.getText(),(textFieldUserName.getText()))){
                try {
                    home.start(window);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }else{
                login.getChildren().add(error);
                error.relocate(100,200);
            }
        });
        btnSignUp.setOnAction(e -> {
            goSignUp();
        });

        btnForgotPassword.setOnMousePressed(e->{
            goForgetPassword();
        });

        //login.setMinSize(800,600);
        //window.setMinHeight(600);
        //window.setMinWidth(800);
        Scene loginScene = new Scene(root,800,600);
        window.setResizable(true);
        window.setScene(loginScene);
        window.setTitle("Log in");
        window.show();

        loginScene.rootProperty().addListener(new ChangeListener<Parent>() {
            @Override
            public void changed(ObservableValue<? extends Parent> observableValue, Parent parent, Parent t1) {
                loginScene.rootProperty().removeListener(this);
                loginScene.setRoot(root);
                ((Region)t1).setPrefWidth(initWidth);
                ((Region)t1).setPrefHeight(initheight);
                root.getChildren().clear();
                root.getChildren().add(t1);
                loginScene.rootProperty().addListener(this);
            }
        });


    }

    public boolean gegevensCheck(String password,String username){
        boolean ret = false;
        int s = 0;
        for(int i = 0;i<arraykeeper.Data.size();i++){
            if(ArrayKeeper.Data.get(i).getUsername().equals(username)){
                if(arraykeeper.Data.get(i).getPassword().equals(password)){
                    ret = true;
                    s = i;
                }
            }
        }
        arraykeeper.setCurrentUser(s);
        return ret;
    }
    public void goForgetPassword(){
        ForgotPassword forgotPassword = new ForgotPassword();
        try{
            forgotPassword.start(window);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void goSignUp(){
        SignUpScreen signUpScreen = new SignUpScreen();
        try{
            signUpScreen.start(window);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }


    public void delettis(){
        //dit is om te testen, dit moet achteraf verwijderd worden.
        arraykeeper.SignUpData("Admin","Admin","Yesterday","Bruh","You have to insert your username first");
        PersonalData Admin = new PersonalData();
        Admin.setUserName("admin");
        Admin.setPassword("admin");
        Admin.setBirthDate("admin");
        Admin.setSecurtityQuestion("Oh yeah, Mister crabs");
        Admin.setSecurityAnswer("dab");
        arraykeeper.Data.add(Admin);
    }
    public static void main(String[] args) {
        launch(args);
    }
}
