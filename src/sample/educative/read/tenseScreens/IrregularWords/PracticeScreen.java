package sample.educative.read.tenseScreens.IrregularWords;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import sample.educative.GoToEducative;
import sample.educative.read.GrammarScreen;

import java.util.ArrayList;
import java.util.Random;

public class PracticeScreen extends Application {
    GoToEducative goToEducative = new GoToEducative();
    InfinitiveWordReader infinitiveWordReader = new InfinitiveWordReader();
    PastParticipleReader pastParticipleReader = new PastParticipleReader();
    PastWordReader pastWordReader = new PastWordReader();

    Pane pane = new Pane();
    Label lblWrong = new Label("");
    Label lblSentence = new Label("Welcome to the Practice Screen");
    Button btnInfinitive = new Button("Infinitive");
    Button btnPastTense = new Button("Past");
    Button btnPastParticle = new Button("Past Particle");
    int currendWord =0;
    int answer = 0;

    @Override
    public void start(Stage stage) throws Exception {
        Label lblInfinitive = new Label("Infinitive");
        Label lblPastTense = new Label("Past");
        Label lblPastParticle = new Label("Past Particle");
        Label lblExplain = new Label("What is the correct word?");
        Button btnBack = new Button("Back");
        Button btnNext = new Button("Next");
        lblSentence.setFont(new Font("Comic Sans MS",25));

        btnInfinitive.setOnAction(E->{
            checkButtonClick(btnInfinitive);
        });
        btnPastTense.setOnAction(E->{
            checkButtonClick(btnPastTense);
        });
        btnPastParticle.setOnAction(E->{
            checkButtonClick(btnPastParticle);
        });
        btnBack.setOnAction(E->{
            goToEducative.goIrregularVerbScreen(stage);
        });

        btnNext.setOnAction(E->{
            newSentence();
            clearAllbuttons();
        });

        btnNext.relocate(675,565);
        btnBack.relocate(0, 565);
        lblSentence.relocate(150,200);
        lblInfinitive.relocate(100,375);
        btnInfinitive.relocate(100,400);
        lblPastTense.relocate(300,375);
        btnPastTense.relocate(300,400);
        lblPastParticle.relocate(500,375);
        btnPastParticle.relocate(500,400);
        lblExplain.relocate(200,300);

        pane.getChildren().addAll(btnBack,btnInfinitive,btnPastTense,btnPastParticle,btnNext,lblSentence,lblPastTense,lblInfinitive,lblPastParticle,lblExplain,lblWrong);
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(pane);
        Scene scene = new Scene(scrollPane, 800, 600);
        stage.setTitle("Practice words");
        stage.setScene(scene);
        stage.show();
    }

public void newSentence(){
    lblWrong.setText("");
    Random random = new Random();
    currendWord = random.nextInt(infinitiveWordReader.getWords().size()-1);
    setSentenceLabel(currendWord,random.nextInt(2));
    btnInfinitive.setText(infinitiveWordReader.getWords().get(currendWord));
    btnPastTense.setText(pastWordReader.getWords().get(currendWord));
    btnPastParticle.setText(pastParticipleReader.getWords().get(currendWord));
}
public void setSentenceLabel(int word,int wordType){
        String sentence;
        answer = wordType;
    if(wordType==0){
        sentence = infinitiveWordReader.getSentences().get(word);
    }else if(wordType==1){
        sentence= pastWordReader.getSentences().get(word);
    }else{
        sentence = pastParticipleReader.getSentences().get(word);
    }
    lblSentence.setText(sentence);
}

public void checkButtonClick(Button clicked){
        if(answer==0){
            setButtonColor(clicked,infinitiveWordReader.getWords().get(currendWord));
        }else if(answer == 1){
            setButtonColor(clicked,pastWordReader.getWords().get(currendWord));
        }else{
            setButtonColor(clicked,pastParticipleReader.getWords().get(currendWord));
        }
}
public void setButtonColor(Button clicked, String correctAnswer){
    if(correctAnswer.equals(clicked.getText())){
        clicked.setStyle("-fx-background-color: #00ff00; ");
    }else{
        lblWrong.setText("Wrong, Try Again");
        clicked.setStyle("-fx-background-color: #ff0000; ");
    }
}
public void clearAllbuttons(){ //ik weet niet wat de orginele dingen zijn...... help
        btnInfinitive.setStyle("-fx-background-color: #00FFE5; ");
        btnPastTense.setStyle("-fx-background-color: #FF2CC1; ");
        btnPastParticle.setStyle("-fx-background-color: #FFFA00; ");
}
}