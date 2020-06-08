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

public class AddHeathCheckScreen extends Application {
    ButtonSettings buttonSettings = new ButtonSettings();
    ArrayKeeper arrayKeeper = new ArrayKeeper();
    GoToScreens goToScreens = new GoToScreens();
    Scene healthScene;
    Pane healthPane = new Pane();
    private int currentAnimal;
    TextField txtHealthSituation = new TextField();

    public AddHeathCheckScreen(int currentAnimal){
        this.currentAnimal = currentAnimal;
    }

    @Override
    public void start(Stage stage) throws Exception {
        txtHealthSituation.relocate(100,100);
        makeLabel();
        makeButtons(stage);
        healthPane.getChildren().addAll(txtHealthSituation);
    }
    public void fin(Stage stage){
        healthScene = new Scene(healthPane,800,600);
        stage.setTitle("Add health check");
        stage.setScene(healthScene);
        stage.show();
    }
    public void makeLabel(){
        Label lblExplainTxt = new Label("Here you can register health issues like broken bones,ill,starving or Healthy");
        lblExplainTxt.relocate(100,65);
        healthPane.getChildren().addAll(lblExplainTxt);
    }
    public void makeButtons(Stage stage){
        makeBtnBack(stage);
        makeBtnApply(stage);
    }
    public void makeBtnApply(Stage stage){
        Button btnApply = new Button("Add");
        btnApply.setOnAction(E->{
            addHealthSituation(txtHealthSituation.getText());
            goToScreens.goHealthCheck(stage,currentAnimal);
        });
        btnApply.relocate(300,100);
        buttonSettings.onMouse(btnApply);
        healthPane.getChildren().add(btnApply);
    }
    public void makeBtnBack(Stage stage){
        Button btnBack = new Button("Back");
        btnBack.relocate(0,565);
        btnBack.setOnAction(E->{
            goToScreens.goHealthCheck(stage,currentAnimal);
        });
        buttonSettings.onMouse(btnBack);
        healthPane.getChildren().add(btnBack);
    }

    public void addHealthSituation(String Situation){
        arrayKeeper.getPersonaldata().get(ArrayKeeper.getCurrentUser()).getAnimals().get(currentAnimal).addHealth(Situation);
        arrayKeeper.getPersonaldata().get(ArrayKeeper.getCurrentUser()).getAnimals().get(currentAnimal).setDateHealth(""+java.time.LocalDate.now());
    }
}
