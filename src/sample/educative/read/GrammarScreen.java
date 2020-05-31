package sample.educative.read;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.educative.EducativeHomeScreen;

public class GrammarScreen  extends Application {
    Pane pane = new Pane();
    Scene scene;

    @Override
    public void start(Stage stage) throws Exception {
        Button btnBack = new Button("back");
        btnBack.relocate(0,575);
        btnBack.setOnAction(E->{
            goEducativeScreen(stage);
        });

        pane.getChildren().addAll(btnBack);

        scene = new Scene(pane, 800, 600);
        stage.setTitle("Grammar screen");
        stage.setScene(scene);
        stage.show();
    }
    public void goEducativeScreen(Stage stage){
        ReadScreen readScreen = new ReadScreen();
        try {
            readScreen.start(stage);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}