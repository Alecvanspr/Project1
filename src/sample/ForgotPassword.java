package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ForgotPassword extends Application {
    Scene ForgotPassword;
    Main main = new Main();
    public int changingUser;

    @Override
    public void start(Stage stage) throws Exception {
        Pane Forgot = new Pane();
        Button btnBack = new Button("Back");
        Label lblUsername = new Label("Username");
        Label lblBirthDate = new Label("Birth date");
        Label lblSecurityQuestion = new Label("Click here to reveal your Security Question");
        Label lblnewPassword = new Label("New password");
        Label lblnewPasswordConfirm = new Label("Enter new password again");
        Label lblError = new Label();
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
        ChangePassword.relocate(100,300);
        lblError.relocate(100,325);

        lblSecurityQuestion.setOnMouseClicked(e->{
                changingUser= getUser(txtUsername.getText());
                setSecurityQuestion(lblSecurityQuestion);
                });

        Forgot.getChildren().addAll(btnBack,lblUsername,txtUsername,lblBirthDate,txtBirth,lblSecurityQuestion,security
        ,txtPassword,txtPasswordConfirm,lblnewPassword,lblnewPasswordConfirm,ChangePassword,lblError);
        btnBack.relocate(0, 570);

        ChangePassword.setOnAction(e->{
            if(security.getText().equals(main.arraykeeper.getPersonaldata().get(changingUser).getSecurityAnswer())) {
                if (txtPassword.getText().equals(txtPasswordConfirm.getText())) {
                    main.arraykeeper.changePassword(changingUser, txtPassword.getText());
                    goBack(stage);
                } else {
                    lblError.setText("Passwords do not match");
                }
            }else{
                lblError.setText("Question Wrong");
            }
        });

        btnBack.setOnAction(e -> { //dit wordt zo een OK knop.
            goBack(stage);
        });
        ForgotPassword = new Scene(Forgot, 800, 600);
        stage.setScene(ForgotPassword);
        stage.show();
    }
    public int getUser(String username){
        int ret = 0;
        for(int i = 0; i<main.arraykeeper.Data.size();i++){
            System.out.println("Poah hey");
            if(main.arraykeeper.getPersonaldata().get(i).getName().equals(username)){
                ret = i;
            }
        }
        return ret;
    }
    public void setSecurityQuestion(Label label){
        label.setText(main.arraykeeper.getPersonaldata().get(changingUser).getSecurtityQuestion());
    }
    public void goBack(Stage stage){
        Main main = new Main();
        try {
            main.start(stage);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
