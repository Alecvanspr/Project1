package sample.educative.writing;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.educative.EducativeHomeScreen;

public class WriteMainScreen extends Application {
    Pane pane = new Pane();
    Scene scene = new Scene(pane,800,600);

    @Override
    public void start(Stage stage) throws Exception {
        Image imgbtnAnimals = new Image("images/buttons/btnGuessAnimals.png");
        Image imgbtnLetters = new Image("images/buttons/btnWriteLetters.png");
        Image imgbtnNumbers = new Image("images/buttons/btnWriteNumbers.png");
        Image imgBtnRandom = new Image("images/buttons/btnWriteRandom.png");
        ImageView btnGuessAnimals = new ImageView(imgbtnAnimals);
        ImageView btnWriteAlphabet = new ImageView(imgbtnLetters);
        ImageView btnWriteRandom = new ImageView(imgBtnRandom);
        ImageView btnWriteNumbers = new ImageView(imgbtnNumbers);

        Button btnBack = new Button("Go back");

        btnWriteRandom.relocate(200,200);
        btnWriteAlphabet.relocate(200,400);
        btnGuessAnimals.relocate(400,200);
        btnWriteNumbers.relocate(400,400);
        btnBack.relocate(0,575);

        btnBack.setOnAction(E->{
            goBack(stage);
        });
        btnWriteAlphabet.setOnMouseClicked(E->{
            goAlphabet(stage);
        });
        btnWriteRandom.setOnMouseClicked(E->{
            goRandom(stage);
        });
        btnWriteNumbers.setOnMouseClicked(E->{
            goNumbers(stage);
        });
        btnGuessAnimals.setOnMouseClicked(E->{
            goWords(stage);
        });



        pane.getChildren().addAll(btnWriteRandom,btnWriteAlphabet,btnGuessAnimals,btnWriteNumbers,btnBack);
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
    public void goWords(Stage stage){
        WriteWordsScreen writeWordsScreen = new WriteWordsScreen();
        try {
            writeWordsScreen.start(stage);
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
