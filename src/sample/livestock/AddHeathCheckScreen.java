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

public class AddHeathCheckScreen extends Application {
    ArrayKeeper arrayKeeper = new ArrayKeeper();
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
            goBack(stage);
        });

        btnBack.setOnAction(E->{
            goBack(stage);
        });

        btnBack.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                btnBack.setScaleX(1.2);
                btnBack.setScaleY(1.2);

            }
        });
        btnBack.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                btnBack.setScaleX(1);
                btnBack.setScaleY(1);

            }
        });

        healthPane.getChildren().addAll(btnApply,txtHealthSituation,lblExplainTxt,btnBack);
        healthScene = new Scene(healthPane,800,600);
        stage.setTitle("Add health check");
        stage.setScene(healthScene);
        stage.show();
    }
    public void goBack(Stage stage){
        DisplayHealthScreen displayHealthScreen = new DisplayHealthScreen(currentAnimal, ArrayKeeper.getCurrentUser());
        try {
            displayHealthScreen.start(stage);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void addHealthSituation(String Situation){
        arrayKeeper.getData().get(ArrayKeeper.getCurrentUser()).getAnimals().get(currentAnimal).addHealth(Situation);
        arrayKeeper.getData().get(ArrayKeeper.getCurrentUser()).getAnimals().get(currentAnimal).setDateHealth(""+java.time.LocalDate.now());
    }
}
