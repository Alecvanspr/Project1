package sample.inlogScreen;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.ButtonSettings;
import sample.GoToScreens;

public class ForgotPasswordScreen extends Application {
    Scene ForgotPassword;
    ForgotPassword forgotPassword = new ForgotPassword();
    ButtonSettings buttonSettings = new ButtonSettings();
    GoToScreens goToScreens = new GoToScreens();
    Main main = new Main();
    public int changingUser;
    public Label lblError = new Label();
    Pane pane = new Pane();

    TextField txtUsername = new TextField();
    TextField txtBirth = new TextField();
    TextField security = new TextField();
    PasswordField txtPassword = new PasswordField();
    PasswordField txtPasswordConfirm = new PasswordField();

    @Override
    public void start(Stage stage) throws Exception {
        makeTextFields();
        makeButtons(stage);
        fin(stage);
    }
    public void fin(Stage stage){
        ForgotPassword = new Scene(pane, 800, 600);
        stage.setTitle("Reset Password");
        stage.setScene(ForgotPassword);
        stage.show();
    }
    public void makeButtons(Stage stage){
        makeBtnBack(stage);
        makeBtnChangePassword(stage);
        makeSecurityLabel();
    }
    public void makeSecurityLabel(){
        lblError.relocate(100,314);
        Label lblSecurityQuestion = new Label("Click here to reveal your Security Question");
        lblSecurityQuestion.relocate(100,150);
        lblSecurityQuestion.setOnMouseClicked(e->{
            changingUser= forgotPassword.getUser(txtUsername.getText());
            setSecurityQuestion(lblSecurityQuestion);
        });
        pane.getChildren().add(lblSecurityQuestion);
    }
    public void makeTextFields(){
        txtUsername.relocate(100,75);
        txtBirth.relocate(100,125);
        security.relocate(100,175);
        txtPassword.relocate(100,225);
        txtPasswordConfirm.relocate(100,275);
        pane.getChildren().addAll(txtUsername,txtBirth,security
                ,txtPassword,txtPasswordConfirm,lblError);
    }
    public void makeLabels(){
        Label lblUsername = new Label("Username");
        Label lblBirthDate = new Label("Birth date");
        Label lblnewPassword = new Label("New password");
        Label lblnewPasswordConfirm = new Label("Enter new password again");
        lblUsername.relocate(100,50);
        lblnewPasswordConfirm.relocate(100,250);
        lblnewPassword.relocate(100,200);
        lblBirthDate.relocate(100,100);
        pane.getChildren().addAll(lblBirthDate,lblnewPassword,lblUsername,lblnewPasswordConfirm);
    }
    public void makeBtnChangePassword(Stage stage){
        Button ChangePassword = new Button("Change Password");
        ChangePassword.relocate(100,335);
        pane.getChildren().add(ChangePassword);
        ChangePassword.setOnAction(e->{
            changePassword(security.getText(),txtPassword.getText(),txtPasswordConfirm.getText(),stage);
        });
    }
    public void makeBtnBack(Stage stage){
        Button btnBack = new Button("Back");
        btnBack.setOnAction(e -> {
            goToScreens.goMain(stage);
        });
        buttonSettings.onMouse(btnBack);
        btnBack.relocate(0, 570);
        pane.getChildren().add(btnBack);
    }
    public void setSecurityQuestion(Label label){
        label.setText(main.arraykeeper.getPersonaldata().get(changingUser).getSecurtityQuestion());
    }
    public void changePassword(String secutiry,String password,String passwordcheck,Stage stage){
        if(secutiry.equalsIgnoreCase(main.arraykeeper.getPersonaldata().get(changingUser).getSecurityAnswer())) {
            if (password.equals(passwordcheck)) {
                main.arraykeeper.changePassword(changingUser, password);
                goToScreens.goMain(stage);
            } else {
                lblError.setText("Passwords do not match");
            }
        }else{
            lblError.setText("Question Wrong");
        }
    }
}
