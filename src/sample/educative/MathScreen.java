package sample.educative;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.GoToScreens;

public class MathScreen  extends Application {
    Pane pane = new Pane();
    GoToScreens goToScreens = new GoToScreens();
    Scene scene;

    @Override
    public void start(Stage stage) throws Exception {
        Button btnBack = new Button("back");
        btnBack.relocate(0,575);
        btnBack.setOnAction(E->{
            goToScreens.goEducativeScreen(stage);
        });

        pane.getChildren().addAll(btnBack);
        scene = new Scene(pane, 800, 600);
        stage.setTitle("Math screen");
        stage.setScene(scene);
        stage.show();
    }
}
