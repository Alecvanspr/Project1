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
    public ArrayKeeper arraykeeper = new ArrayKeeper();
    Homescreen home = new Homescreen();
    Stage window;
    public Pane login = new Pane();

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        //Login screen stuff
        Label lblUserName = new Label("Username");
        Label lblPassWord = new Label("Password");
        Button btnForgotPassword = new Button("Forgot Password");
        Button btnLogin = new Button("Log in");
        Button btnSignUp = new Button("Create an account");

        delettis();

        TextField textFieldUserName = new TextField();
        PasswordField passwordField = new PasswordField();
        login.getChildren().addAll(textFieldUserName,passwordField,lblUserName,lblPassWord,btnLogin,btnSignUp, btnForgotPassword);
        lblUserName.relocate(100,50);
        textFieldUserName.relocate(100,70);
        lblPassWord.relocate(100,95);
        passwordField.relocate(100,115);
        btnLogin.relocate(100,145);
        btnSignUp.relocate(150,145);
        btnForgotPassword.relocate(100,175);

        btnLogin.setOnAction(e -> {
            if(gegevensCheck(passwordField.getText(),(textFieldUserName.getText()))){
                try {
                    home.start(window);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }else{
                Label error = new Label("Sorry, try again");
                login.getChildren().add(error);
                error.relocate(100,200);
            }
        });
        btnSignUp.setOnAction(e -> {
            SignUpScreen signUpScreen = new SignUpScreen();
            try{
                signUpScreen.start(window);
            } catch (Exception ex){
                ex.printStackTrace();
            }
        });

        btnForgotPassword.setOnMousePressed(e->{
            ForgotPassword forgotPassword = new ForgotPassword();
            try{
                forgotPassword.start(window);
            } catch (Exception ex){
                ex.printStackTrace();
            }
        });


        login.setMinSize(800,600);
        window.setMinHeight(800);
        window.setMinWidth(800);
        Scene loginScene = new Scene(login,800,600);
        window.setScene(loginScene);
        window.setTitle("Log in");
        window.show();
    }

    public boolean gegevensCheck(String password,String username){
        boolean ret = false;
        int s = 0;
        for(int i = 0;i<arraykeeper.Data.size();i++){
            if(ArrayKeeper.Data.get(i).getName().equals(username)){
                if(arraykeeper.Data.get(i).getPassword().equals(password)){
                    ret = true;
                    s = i;
                }
            }
        }
        arraykeeper.setCurrentUser(s);
        return ret;
    }
    public void delettis(){
        //dit is om te testen, dit moet achteraf verwijderd worden.
        arraykeeper.SignUpData("Admin","Admin","Yesterday","Bruh","Best wel");
        PersonalData Admin = new PersonalData();
        Admin.setName("admin");
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
