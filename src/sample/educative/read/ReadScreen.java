package sample.educative.read;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.educative.EducativeHomeScreen;

public class ReadScreen  extends Application {
    Pane pane = new Pane();
    Scene scene;

    @Override
    public void start(Stage stage) throws Exception {
        Button btnBack = new Button("back");
        Button btnGrammar = new Button("grammar");
        Button btnHangman = new Button("Hangman");
        Button btnYouCantSeeMe = new Button("you cant see mee");
        btnYouCantSeeMe.relocate(300,350);
        btnYouCantSeeMe.setOnAction(e->{
            goVideo(stage);
        });
        btnHangman.relocate(200,350);
        btnBack.relocate(0,575);
        btnGrammar.relocate(200,200);
        btnHangman.setOnAction(e->{
            goHangmanScreen(stage);
        });
        btnBack.setOnAction(E->{
            goEducativeScreen(stage);
        });
        btnGrammar.setOnAction(e->{
            goGrammer(stage);
        });

        pane.getChildren().addAll(btnBack,btnHangman,btnGrammar,btnYouCantSeeMe);

        scene = new Scene(pane, 800, 600);
        stage.setTitle("Read screen");
        stage.setScene(scene);
        stage.show();
    }
    public void goEducativeScreen(Stage stage){
        EducativeHomeScreen educativeHomeScreen = new EducativeHomeScreen();
        try {
            educativeHomeScreen.start(stage);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void goHangmanScreen(Stage stage){
        HangmanScreen hangmanScreen = new HangmanScreen();
        try {
            hangmanScreen.start(stage);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void goVideo(Stage stage) {
        VideoTest videoTest = new VideoTest();
        try {
            videoTest.start(stage);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void goGrammer(Stage stage){
        GrammarScreen grammarScreen = new GrammarScreen();
        try {
            grammarScreen.start(stage);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}