package sample.livestock;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.ArrayKeeper;

public class DisplayWeightScreen extends Application {
    Scene weightScene;
    ScrollPane weightScroll = new ScrollPane();
    ArrayKeeper arrayKeeper = new ArrayKeeper();
    Pane weightPane = new Pane();
    int plaats = 100;
    int currentAnimal;
    int currentUser;

    @Override
    public void start(Stage stage) throws Exception{
        Button btnBack = new Button("Back");
        Button btnAdd = new Button("Add new weight");
        btnBack.relocate(0,575);

        ShowWeight();

        btnAdd.setOnAction(E->{
            goAddWeight(stage);
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

        weightPane.getChildren().addAll(btnBack,btnAdd);
        weightScroll.setContent(weightPane);
        weightScene = new Scene(weightScroll,800,600);
        stage.setTitle("Weight overview ");//hier de naam van de ding
        stage.setScene(weightScene);
        stage.show();
    }
    public DisplayWeightScreen(int currentAnimal, int CurrentUser){
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
    public void goAddWeight(Stage stage){
        AddWeightCheckScreen addWeightCheckScreen = new AddWeightCheckScreen(currentAnimal);
        try {
            addWeightCheckScreen.start(stage);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void ShowWeight(){
        for(int i = 0; i<arrayKeeper.getPersonalData(ArrayKeeper.getCurrentUser()).getAnimals().get(currentAnimal).getWeight().size(); i++){
            Label Weight = new Label(""+arrayKeeper.getPersonalData(ArrayKeeper.getCurrentUser()).getAnimals().get(currentAnimal).getWeight().get(i));
            Label CheckDate = new Label(""+arrayKeeper.getPersonalData(ArrayKeeper.getCurrentUser()).getAnimals().get(currentAnimal).getDateWeight(i));
            Weight.relocate(100, plaats);
            CheckDate.relocate(300,plaats);
            plaats = plaats+35;
            weightPane.getChildren().addAll(CheckDate,Weight);
        }
    }
}