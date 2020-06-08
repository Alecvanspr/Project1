package sample.educative.read;

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
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;
import sample.GoToScreens;

import java.util.HashMap;

public class HangmanScreen extends Application {
    StackPane pane = new StackPane();
    GoToScreens goToScreens = new GoToScreens();
    Button btnBack = new Button("back");

    private static int appW = 800;
    private static int appH = 600;
    private static Font segoeButBigger = new Font("Segoe UI",36);

    private static int scoreCorrectLetter = 100;
    private static float extraScore = 0.125f;

    //next correct guess worth
    private float baseScore = 1.0f;

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
    private HangmanImage hangman = new HangmanImage();
    private WordReader wordReader = new WordReader();

    //creates the layout of the screen
    public Parent createContent(){

        btnBack = new Button("back");

        HBox rowBack = new HBox();
        btnBack.setAlignment(Pos.BOTTOM_LEFT);
        rowBack.getChildren().add(btnBack);

        HBox rowLetters = new HBox();
        rowLetters.setAlignment(Pos.CENTER);
        letters = rowLetters.getChildren();

        playable.bind(hangman.tries.greaterThan(0).and(lettersToGuess.greaterThan(0)));
        playable.addListener((obs, old, newValue) -> {
            if(!newValue)
                stopGame();
        });

        Button btnAgain = new Button("New Word");
        btnAgain.disableProperty().bind(playable);
        btnAgain.setOnAction(e -> startGame());



        HBox rowAlphabet = new HBox(5);
        rowAlphabet.setAlignment(Pos.CENTER);
        for(char c = 'A'; c<= 'Z'; c++){
            Text t = new Text(String.valueOf(c));
            t.setFont(segoeButBigger);
            alphabet.put(c,t);
            rowAlphabet.getChildren().add(t);
        }

        Text dash = new Text("-");
        dash.setFont(segoeButBigger);
        alphabet.put('-', dash);
        rowAlphabet.getChildren().add(dash);

        Text textScore = new Text();
        textScore.textProperty().bind(score.asString().concat(" Score"));

        HBox rowHangman = new HBox(10,btnAgain,textScore,hangman);
        rowHangman.setAlignment(Pos.CENTER);

        VBox vBox = new VBox(10);
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

        hangman.reset();
        word.set(wordReader.getRandomWord().toUpperCase());
        lettersToGuess.set(word.length().get());

        letters.clear();
        for(char c : word.get().toCharArray()){
            letters.add(new Letter(c));
        }
    }

    //the way hangman image is drawn using javafx and responsible for tries per word
    private static class HangmanImage extends Parent{
        private static final int spineStartX = 100;
        private static final int spineStartY = 20;
        private static final int spineEndX = spineStartX;
        private static final int spineEndY = spineStartY+50;

        private SimpleIntegerProperty tries = new SimpleIntegerProperty();
        public HangmanImage(){
            Circle head = new Circle(20);
            head.setTranslateX(spineStartX);

            Line spine = new Line();
            spine.setStartX(spineStartX);
            spine.setStartY(spineStartY);
            spine.setEndX(spineEndX);
            spine.setEndY(spineEndY);

            Line leftArm = new Line();
            leftArm.setStartX(spineStartX);
            leftArm.setStartY(spineStartY);
            leftArm.setEndX(spineEndX+40);
            leftArm.setEndY(spineEndY+10);

            Line rightArm = new Line();
            rightArm.setStartX(spineStartX);
            rightArm.setStartY(spineStartY);
            rightArm.setEndX(spineEndX-40);
            rightArm.setEndY(spineEndY+10);

            Line leftLeg = new Line();
            leftLeg.setStartX(spineEndX);
            leftLeg.setStartY(spineEndY);
            leftLeg.setEndX(spineEndX+25);
            leftLeg.setEndY(spineEndY+50);

            Line rightLeg = new Line();
            rightLeg.setStartX(spineEndX);
            rightLeg.setStartY(spineEndY);
            rightLeg.setEndX(spineEndX-25);
            rightLeg.setEndY(spineEndY+50);

            getChildren().addAll(head,spine,leftArm,rightArm,leftLeg,rightLeg);
            tries.set(getChildren().size());
        }
        public void reset(){
            getChildren().forEach(node -> node.setVisible(false));
            tries.set(getChildren().size());
        }
        public void takeAwayLife(){
            for(Node n : getChildren()){
                if(!n.isVisible()){
                    n.setVisible(true);
                    tries.set(tries.get()-1);
                    break;
                }
            }
        }
    }

    //makes the letter and the box
    private static class Letter extends StackPane{
        private Rectangle bg = new Rectangle(40,60);
        private Text text;

        public Letter(char letter){
            bg.setFill(Color.WHITE);
            bg.setStroke(Color.BLUE);

            text = new Text(String.valueOf(letter).toUpperCase());
            text.setFont(segoeButBigger);
            text.setVisible(false);

            setAlignment(Pos.CENTER);
            getChildren().addAll(bg,text);
        }
        public void show(){
            RotateTransition rt = new RotateTransition(Duration.seconds(1), bg);
            rt.setAxis(Rotate.Y_AXIS);
            rt.setToAngle(180);
            rt.setOnFinished(event -> text.setVisible(true));
            rt.play();
        }
        public boolean isEqualTo(char other){
            return text.getText().equals(String.valueOf(other).toUpperCase());
        }
    }


    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(createContent());

        btnBack.setOnAction(E->{
            goToScreens.goEducativeScreen(stage);
        });

        scene.setOnKeyPressed((KeyEvent event) -> {
            if(event.getText().isEmpty()) {
                return;
            }
            char pressed = event.getText().toUpperCase().charAt(0);
            if((pressed<'A' || pressed>'Z') && pressed != '-'){
                return;
            }
            if(playable.get()){
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
                    hangman.takeAwayLife();
                    baseScore = 1.0f;
                }
                else{
                    baseScore += extraScore;
                }
            }
        });


        stage.setTitle("Hangman screen");
        stage.setWidth(appW);
        stage.setHeight(appH);
        stage.setScene(scene);
        stage.show();
    }
}
