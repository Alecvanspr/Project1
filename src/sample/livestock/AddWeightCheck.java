package sample.livestock;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.ArrayKeeper;

public class AddWeightCheck extends Application {
    ArrayKeeper arrayKeeper = new ArrayKeeper();
    Scene healthScene;
    Pane healthPane = new Pane();

    @Override
    public void start(Stage stage) throws Exception {
        Button btnBack = new Button("Back");
        btnBack.relocate(0,565);

        btnBack.setOnAction(E->{
            goBack(stage);
        });

        healthScene = new Scene(healthPane,800,600);
        stage.setTitle("Add health check");
        stage.setScene(healthScene);
        stage.show();
    }
    public void goBack(Stage stage){
        Livestock livestock = new Livestock();
        try {
            livestock.start(stage);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}