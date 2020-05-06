package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ForgotPassword extends Application {
    Scene ForgotPassword;
    Homescreen homescreen = new Homescreen();

    @Override
    public void start(Stage stage) throws Exception {
        Button btnBack = new Button("Back");
        Pane Forgot = new Pane();
        Forgot.getChildren().add(btnBack);
        btnBack.relocate(0, 570);
        btnBack.setOnAction(e -> {
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
}
