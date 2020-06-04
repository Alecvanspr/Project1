package sample.inlogScreen;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.GoToScreens;

public class ForgotPasswordScreen extends Application {
    Scene ForgotPassword;
    ForgotPassword forgotPassword = new ForgotPassword();
    GoToScreens goToScreens = new GoToScreens();
    Main main = new Main();
    public int changingUser;
    public Label lblError = new Label();

    @Override
    public void start(Stage stage) throws Exception {
        Pane Forgot = new Pane();
        Button btnBack = new Button("Back");
        Label lblUsername = new Label("Username");
        Label lblBirthDate = new Label("Birth date");
        Label lblSecurityQuestion = new Label("Click here to reveal your Security Question");
        Label lblnewPassword = new Label("New password");
        Label lblnewPasswordConfirm = new Label("Enter new password again");

        TextField txtUsername = new TextField();
        TextField txtBirth = new TextField();
        TextField security = new TextField();
        PasswordField txtPassword = new PasswordField();
        PasswordField txtPasswordConfirm = new PasswordField();
        Button ChangePassword = new Button("Change Password");

        lblUsername.relocate(100,50);
        txtUsername.relocate(100,75);
        lblBirthDate.relocate(100,100);
        txtBirth.relocate(100,125);
        lblSecurityQuestion.relocate(100,150);
        security.relocate(100,175);
        lblnewPassword.relocate(100,200);
        txtPassword.relocate(100,225);
        lblnewPasswordConfirm.relocate(100,250);
        txtPasswordConfirm.relocate(100,275);
        ChangePassword.relocate(100,335);
        lblError.relocate(100,314);

        lblSecurityQuestion.setOnMouseClicked(e->{
                changingUser= forgotPassword.getUser(txtUsername.getText());
                setSecurityQuestion(lblSecurityQuestion);
                });

        Forgot.getChildren().addAll(btnBack,lblUsername,txtUsername,lblBirthDate,txtBirth,lblSecurityQuestion,security
        ,txtPassword,txtPasswordConfirm,lblnewPassword,lblnewPasswordConfirm,ChangePassword,lblError);
        btnBack.relocate(0, 570);

        ChangePassword.setOnAction(e->{
            changePassword(security.getText(),txtPassword.getText(),txtPasswordConfirm.getText(),stage);
        });

        btnBack.setOnAction(e -> { //dit wordt zo een OK knop.
            goToScreens.goMain(stage);
        });
        btnBack.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                btnBack.setScaleX(1.1);
                btnBack.setScaleY(1.1);

            }
        });
        btnBack.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                btnBack.setScaleX(1);
                btnBack.setScaleY(1);

            }
        });
        ChangePassword.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                ChangePassword.setScaleX(1.1);
                ChangePassword.setScaleY(1.1);

            }
        });
        ChangePassword.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                ChangePassword.setScaleX(1);
                ChangePassword.setScaleY(1);

            }
        });

        ForgotPassword = new Scene(Forgot, 800, 600);
        stage.setTitle("Reset Password");
        stage.setScene(ForgotPassword);
        stage.show();
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
