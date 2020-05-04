package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Contacts extends Application {

    Scene contactScene;

    @Override
    public void start(Stage stage) throws Exception{
        Button btnBack = new Button("Back");
        Pane contact = new Pane();
        contact.getChildren().add(btnBack);
        btnBack.relocate(0,570);
        btnBack.setOnAction(e -> {
            Homescreen homescreen = new Homescreen();
            try {
                homescreen.start(stage);
            } catch (Exception ex){
                ex.printStackTrace();
            }
        });
        contactScene = new Scene(contact,800,600);
        stage.setScene(contactScene);
        stage.show();
    }
}