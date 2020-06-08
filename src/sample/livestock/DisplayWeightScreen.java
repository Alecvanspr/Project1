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
import sample.ButtonSettings;
import sample.GoToScreens;

public class DisplayWeightScreen extends Application {
    ButtonSettings buttonSettings = new ButtonSettings();
    Scene weightScene;
    ScrollPane weightScroll = new ScrollPane();
    ArrayKeeper arrayKeeper = new ArrayKeeper();
    Pane weightPane = new Pane();
    GoToScreens goToScreens = new GoToScreens();
    int plaats = 100;
    int currentAnimal;
    int currentUser;

    @Override
    public void start(Stage stage) throws Exception{
        btnAdd(stage);
        btnBack(stage);
        ShowWeight();
        fin(stage);
    }
    public void fin(Stage stage){
        weightScroll.setContent(weightPane);
        weightScene = new Scene(weightScroll,800,600);
        stage.setTitle("Weight overview");
        stage.setScene(weightScene);
        stage.show();
    }
    public void btnAdd(Stage stage){
        Button btnAdd = new Button("Add new weight");
        btnAdd.setOnAction(E->{
            goToScreens.goAddWeight(stage,currentAnimal);
        });
        buttonSettings.onMouse(btnAdd);
        weightPane.getChildren().add(btnAdd);
    }
    public void btnBack(Stage stage){
        Button btnBack = new Button("Back");
        btnBack.setOnAction(E->{
            goToScreens.goLiveStock(stage);
        });
        btnBack.relocate(0,575);
        buttonSettings.onMouse(btnBack);
        weightPane.getChildren().add(btnBack);
    }

    public DisplayWeightScreen(int currentAnimal, int CurrentUser){
        this.currentAnimal = currentAnimal;
        this.currentUser = CurrentUser;
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