package sample.educative;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.ButtonSettings;
import sample.GoToScreens;

public class MathScreen  extends Application {
    Pane pane = new Pane();
    GoToScreens goToScreens = GoToScreens.getInstance();
    ButtonSettings buttonSettings = ButtonSettings.getInstance();
    Scene scene;

    @Override
    public void start(Stage stage) throws Exception {
        btnBack(stage);

        fin(stage);
    }
    public void btnBack(Stage stage){
        Button btnBack = new Button("back");
        buttonSettings.onMouse(btnBack);
        btnBack.relocate(0,575);
        btnBack.setOnAction(E->{
            goToScreens.goEducativeScreen(stage);
        });
        pane.getChildren().addAll(btnBack);
    }
    public void fin(Stage stage){
        scene = new Scene(pane, 800, 600);
        stage.setTitle("Math screen");
        stage.setScene(scene);
        stage.show();
    }
}
