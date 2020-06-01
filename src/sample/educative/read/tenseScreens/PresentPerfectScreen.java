package sample.educative.read.tenseScreens;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.educative.read.GrammarScreen;
import sample.educative.read.ReadScreen;

public class PresentPerfectScreen extends Application {
    Pane pane = new Pane();
    @Override
    public void start(Stage stage) throws Exception {
        Button btnBack = new Button();
        btnBack.relocate(0,575);
        btnBack.setOnAction(E->{
            goBack(stage);
        });

        pane.getChildren().addAll(btnBack);
        Scene scene = new Scene(pane, 800, 600);
        stage.setTitle("Grammar screen");
        stage.setScene(scene);
        stage.show();
    }
    public void goBack(Stage stage){
        GrammarScreen grammarScreen = new GrammarScreen();
        try {
            grammarScreen.start(stage);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}