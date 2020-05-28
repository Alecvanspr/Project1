package sample.educative;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.Random;

public class WriteWordsScreen extends Application {

    Pane pane = new Pane();
    Scene scene = new Scene(pane, 800, 600);
    WriteWordsCards writeWordsCards = new WriteWordsCards();
    GetImage getImage = new GetImage();
    ImageView iv;
    Image image;

    @Override
    public void start(Stage stage) throws Exception {

        makeBackGround();
        Button btnBack = new Button("back");
        Button btnNewPic = new Button("new thing");
        btnBack.relocate(0, 575);
        btnBack.setOnAction(E -> {
            goBack(stage);
        });
        btnNewPic.setOnAction(e->{
            makeBackGround();
        });


        pane.getChildren().addAll(btnBack, btnNewPic);

        stage.setTitle("Write words screen");
        stage.setScene(scene);
        stage.show();
    }

    public void goBack(Stage stage) {
        WriteMainScreen writeMainScreen = new WriteMainScreen();
        try {
            writeMainScreen.start(stage);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void makeBackGround() {
        pane.getChildren().remove(iv);
        Random random = new Random();
        int rng = random.nextInt(writeWordsCards.imageFlashcards.size() - 1);
        image = writeWordsCards.imageFlashcards.get(rng).getImage();
        iv = new ImageView();
        iv.setImage(image);
        iv.setPreserveRatio(true);
        iv.setFitHeight(300);
        iv.relocate(350,250);
        pane.getChildren().add(iv);
    }
}
