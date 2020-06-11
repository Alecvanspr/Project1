package sample.educative.read.hangman;

import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;
import sample.GoToScreens;
import sample.educative.read.WordReader;
import sample.educative.read.hangman.GalgIMG;

import java.util.HashMap;

public class HangmanScreen extends Application {
    private GalgIMG galgIMG = new GalgIMG();
    private Letter letter;
    StackPane pane = new StackPane();
    GoToScreens goToScreens = new GoToScreens();
    Button btnBack = new Button("back");
    Button btnAgain = new Button("New Word");
    Text dash = new Text("-");
    Text textScore = new Text();
    HBox rowBack = new HBox();
    HBox rowAlphabet = new HBox(5);
    HBox rowHangman = new HBox(10,btnAgain,textScore,galgIMG);
    VBox vBox = new VBox(10);
    HBox rowLetters = new HBox();

    Scene scene;

    private static int appW = 800;
    private static int appH = 600;
    public static Font segoeButBigger = new Font("Segoe UI",36);

    private static int scoreCorrectLetter = 100;
    private static double extraScore = 0.125;

    //next correct guess worth
    private double baseScore = 1.0;

    //word that needs to be guessed
    private SimpleStringProperty word = new SimpleStringProperty();

    //checks if game is playable(if you can start a new game/go to a new word)
    private SimpleBooleanProperty playable = new SimpleBooleanProperty();

    //amount of letters left to guess
    private SimpleIntegerProperty lettersToGuess = new SimpleIntegerProperty();

    //the current score
    private SimpleIntegerProperty score = new SimpleIntegerProperty();

    private ObservableList<Node> letters;
    private HashMap<Character, Text> alphabet = new HashMap<Character, Text>();
    private WordReader wordReader = new WordReader();



    //creates the layout of the screen
    public Parent makeGUI(Stage stage){
        makeBtnBack(stage);
        makeRowLetters(stage);

        playable.bind(galgIMG.tries.greaterThan(0).and(lettersToGuess.greaterThan(0)));
        playable.addListener((obs, old, newValue) -> {
            if(!newValue)
                stopGame();
        });

        makeBtnAgain(stage);
        makeRowAlphabet(stage);

        textScore.textProperty().bind(score.asString().concat(" Score"));

        rowHangman.setAlignment(Pos.CENTER);

        vBox.getChildren().addAll(rowLetters,rowAlphabet,rowHangman,rowBack);
        return vBox;
    }

    public void stopGame(){
        for(Node n : letters){
            Letter letter = (Letter) n;
            letter.show();
        }
    }

    public void startGame(){
        for(Text t : alphabet.values()){
            t.setStrikethrough(false);
            t.setFill(Color.BLACK);
        }

        galgIMG.reset();
        word.set(wordReader.getRandomWord().toUpperCase());
        lettersToGuess.set(word.length().get());

        letters.clear();
        for(char c : word.get().toCharArray()){
            letters.add(new Letter(c));
        }
    }


    @Override
    public void start(Stage stage) throws Exception {
        scene = new Scene(makeGUI(stage));

        scene.setOnKeyPressed((KeyEvent event) -> {
            if(event.getText().isEmpty()) {
                return;
            }
            char pressed = event.getText().toUpperCase().charAt(0);
            if((pressed<'A' || pressed>'Z') && pressed != '-'){
                return;
            }
            if(playable.get()){
                guess(pressed);
            }
        });

        fin(stage,scene);

    }

    public void makeBtnAgain(Stage stage){
        btnAgain.disableProperty().bind(playable);
        btnAgain.setOnAction(e -> startGame());
    }

    public void makeRowAlphabet(Stage stage){
        rowAlphabet.setAlignment(Pos.CENTER);
        for(char c = 'A'; c<= 'Z'; c++){
            Text t = new Text(String.valueOf(c));
            t.setFont(segoeButBigger);
            alphabet.put(c,t);
            rowAlphabet.getChildren().add(t);
        }


        dash.setFont(segoeButBigger);
        alphabet.put('-', dash);
        rowAlphabet.getChildren().add(dash);
    }

    public void makeRowLetters(Stage stage){
        rowLetters.setAlignment(Pos.CENTER);
        letters = rowLetters.getChildren();
    }

    public void makeBtnBack(Stage stage){
        btnBack.setAlignment(Pos.BOTTOM_LEFT);
        rowBack.getChildren().add(btnBack);
        btnBack.setOnAction(E->{
            goToScreens.goEducativeScreen(stage);
        });
    }

    public void guess(char pressed){
        Text t = alphabet.get(pressed);
        if(t.isStrikethrough()){
            return;
        }
        t.setFill(Color.BLUE);
        t.setStrikethrough(true);

        boolean found = false;

        for(Node n : letters){
            Letter letter = (Letter) n;
            if(letter.isEqualTo(pressed)){
                found = true;
                score.set(score.get() + (int)(baseScore*scoreCorrectLetter));
                lettersToGuess.set(lettersToGuess.get()-1);
                letter.show();
            }
        }

        if(!found){
            galgIMG.takeAwayTry();
            baseScore = 1.0;
        }
        else{
            baseScore += extraScore;
        }
    }

    public void fin(Stage stage, Scene scene){
        stage.setTitle("Hangman screen");
        stage.setWidth(appW);
        stage.setHeight(appH);
        stage.setScene(scene);
        stage.show();
    }

}
