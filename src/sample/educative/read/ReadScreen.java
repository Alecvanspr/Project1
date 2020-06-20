package sample.educative.read;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import sample.GoToScreens;
import sample.educative.EducativeHomeScreen;
import sample.educative.GoToEducative;

public class ReadScreen  extends Application {
    Pane pane = new Pane();
    Label titel = new Label("Train your Reading");
    GoToScreens goToScreens = GoToScreens.getInstance();
    GoToEducative goToEducative = new GoToEducative();
    Scene scene;

    @Override
    public void start(Stage stage) throws Exception {
        titel.relocate(265,250);
        titel.setFont(Font.font("Arial",30));
        makeButtons(stage);
        fin(stage);
        pane.getChildren().add(titel);
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
        btnStories.relocate(450,320);
        btnStories.setPrefSize(100,100);
        btnStories.setOnAction(e->{
            goToScreens.goStoryScreen(stage);
        });
        pane.getChildren().add(btnStories);
    }

    public void makeBtnWords(Stage stage){
        Button btnWords = new Button("words :)");
        btnWords.relocate(340,320);
        btnWords.setPrefSize(100,100);
        btnWords.setOnAction(e->{
            goToScreens.goWordReading(stage);
        });
        pane.getChildren().add(btnWords);
    }

    public void makeBtnGrammar(Stage stage){
        Button btnGrammar = new Button("grammar");
        btnGrammar.setOnAction(e->{
            goToEducative.goGrammar(stage);
        });
        btnGrammar.relocate(225,320);
        btnGrammar.setPrefSize(100,100);
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