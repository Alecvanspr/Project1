package sample.educative;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.Random;

public class WriteWordsScreen  extends Application {

    Pane pane = new Pane();
    Scene scene = new Scene(pane, 800, 600);
    Image image;
    ImageView imageView;
    WriteWordsCards writeWordsCards = new WriteWordsCards();
    GetImage getImage = new GetImage();
    Random random = new Random();
    int rng = random.nextInt(writeWordsCards.imageFlashcards.size() - 1);

    @Override
    public void start(Stage stage) throws Exception {

        makeBackGround();
        Button btnBack = new Button("back");
        btnBack.relocate(0, 575);
        btnBack.setOnAction(E -> {
            goBack(stage);
        });

        //image = writeWordsCards.imageFlashcards.get(rng).getImage();
        //imageView = new ImageView(image);
        //imageView.setImage(image);

        pane.getChildren().addAll(imageView, btnBack);

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
        /*BackgroundImage displayPicture = new BackgroundImage
                (writeWordsCards.imageFlashcards.get(rng).getImage(),
        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);*/
        BackgroundImage displayPicture = new BackgroundImage
                (new Image(getImage.animalImages.get(rng)),
                        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                        BackgroundSize.DEFAULT);
        ImageView iv = new ImageView();
        pane.setBackground(new Background(displayPicture));

    }
}
