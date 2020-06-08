package sample.educative.read;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.GoToScreens;
import sample.educative.EducativeHomeScreen;
import sample.educative.GoToEducative;

public class ReadScreen  extends Application {
    Pane pane = new Pane();
    GoToScreens goToScreens = new GoToScreens();
    GoToEducative goToEducative = new GoToEducative();
    Scene scene;

    @Override
    public void start(Stage stage) throws Exception {
        Button btnBack = new Button("back");
        Button btnGrammar = new Button("grammar");
        Button btnHangman = new Button("Hangman");
        Button btnYouCantSeeMe = new Button("you cant see mee");
        btnYouCantSeeMe.relocate(300,350);
        btnYouCantSeeMe.setOnAction(e->{
            goToScreens.goVideo(stage);
        });
        btnHangman.relocate(200,350);
        btnBack.relocate(0,575);
        btnGrammar.relocate(200,200);
        btnHangman.setOnAction(e->{
            goToScreens.goHangmanScreen(stage);
        });
        btnBack.setOnAction(E->{
            goToScreens.goEducativeScreen(stage);
        });
        btnGrammar.setOnAction(e->{
            goToEducative.goGrammar(stage);
        });

        pane.getChildren().addAll(btnBack,btnHangman,btnGrammar,btnYouCantSeeMe);

        scene = new Scene(pane, 800, 600);
        stage.setTitle("Read screen");
        stage.setScene(scene);
        stage.show();
    }
}