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
        Label lblExplain = new Label(tenseKeeper.tensesExplained.get(currentTense));
        Button btnBack = new Button("back");

        btnBack.relocate(0,575);
        lblExplain.relocate(100,100);

        btnBack.setOnAction(E->{
            goToEducative.goGrammar(stage);
        });

        pane.getChildren().addAll(btnBack,lblExplain,tenseKeeper.buttons.get(currentTense));
        Scene scene = new Scene(pane, 800, 600);
        stage.setTitle(tenseKeeper.tenseName.get(currentTense));
        stage.setScene(scene);
        stage.show();
    }
}
