package sample.educative.read;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.ButtonSettings;
import sample.GoToScreens;

import java.io.File;
import java.util.Random;

public class WordReadScreen extends Application {

    Pane pane = new Pane();
    Scene scene = new Scene(pane,800,600);
    public static Font SANSButBigger = new Font("Comic Sans MS",42);
    GoToScreens goToScreens = GoToScreens.getInstance();
    ButtonSettings buttonSettings = ButtonSettings.getInstance();
    Random random = new Random();
    Label text = new Label();
    Image image = new Image("images/buttons/speaker.png");
    ImageView iv = new ImageView(image);
    Button btnRandom = new Button("New word");

    @Override
    public void start(Stage stage) throws Exception {
        makeBtnRandom(stage);
        fin(stage);
    }


    public void makeBtnRandom(Stage stage){
        btnRandom.setOnAction(e->{
            WordReader wr = new WordReader();
            int rng = random.nextInt(wr.getCombos().size()-1);
            makeWord(stage, wr, rng);
            makeImage(wr, rng);
        });

        btnRandom.relocate(75,575);

        pane.getChildren().add(btnRandom);
    }


    public void makeWord(Stage stage, WordReader wr, int rng){
        text.setText(wr.getCombos().get(rng).getWord());
        text.setFont(SANSButBigger);
        text.relocate(scene.getWidth()/2-100, scene.getHeight()/2-50);
        pane.getChildren().add(text);
    }


    AudioClip ac;

    public void makeImage(WordReader wr, int rng){
        File audio = wr.getCombos().get(rng).getAudio();
        ac  = new AudioClip(audio.toURI().toString());
        iv.setPreserveRatio(true);
        iv.setFitWidth(200);
        iv.relocate(scene.getWidth()/2-100,scene.getHeight()/10);
        iv.setOnMouseClicked(e-> {
            ac.play();
        });
        pane.getChildren().add(iv);
    }

    public void makeLabels(){

    }

    public void fin (Stage stage){
        stage.setTitle("Word pronouncing and reading");
        stage.setScene(scene);
        stage.show();
    }
}
