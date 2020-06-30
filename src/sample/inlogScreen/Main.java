package sample.inlogScreen;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;
import sample.ArrayKeeper;
import sample.GoToScreens;
import sample.Homescreen;

public class Main extends Application {
    public ArrayKeeper arraykeeper = new ArrayKeeper();
    MainMethods mainMethods = new MainMethods();
    Homescreen home = new Homescreen();
    GoToScreens goToScreens = GoToScreens.getInstance();
    Stage window;
    public Pane login = new Pane();
    final Pane pane = new Pane();

    final int initWidth = 800;
    final int initHeight = 600;

    TextField textFieldUserName = new TextField();
    PasswordField passwordField = new PasswordField();
    Label error = new Label("Sorry, try again");

    @Override
    public void start(Stage primaryStage) throws Exception{
        pane.setStyle("-fx-background-color: #add8e6");
        window = primaryStage;
        makeLabels();
        makeButtons();
        textFieldUserName.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                error.setVisible(false);
            }
        });
        fin();
        mainMethods.makeTestAccounts();//these are the demo accounts where we all can log in with, i used it to to test.
    }
    public void fin(){
        Scene loginScene = new Scene(pane,800,600);
        window.setResizable(true);
        window.setScene(loginScene);
        window.setTitle("Log in");
        window.show();
    }
    public void makeLabels(){
        error.setVisible(false);
        Label lblUserName = new Label("Username");
        Label lblPassWord = new Label("Password");
        lblPassWord.relocate(100,95);
        lblUserName.relocate(100,50);
        textFieldUserName.relocate(100,70);
        passwordField.relocate(100,115);
        error.relocate(100,200);
        pane.getChildren().addAll(textFieldUserName,passwordField,lblUserName,lblPassWord,error);
    }
    public void makeButtons(){
        makeButtonLogin(window);
        makeButtonSignUp();
        makeButtonForgotPassword();
    }
    public void makeButtonSignUp(){
        Button btnSignUp = new Button("Create an account");
        btnSignUp.setOnAction(e -> {
            goToScreens.goSignUpScreen(window);
        });
        btnSignUp.relocate(150,145);
        pane.getChildren().add(btnSignUp);
    }
    public void makeButtonForgotPassword(){
        Button btnForgotPassword = new Button("Forgot Password");
        btnForgotPassword.relocate(100,175);
        btnForgotPassword.setOnMousePressed(e->{
            goToScreens.goForgetPasswordScreen(window);
        });
        pane.getChildren().add(btnForgotPassword);
    }
    public void makeButtonLogin(Stage window){
        Button btnLogin = new Button("Log in");
        btnLogin.relocate(100,145);
        btnLogin.setOnAction(e -> {
            if(mainMethods.dataCheck(passwordField.getText(),(textFieldUserName.getText()))){
                goToScreens.goHomeScreen(window);
            }else{
                error.setVisible(true);
                error.setText("Sorry, try again");
            }
        });
        pane.getChildren().add(btnLogin);
    }
    public void reziseAble(Scene loginScene){
        loginScene.rootProperty().addListener(new ChangeListener<Parent>() {
            @Override
            public void changed(ObservableValue<? extends Parent> observableValue, Parent parent, Parent t1) {
                loginScene.rootProperty().removeListener(this);
                loginScene.setRoot(pane);
                ((Region)t1).setPrefWidth(initWidth);
                ((Region)t1).setPrefHeight(initHeight);
                pane.getChildren().clear();
                pane.getChildren().add(t1);
                loginScene.rootProperty().addListener(this);
            }
        });
    }
    public void setSize(){
        login.setPrefWidth(initWidth);
        login.setPrefHeight(initHeight);
        pane.getChildren().add(login);

        Scale scale = new Scale(1,1,0,0);
        scale.xProperty().bind(pane.widthProperty().divide(initWidth));
        scale.yProperty().bind(pane.heightProperty().divide(initHeight));
        pane.getTransforms().add(scale);
    }
    public static void main(String[] args) {
        launch(args);
    }
}
