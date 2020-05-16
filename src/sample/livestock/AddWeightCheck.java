package sample.livestock;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.ArrayKeeper;

public class AddWeightCheck extends Application {
    ArrayKeeper arrayKeeper = new ArrayKeeper();
    Scene healthScene;
    Pane healthPane = new Pane();
    int currentAnimal;

    public AddWeightCheck(int currentAnimal){
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
            arrayKeeper.getPersonaldata().get(ArrayKeeper.getCurrentUser()).getAnimals().get(currentAnimal).addWeight(txtnewWeight.getText());
            arrayKeeper.getPersonaldata().get(ArrayKeeper.getCurrentUser()).getAnimals().get(currentAnimal).setDateWeight(""+java.time.LocalDate.now());
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
        healthPane.getChildren().addAll(txtnewWeight,btnAply,lblWeight,btnBack);
        healthScene = new Scene(healthPane,800,600);
        stage.setTitle("Add health check");
        stage.setScene(healthScene);
        stage.show();
    }
    public void goBack(Stage stage){
        DisplayWeight displayWeight = new DisplayWeight(currentAnimal,ArrayKeeper.getCurrentUser());
        try {
            displayWeight.start(stage);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}