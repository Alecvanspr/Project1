package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ForgotPassword extends Application {
    Scene ForgotPassword;
    Main main = new Main();
    int changingUser;

    @Override
    public void start(Stage stage) throws Exception {
        Pane Forgot = new Pane();
        Button btnBack = new Button("Back");
        Label lblUsername = new Label("Username");
        Label lblBirthDate = new Label("Birth date");
        Label lblSecurityQuestion = new Label("Click here to get your Security Question");
        TextField txtUsername = new TextField();
        TextField txtBirth = new TextField();
        TextField security = new TextField();

        lblUsername.relocate(100,50);
        txtUsername.relocate(100,75);
        lblBirthDate.relocate(100,100);
        txtBirth.relocate(100,125);
        lblSecurityQuestion.relocate(100,150);



        lblSecurityQuestion.setOnMouseClicked(e->{
                changingUser= getUser(txtUsername.getText());
                lblSecurityQuestion.setText(main.arraykeeper.getPersonaldata().get(changingUser).getSecurtityQuestion());
                });

        Forgot.getChildren().addAll(btnBack,lblUsername,txtUsername,lblBirthDate,txtBirth,lblSecurityQuestion,security);
        btnBack.relocate(0, 570);



        btnBack.setOnAction(e -> { //dit wordt zo een OK knop.
            Main main = new Main();
            try {
                main.start(stage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        ForgotPassword = new Scene(Forgot, 800, 600);
        stage.setScene(ForgotPassword);
        stage.show();
    }
    public int getUser(String username){
        int ret = 0;
        for(int i = 0; i<main.arraykeeper.getPersonaldata().size();i++){
            if(main.arraykeeper.getPersonaldata().get(i).getName().equals(username)){
                changingUser = i;
            }
        }
        return ret;
    }
}
