package sample.livestock;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class DisplayWeight extends Application {
    Scene weightScene;
    ScrollPane weightScroll = new ScrollPane();
    Pane weightPane = new Pane();
    int currentAnimal;
    int currentUser;

    @Override
    public void start(Stage stage) throws Exception{
        Button btnBack = new Button("Back");
        btnBack.relocate(0,575);



        btnBack.setOnAction(E->{
            goBack(stage);
        });

        weightPane.getChildren().addAll(btnBack);
        weightScroll.setContent(weightPane);
        weightScene = new Scene(weightScroll,800,600);
        stage.setTitle("Livestock");
        stage.setScene(weightScene);
        stage.show();
    }
    public DisplayWeight(int currentAnimal,int CurrentUser){
        this.currentAnimal = currentAnimal;
        this.currentUser = CurrentUser;
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