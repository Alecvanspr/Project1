package sample.educative;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Random;

public class WriteScreen  extends Application {
    Pane pane = new Pane();
    Scene scene;
    GetImage getImage = new GetImage();

    @Override
    public void start(Stage stage) throws Exception {
        Random random = new Random();
        int getRandomLetter = random.nextInt(53);
        Image displayLetter = new Image(getImage.getLetterImage(getRandomLetter));
        ImageView imageView = new ImageView();
        imageView.setImage(displayLetter);
        Button btnBack = new Button("back");
        btnBack.relocate(0,575);

        btnBack.setOnAction(E->{
            goEducativeScreen(stage);
        });

        pane.getChildren().addAll(imageView,btnBack);
        scene = new Scene(pane, 800, 600);
        stage.setTitle("Write Screen");
        stage.setScene(scene);
        stage.show();
    }
    public void goEducativeScreen(Stage stage){
        EducativeHomeScreen educativeHomeScreen = new EducativeHomeScreen();
        try {
            educativeHomeScreen.start(stage);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}