package sample.educative;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class EducativeHomeScreen extends Application {
    Pane pane = new Pane();
    Scene scene;
    GetImage getImage = new GetImage();

    @Override
    public void start(Stage stage) throws Exception {
        Image displayLetter = new Image(getImage.getImage(0));
        ImageView imageView = new ImageView();
        imageView.setImage(displayLetter);

        pane.getChildren().add(imageView);

        scene = new Scene(pane, 800, 600);
        stage.setTitle("Show Animals by spieces");
        stage.setScene(scene);
        stage.show();
    }
}
