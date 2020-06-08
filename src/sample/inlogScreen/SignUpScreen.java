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
    //    String question1, question2, question3;
    public void start(Stage stage) throws Exception{
        Button btnBack = new Button("Back");
        Label lblUserName = new Label("Username");
        Label lblPassWord = new Label("Password");
        Label lblPassWordConf = new Label("Confirm password");
        Label lblBirthdate = new Label("Birth date");
        Label lblSecurity = new Label("Security question in case you forget your password");
        ComboBox securityQuestions = new ComboBox();
        securityQuestions.getItems().addAll("What is your favorite colour?",
                "What was the name of your first pet?",
                "What was your first city of residence?");
        TextField securityAnswer = new TextField();
        CheckBox checkBox = new CheckBox();

        TextField textFieldUserName = new TextField();
        PasswordField passwordField = new PasswordField();
        PasswordField passwordFieldConf = new PasswordField();
        TextField textFieldBirth = new TextField();

        Button btnRegister = new Button("Register");
        Pane register = new Pane();

        register.getChildren().addAll(lblUserName,lblPassWord,lblPassWordConf
                , textFieldUserName, passwordField, passwordFieldConf,textFieldBirth,lblBirthdate,
                securityQuestions, securityAnswer, lblSecurity,btnRegister,btnBack);

        lblUserName.relocate(100,50);
        textFieldUserName.relocate(100,70);
        lblPassWord.relocate(100,95);
        passwordField.relocate(100,115);
        lblPassWordConf.relocate(100, 140);
        passwordFieldConf.relocate(100,160);
        lblBirthdate.relocate(100,185);
        textFieldBirth.relocate(100,205);
        lblSecurity.relocate(100,230);
        securityQuestions.relocate(100,250);
        securityAnswer.relocate(100, 278);
        btnRegister.relocate(100,320);
        btnBack.relocate(0, 570);

        btnRegister.setOnAction(e->{
            register(stage,register,passwordField.getText(),passwordFieldConf.getText(),textFieldUserName.getText(),
                    textFieldBirth.getText(),securityAnswer.getText(),securityQuestions.getSelectionModel().getSelectedItem().toString());
        });
        btnBack.setOnAction(e -> { //dit wordt zo een OK knop.
            goToScreens.goMain(stage);
        });

        buttonSettings.onMouse(btnBack);
        buttonSettings.onMouse(btnRegister);


        register.getChildren().addAll(checkBox);
        SignUpp = new Scene(register, 800,600);
        stage.setTitle("Sign up");
        stage.setScene(SignUpp);
        stage.show();
    }

    //deze laat ik er in omdat het een javaFX class is.
    public void register(Stage stage,Pane register,String password,String PasswordConfig, String username,String birthday,String securityAnswer,String securityQuestions){
        if((!(password.equals("")))&&(!(username.equals("")))){
            if(password.equals(PasswordConfig)) {
                main.arraykeeper.SignUpData(username,password,birthday,securityAnswer,securityQuestions);
                goToScreens.goMain(stage);
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
    }
}
