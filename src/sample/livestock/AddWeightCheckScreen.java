package sample.livestock;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.ArrayKeeper;
import sample.ButtonSettings;
import sample.GoToScreens;

public class AddWeightCheckScreen extends Application {
    ButtonSettings buttonSettings = new ButtonSettings();
    ArrayKeeper arrayKeeper = new ArrayKeeper();
    GoToScreens goToScreens = new GoToScreens();
    Scene healthScene;
    Pane healthPane = new Pane();
    int currentAnimal;

    public AddWeightCheckScreen(int currentAnimal){
        this.currentAnimal = currentAnimal;
    }

    @Override
    public void start(Stage stage) throws Exception {
        Button btnBack = new Button("Back");
        Button btnAply = new Button("Apply");
        Label lblWeight = new Label("Here you enter the weight of your animal");
        TextField txtnewWeight = new TextField();

        btnAply.relocate(300,100);
        lblWeight.relocate(100,55);
        txtnewWeight.relocate(100,100);
        btnBack.relocate(0,565);

        btnAply.setOnAction(E->{
            addWeightSituation(txtnewWeight.getText());
            goToScreens.displayWeight(stage,currentAnimal);
        });

        btnBack.setOnAction(E->{
            goToScreens.displayWeight(stage,currentAnimal);
        });

        buttonSettings.onMouse(btnAply);
        buttonSettings.onMouse(btnBack);
        healthPane.getChildren().addAll(txtnewWeight,btnAply,lblWeight,btnBack);
        healthScene = new Scene(healthPane,800,600);
        stage.setTitle("Add health check");
        stage.setScene(healthScene);
        stage.show();
    }

    public void addWeightSituation(String situation){
        arrayKeeper.getData().get(ArrayKeeper.getCurrentUser()).getAnimals().get(currentAnimal).addWeight(situation);
        arrayKeeper.getData().get(ArrayKeeper.getCurrentUser()).getAnimals().get(currentAnimal).setDateWeight(""+java.time.LocalDate.now());
    }
}