package sample.educative.writing;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.GoToScreens;
import sample.educative.EducativeHomeScreen;
import sample.educative.GoToEducative;

public class WriteMainScreen extends Application {
    Pane pane = new Pane();
    GoToScreens goToScreens = new GoToScreens();
    GoToEducative goToEducative = new GoToEducative();
    Scene scene = new Scene(pane,800,600);
    Image imgbtnAnimals = new Image("images/buttons/btnGuessAnimals.png");
    ImageView btnGuessAnimals = new ImageView(imgbtnAnimals);
    Image imgbtnLetters = new Image("images/buttons/btnWriteLetters.png");
    ImageView btnWriteAlphabet = new ImageView(imgbtnLetters);
    Image imgbtnNumbers = new Image("images/buttons/btnWriteNumbers.png");
    ImageView btnWriteNumbers = new ImageView(imgbtnNumbers);
    Image imgBtnRandom = new Image("images/buttons/btnWriteRandom.png");
    ImageView btnWriteRandom = new ImageView(imgBtnRandom);
    Button btnBack = new Button("Go back");


    @Override
    public void start(Stage stage) throws Exception {
        makeBtnGuessAnimals(stage);
        makeBtnWriteAlphabet(stage);
        makeBtnWriteRandom(stage);
        makeBtnWriteNumbers(stage);
        makeBtnBack(stage);

        pane.getChildren().addAll(btnWriteRandom,btnWriteAlphabet,btnGuessAnimals,btnWriteNumbers,btnBack);

        fin(stage);
    }

    public void makeBtnGuessAnimals(Stage stage){
        btnGuessAnimals.relocate(400,200);
        btnGuessAnimals.setOnMouseClicked(E->{
            goToScreens.goWords(stage);
        });
    }
    public void makeBtnWriteAlphabet(Stage stage){
        btnWriteAlphabet.relocate(200,400);
        btnWriteAlphabet.setOnMouseClicked(E->{
            goToScreens.goAlphabet(stage);
        });
    }
    public void makeBtnWriteRandom(Stage stage){
        btnWriteRandom.relocate(200,200);
        btnWriteRandom.setOnMouseClicked(E->{
            goToScreens.goRandom(stage);
        });
    }
    public void makeBtnWriteNumbers(Stage stage){
        btnWriteNumbers.relocate(400,400);
        btnWriteNumbers.setOnMouseClicked(E->{
            goToScreens.goNumbers(stage);
        });
    }
    public void makeBtnBack(Stage stage){
        btnBack.relocate(0,575);
        btnBack.setOnAction(E->{
            goToScreens.goEducativeScreen(stage);
        });
    }
    public void fin(Stage stage){
        stage.setTitle("Write Main Screen");
        stage.setScene(scene);
        stage.show();
    }
}