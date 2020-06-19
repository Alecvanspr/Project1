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
    Button btnBack = new Button("back");
    Random random = new Random();
    Label text = new Label();
    Image image = new Image("images/buttons/speaker.png");
    ImageView iv = new ImageView(image);
    Button btnRandom = new Button("New word");
    WordReader wr;

    @Override
    public void start(Stage stage) throws Exception {
        makeBtnRandom(stage);
        makeBtnBack(stage);
        pane.getChildren().addAll(text, btnBack);

        fin(stage);
    }

    public void makeBtnBack(Stage stage){
        btnBack.relocate(0,575);
        buttonSettings.onMouse(btnBack);
        btnBack.setOnAction(e->{
            goToScreens.goReadScreen(stage);
        });
    }


    public void makeBtnRandom(Stage stage){
        btnRandom.setOnAction(e->{
            wr = new WordReader();
            int rng = random.nextInt(wr.getCombos().size()-1);
            makeWord(wr, rng);
            makeImage();
        });

        btnRandom.relocate(75,575);

        pane.getChildren().add(btnRandom);
    }


    public void makeWord(WordReader wr, int rng){
        text.setText(wr.getCombos().get(rng).getWord());
        text.setFont(SANSButBigger);
        text.relocate(scene.getWidth()/2-100, scene.getHeight()/2-50);
        //pane.getChildren().add(text);
        playSound(wr, rng);
    }

    AudioClip ac;

    public void playSound(WordReader wr, int rng){
        File audio = wr.getCombos().get(rng).getAudio();
        ac  = new AudioClip(audio.toURI().toString());
        iv.setOnMouseClicked(e-> {
            ac.play();
        });

    }

    public void makeImage(){
        iv.setPreserveRatio(true);
        iv.setFitWidth(200);
        iv.relocate(scene.getWidth()/2-100,scene.getHeight()/10);

        pane.getChildren().add(iv);
    }

    public void fin (Stage stage){
        stage.setTitle("Word pronouncing and reading");
        stage.setScene(scene);
        stage.show();
    }
}
