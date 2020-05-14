package sample.livestock;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.Homescreen;

public class DisplayHealth extends Application {
    Scene healthScene;
    ScrollPane healthScroll = new ScrollPane();
    Pane healthPane = new Pane();
    int currentAnimal;
    int currentUser;

    @Override
    public void start(Stage stage) throws Exception{
        Button btnBack = new Button("Back");
        btnBack.relocate(0,575);

        btnBack.setOnAction(E->{
            goBack(stage);
        });


        healthPane.getChildren().addAll(btnBack);
        healthScroll.setContent(healthPane);
        healthScene = new Scene(healthScroll,800,600);
        stage.setTitle("Livestock");
        stage.setScene(healthScene);
        stage.show();
    }
    public DisplayHealth(int currentAnimal,int CurrentUser){
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
