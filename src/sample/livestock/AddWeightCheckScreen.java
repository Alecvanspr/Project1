package sample.livestock;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.ArrayKeeper;
import sample.ButtonSettings;
import sample.GoToScreens;

public class AddWeightCheckScreen extends Application {
    ButtonSettings buttonSettings =ButtonSettings.getInstance();
    ArrayKeeper arrayKeeper = new ArrayKeeper();
    GoToScreens goToScreens = GoToScreens.getInstance();
    Scene healthScene;
    Pane healthPane = new Pane();
    int currentAnimal;
    Label lblWeight = new Label("Here you enter the weight of your animal");
    TextField txtNewWeight = new TextField();

    public AddWeightCheckScreen(int currentAnimal){
        this.currentAnimal = currentAnimal;
    }

    @Override
    public void start(Stage stage) throws Exception {
        makeTextField();
        makeLabels();
        makeBtnBack(stage);
        makeBtnApply(stage);
        fin(stage);
    }
    public void fin(Stage stage){
        healthScene = new Scene(healthPane,800,600);
        stage.setTitle("Add health check");
        stage.setScene(healthScene);
        stage.show();
    }
    public void makeTextField(){
        txtNewWeight.relocate(100,100);
        healthPane.getChildren().addAll(txtNewWeight);
    }
    public void makeLabels(){
        lblWeight.relocate(100,55);
        healthPane.getChildren().addAll(lblWeight);
    }
    public void makeBtnBack(Stage stage){
        Button btnBack = new Button("Back");
        btnBack.relocate(0,565);
        buttonSettings.onMouse(btnBack);
        btnBack.setOnAction(E->{
            goToScreens.displayWeight(stage,currentAnimal);
        });
        healthPane.getChildren().add(btnBack);
    }
    public void makeBtnApply(Stage stage){
        Button btnAply = new Button("Apply");
        btnAply.relocate(300,100);
        btnAply.setOnAction(E->{
            addWeightSituation(txtNewWeight.getText());
            goToScreens.displayWeight(stage,currentAnimal);
        });
        buttonSettings.onMouse(btnAply);
        healthPane.getChildren().add(btnAply);
    }

    public void addWeightSituation(String situation){
        arrayKeeper.getData().get(ArrayKeeper.getCurrentUser()).getAnimals().get(currentAnimal).addWeight(situation);
        arrayKeeper.getData().get(ArrayKeeper.getCurrentUser()).getAnimals().get(currentAnimal).setDateWeight(""+java.time.LocalDate.now());
    }
}