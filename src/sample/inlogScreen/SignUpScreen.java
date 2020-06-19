package sample.inlogScreen;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.ButtonSettings;
import sample.GoToScreens;

public class SignUpScreen extends Application {
    Scene SignUp;
    Main main = new Main();
    ButtonSettings buttonSettings =ButtonSettings.getInstance();
    GoToScreens goToScreens = GoToScreens.getInstance();
    Pane pane = new Pane();
    //TextField doctorName = new TextField("What is your name");
    Label ErrorMessage = new Label("");
    ComboBox securityQuestions = new ComboBox();
    TextField textFieldUserName = new TextField();
    PasswordField passwordField = new PasswordField();
    PasswordField passwordFieldConf = new PasswordField();
    TextField textFieldBirth = new TextField();
    TextField securityAnswer = new TextField();

    public void start(Stage stage) throws Exception{
        makeTextFields();
        makeLabels();
        makeButtons(stage);
        fin(stage);
        //doctorName.relocate(200, 300);
    }

    public void fin(Stage stage){
        SignUp = new Scene(pane, 800,600);
        stage.setTitle("Sign up");
        stage.setScene(SignUp);
        stage.show();
    }

    public void makeTextFields(){
        pane.getChildren().addAll(textFieldUserName, passwordField, passwordFieldConf,textFieldBirth,
                securityQuestions, securityAnswer);
        textFieldUserName.relocate(100,70);
        passwordField.relocate(100,115);
        passwordFieldConf.relocate(100,160);
        textFieldBirth.relocate(100,205);
        securityQuestions.relocate(100,250);
        securityAnswer.relocate(100, 278);
    }

    public void makeLabels(){
        Label lblUserName = new Label("Username");
        Label lblPassWord = new Label("Password");
        Label lblPassWordConf = new Label("Confirm password");
        Label lblDateOfBirth = new Label("Date of birth");
        Label lblSecurity = new Label("Security question in case you forget your password");
        securityQuestions.getItems().addAll("What is your favorite color?","What was the name of your first pet?","What was your first city of residence?");
        lblUserName.relocate(100,50);
        lblSecurity.relocate(100,230);
        lblPassWord.relocate(100,95);
        lblDateOfBirth.relocate(100,185);
        lblPassWordConf.relocate(100, 140);
        ErrorMessage.relocate(100,265);
        pane.getChildren().addAll(lblUserName,lblPassWord,lblPassWordConf,lblDateOfBirth,lblSecurity,ErrorMessage);
    }

    public void makeButtons(Stage stage){
        makeBtnRegister(stage);
        makeBtnBack(stage);
        makeBtnSignUpAsDoctor(stage);
    }

    public void makeBtnBack(Stage stage){
        Button btnBack = new Button("Back");
        btnBack.relocate(0, 570);
        btnBack.setOnAction(e -> { //dit wordt zo een OK knop.
            goToScreens.goMain(stage);
        });
        buttonSettings.onMouse(btnBack);
        pane.getChildren().add(btnBack);
    }

    public void makeBtnSignUpAsDoctor(Stage stage){
        Button btnSignUpAsDoctor = new Button("Sign up as doctor");
        btnSignUpAsDoctor.setOnAction(E -> {
            goToScreens.goSignUpDoctorScreen(stage);
        });
        pane.getChildren().add(btnSignUpAsDoctor);
    }

    public void makeBtnRegister(Stage stage){
        Button btnRegister = new Button("Register");
        btnRegister.setOnAction(e->{
            //String username, String name, String password, String dateOfBirth, String securityQuestion, String securityAnswer
            String[] data = {textFieldUserName.getText(),textFieldUserName.getText(),passwordField.getText(),textFieldBirth.getText(),securityQuestions.getValue().toString(),securityAnswer.getText()};
            signUp(stage,data,passwordFieldConf.getText());
        });
        buttonSettings.onMouse(btnRegister);
        btnRegister.relocate(100,320);
        pane.getChildren().add(btnRegister);
    }

    //String username, String name,String password,String birthday, String securityQuestions,String securityAnswer
    public void signUp(Stage stage, String[] signUpData,String PasswordConfig){
        if((!(signUpData[2].equals("")))&&(!(signUpData[0].equals("")))){
            if(signUpData[2].equals(PasswordConfig)) {
                main.arraykeeper.SignUpData(signUpData);
                goToScreens.goMain(stage);
            }else {
                ErrorMessage.setText("Passwords don't match");
            }
        }else{
            ErrorMessage.setText("Fields are empty");
        }
    }
    public void toDoctor(boolean isDoctor, Stage stage){
        if(isDoctor){
            goToScreens.goSignUpDoctorScreen(stage);
        }
        else{
            goToScreens.goMain(stage);
        }
    }
}
