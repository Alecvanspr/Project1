package sample.educative.read.tenseScreens.IrregularWords;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Random;

public class PracticeScreen extends Application {
    InfinitiveWordReader infinitiveWordReader = new InfinitiveWordReader();
    PastParticipleReader pastParticipleReader = new PastParticipleReader();
    PastWordReader pastWordReader = new PastWordReader();

    Pane pane = new Pane();
    Label lblSentence = new Label("Welcome to the Practice Screen");
    Button btnInfinitive = new Button("Infinitive");
    Button btnPastTense = new Button("Past");
    Button btnPastParticle = new Button("Past Particle");

    @Override
    public void start(Stage stage) throws Exception {
        Label lblInfinitive = new Label("Infinitive");
        Label lblPastTense = new Label("Past");
        Label lblPastParticle = new Label("Past Particle");
        Button btnBack = new Button("Back");
        Button btnNext = new Button("Next");
        btnBack.setOnAction(E->{
            goBack(stage);
        });
        btnNext.setOnAction(E->{
            newSentence();
        });

        btnNext.relocate(675,565);
        btnBack.relocate(0, 565);
        lblSentence.relocate(200,200);
        lblInfinitive.relocate(100,375);
        btnInfinitive.relocate(100,400);
        lblPastTense.relocate(300,375);
        btnPastTense.relocate(300,400);
        lblPastParticle.relocate(500,375);
        btnPastParticle.relocate(500,400);

        /*
        De dingen werken nog niet, omdat het nog niet goed in het document staat.
         */

        pane.getChildren().addAll(btnBack,btnInfinitive,btnPastTense,btnPastParticle,btnNext,lblSentence,lblPastTense,lblInfinitive,lblPastParticle);
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(pane);
        Scene scene = new Scene(scrollPane, 800, 600);
        stage.setTitle("Practice words");
        stage.setScene(scene);
        stage.show();
    }

public void newSentence(){
    Random random = new Random();
    int wordNR = random.nextInt(infinitiveWordReader.getWords().size()-1);
    btnInfinitive.setText(infinitiveWordReader.getWords().get(wordNR));
    btnPastTense.setText(pastWordReader.getWords().get(wordNR));
    btnPastParticle.setText(pastParticipleReader.getWords().get(wordNR));
}
public void goBack(Stage stage){

}
}