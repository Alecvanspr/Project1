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
        makeButtons(stage);
        fin(stage);
    }
    public void fin(Stage stage){
        scene = new Scene(pane, 800, 600);
        stage.setTitle("Read screen");
        stage.setScene(scene);
        stage.show();
    }
    public void makeButtons(Stage stage){
        makeBtnGrammar(stage);
        makeBtnBack(stage);
        makeBtnStories(stage);
        makeBtnWords(stage);
    }
    public void makeBtnStories(Stage stage){
        Button btnStories = new Button("Stories");
        btnStories.relocate(300,200);
        btnStories.setOnAction(e->{
            //goToScreens.goStoryScreen(stage);
        });
        pane.getChildren().add(btnStories);
    }

    public void makeBtnWords(Stage stage){
        Button btnWords = new Button("words :)");
        btnWords.relocate(200,250);
        btnWords.setOnAction(e->{
            //goToScreens.goWordReading(stage);
        });
        pane.getChildren().add(btnWords);
    }

    public void makeBtnGrammar(Stage stage){
        Button btnGrammar = new Button("grammar");
        btnGrammar.setOnAction(e->{
            goToEducative.goGrammar(stage);
        });
        btnGrammar.relocate(200,200);
        pane.getChildren().add(btnGrammar);
    }
    public void makeBtnBack(Stage stage){
        Button btnBack = new Button("back");
        btnBack.relocate(0,575);
        btnBack.setOnAction(E->{
            goToScreens.goEducativeScreen(stage);
        });
        pane.getChildren().add(btnBack);
    }
}