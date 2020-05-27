package sample.educative;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class WriteMainScreen extends Application {
    Pane pane = new Pane();
    Scene scene = new Scene(pane,800,600);

    @Override
    public void start(Stage stage) throws Exception {
        Button btnWriteRandom = new Button("Random");
        Button btnWriteAlphabet = new Button("Learn Alphabet");
        Button btnWriteWords = new Button("Write words");
        Button btnWriteNumbers = new Button("Write Numbers");
        Button btnBack = new Button("Go back");

        btnWriteRandom.relocate(100,100);
        btnWriteAlphabet.relocate(100,200);
        btnWriteWords.relocate(200,100);
        btnWriteNumbers.relocate(200,200);
        btnBack.relocate(300,200);

        btnBack.setOnAction(E->{
            goBack(stage);
        });
        btnWriteAlphabet.setOnAction(E->{
            goAlphabet(stage);
        });
        btnWriteRandom.setOnAction(E->{
            goRandom(stage);
        });
        btnWriteNumbers.setOnAction(E->{
            goNumbers(stage);
        });
        btnWriteWords.setOnAction(E->{
            goWords(stage);
        });


        pane.getChildren().addAll(btnWriteRandom,btnWriteAlphabet,btnWriteWords,btnWriteNumbers);
        stage.setTitle("Write Main Screen");
        stage.setScene(scene);
        stage.show();
    }
    public void goRandom(Stage stage){
        WriteRandomScreen writeRandomScreen = new WriteRandomScreen();
        try {
            writeRandomScreen.start(stage);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void goNumbers(Stage stage){
        WriteNumbersScreen writeNumbersScren = new WriteNumbersScreen();
        try {
            writeNumbersScren.start(stage);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void goAlphabet(Stage stage){
        WriteAlphabetScreen writeAlphabetScreen = new WriteAlphabetScreen();
        try {
            writeAlphabetScreen.start(stage);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void goWords(Stage stage){ //Deze werkt nog niet
        WriteRandomScreen writeRandomScreen = new WriteRandomScreen();
        try {
            writeRandomScreen.start(stage);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void goBack(Stage stage){
        EducativeHomeScreen educativeHomeScreen = new EducativeHomeScreen();
        try {
            educativeHomeScreen.start(stage);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
