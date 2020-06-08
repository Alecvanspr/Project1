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

    public AddHeathCheckScreen(int currentAnimal){
        this.currentAnimal = currentAnimal;
    }

    @Override
    public void start(Stage stage) throws Exception {
        Button btnBack = new Button("Back");
        Button btnApply = new Button("Add");
        Label lblExplainTxt = new Label("Here you can register health issues like broken bones,ill,starving or Healthy");
        TextField txtHealthSituation = new TextField();
        txtHealthSituation.relocate(100,100);
        lblExplainTxt.relocate(100,65);
        btnApply.relocate(300,100);
        btnBack.relocate(0,565);


        btnApply.setOnAction(E->{
            addHealthSituation(txtHealthSituation.getText());
            goToScreens.goHealthCheck(stage,currentAnimal);
        });

        btnBack.setOnAction(E->{
            goToScreens.goHealthCheck(stage,currentAnimal);
        });

        buttonSettings.onMouse(btnApply);
        buttonSettings.onMouse(btnBack);

        healthPane.getChildren().addAll(btnApply,txtHealthSituation,lblExplainTxt,btnBack);
        healthScene = new Scene(healthPane,800,600);
        stage.setTitle("Add health check");
        stage.setScene(healthScene);
        stage.show();
    }

    public void addHealthSituation(String Situation){
        arrayKeeper.getData().get(ArrayKeeper.getCurrentUser()).getAnimals().get(currentAnimal).addHealth(Situation);
        arrayKeeper.getData().get(ArrayKeeper.getCurrentUser()).getAnimals().get(currentAnimal).setDateHealth(""+java.time.LocalDate.now());
    }
}
