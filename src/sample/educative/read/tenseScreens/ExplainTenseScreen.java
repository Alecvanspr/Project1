package sample.educative.read.tenseScreens;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.educative.GoToEducative;
import sample.educative.read.GrammarScreen;
import sample.educative.read.ReadScreen;

public class ExplainTenseScreen extends Application {
    GoToEducative goToEducative = new GoToEducative();
    TenseKeeper tenseKeeper = new TenseKeeper();
    Pane pane = new Pane();
    int currentTense = 0;
    public ExplainTenseScreen(int currentTense){
        this.currentTense = currentTense;
    }

    @Override
    public void start(Stage stage) throws Exception {
        tenseKeeper.setStage(stage);
        makeLabel();
        pane.getChildren().addAll(tenseKeeper.buttons.get(currentTense));
        makeBtnBack(stage);
        fin(stage);
    }
    public void fin(Stage stage){
        Scene scene = new Scene(pane, 800, 600);
        stage.setTitle(tenseKeeper.tenseName.get(currentTense));
        stage.setScene(scene);
        stage.show();
    }
    public void makeLabel(){
        Label lblExplain = new Label(tenseKeeper.tensesExplained.get(currentTense));
        lblExplain.relocate(100,100);
        pane.getChildren().add(lblExplain);
    }
    public void makeBtnBack(Stage stage){
        Button btnBack = new Button("back");
        btnBack.relocate(0,575);
        btnBack.setOnAction(E->{
            goToEducative.goGrammar(stage);
        });
        pane.getChildren().add(btnBack);
    }
}
