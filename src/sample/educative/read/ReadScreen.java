package sample.educative.read;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.educative.EducativeHomeScreen;

public class ReadScreen  extends Application {
    Pane pane = new Pane();
    Scene scene;

    @Override
    public void start(Stage stage) throws Exception {
        Button btnBack = new Button("back");
        Button btnGrammar = new Button("grammer");
        btnBack.relocate(0,575);
        btnGrammar.relocate(200,200);
        btnBack.setOnAction(E->{
            goEducativeScreen(stage);
        });
        btnGrammar.setOnAction(e->{

        });

        pane.getChildren().addAll(btnBack);

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
    public void goGrammer(Stage stage){
        GrammarScreen grammarScreen = new GrammarScreen();
        try {
            grammarScreen.start(stage);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}