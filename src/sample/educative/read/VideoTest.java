package sample.educative.read;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import sample.educative.EducativeHomeScreen;

import java.io.File;

public class VideoTest extends Application {
    Pane pane = new Pane();
    Scene scene = new Scene(pane,800,600);
    MediaPlayer mediaPlayer;

    @Override
    public void start(Stage stage) throws Exception {
        //voeg volgende toe aan run config om te laten werken --add-modules javafx.controls,javafx.media
        Button btnBack = new Button("back");
        btnBack.relocate(0,575);
        btnBack.setOnAction(E->{
            goReadScreen(stage);
            mediaPlayer.dispose();
        });
        String path = System.getProperty("user.dir");
        File f = new File(path,"src/video/JohnCena.mp4");
        Media media = new Media(f.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        MediaView mediaView = new MediaView(mediaPlayer);
        mediaView.setPreserveRatio(true);
        mediaView.setFitHeight(600);
        mediaPlayer.setAutoPlay(true);
        mediaView.relocate(250,0);
        pane.getChildren().addAll(mediaView, btnBack);
        stage.setScene(scene);
        stage.setTitle("JOHN CENA");
        stage.show();
    }

    public void goReadScreen(Stage stage){
        ReadScreen readScreen = new ReadScreen();
        try {
            readScreen.start(stage);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
