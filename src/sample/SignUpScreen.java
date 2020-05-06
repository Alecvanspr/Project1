package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SignUpScreen extends Application {
    Scene SignUpp;
    Main main = new Main();
    //    String question1, question2, question3;
    public void start(Stage stage) throws Exception{
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
        TextField textFieldUserName = new TextField();
        PasswordField passwordField = new PasswordField();
        PasswordField passwordFieldConf = new PasswordField();
        TextField textFieldBirth = new TextField();
        Button btnRegister = new Button("Register");
        Pane register = new Pane();

        register.getChildren().addAll(lblUserName,lblPassWord,lblPassWordConf
                , textFieldUserName, passwordField, passwordFieldConf,textFieldBirth,lblBirthdate,
                securityQuestions, securityAnswer, lblSecurity,btnRegister);

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

        //dit zo een method maken
        btnRegister.setOnAction(e->{
            if((!(passwordField.getText().equals("")))&&(!(textFieldUserName.getText().equals("")))){
                System.out.println("Waar");
                if(passwordField.getText().equals(passwordFieldConf.getText())) {
                    main.arraykeeper.SignUpData(textFieldUserName.getText(),passwordField.getText(),textFieldBirth.getText(),securityAnswer.getText(),securityQuestions.getSelectionModel().getSelectedItem().toString());
                    try{
                        main.start(stage);
                    } catch (Exception ex){
                        ex.printStackTrace();
                    }
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
        });

        SignUpp = new Scene(register, 800,600);
        stage.setScene(SignUpp);
        stage.show();
    }
}
