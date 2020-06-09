package sample.educative.read.tenseScreens.IrregularWords;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import sample.ButtonSettings;
import sample.educative.GoToEducative;
import sample.educative.read.GrammarScreen;

import java.util.ArrayList;
import java.util.Random;

public class PracticeScreen extends Application {
    GoToEducative goToEducative = new GoToEducative();
    InfinitiveWordReader infinitiveWordReader = new InfinitiveWordReader();
    PastParticipleReader pastParticipleReader = new PastParticipleReader();
    PastWordReader pastWordReader = new PastWordReader();
    ButtonSettings buttonSettings = new ButtonSettings();

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
        makeLabels();
        makeButtons(stage);
        fin(stage);
    }
    public void makeButtons(Stage stage){
        makeBtnNext();
        makeBtnBack(stage);
        makeWordButtons(stage);
    }
    public void makeBtnBack(Stage stage){
        Button btnBack = new Button("Back");
        btnBack.relocate(0, 565);
        btnBack.setOnAction(E->{
            goToEducative.goIrregularVerbScreen(stage);
        });
        buttonSettings.onMouse(btnBack);
        pane.getChildren().add(btnBack);
    }
    public void makeLabels(){
        Label lblInfinitive = new Label("Infinitive");
        Label lblPastTense = new Label("Past");
        Label lblPastParticle = new Label("Past Particle");
        Label lblExplain = new Label("What is the correct word?");
        lblExplain.relocate(200,300);
        lblPastParticle.relocate(500,375);
        lblPastTense.relocate(300,375);
        lblInfinitive.relocate(100,375);
        pane.getChildren().addAll(lblInfinitive,lblPastTense,lblPastParticle,lblExplain);
    }
    public void makeWordButtons(Stage stage){
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
        lblSentence.relocate(150,200);
        btnInfinitive.relocate(100,400);
        btnPastTense.relocate(300,400);
        btnPastParticle.relocate(500,400);
        pane.getChildren().addAll(btnInfinitive,btnPastTense,btnPastParticle,lblSentence,lblWrong);
    }
    public void makeBtnNext(){
        Button btnNext = new Button("Next");
        btnNext.relocate(675,565);
        btnNext.setOnAction(E->{
            newSentence();
            clearAllbuttons();
        });
        buttonSettings.onMouse(btnNext);
        pane.getChildren().add(btnNext);
    }
    public void fin(Stage stage){
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