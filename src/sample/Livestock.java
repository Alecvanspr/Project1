package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.awt.image.AreaAveragingScaleFilter;

public class Livestock extends Application {
    Scene stockScene;
    public int plaats = 100;
    Pane liveS = new Pane();

    @Override
    public void start(Stage stage) throws Exception{
        Button btnBack = new Button("Back");
        Button btnAdd = new Button("Add animal");
        btnAdd.relocate(100,10);

        displayAllAnimals(stage);

        btnAdd.setOnAction(E->{
            goNewAnimal(stage);
        });

        liveS.getChildren().addAll(btnBack,btnAdd);
        btnBack.relocate(0,570);
        btnBack.setOnAction(e -> {
            returnHome(stage);
        });
        stockScene = new Scene(liveS,800,600);
        stage.setTitle("Livestock");
        stage.setScene(stockScene);
        stage.show();
    }
    public void returnHome(Stage stage){
        Homescreen homescreen = new Homescreen();
        try {
            homescreen.start(stage);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void goNewAnimal(Stage stage){
        Addanimal addanimal = new Addanimal();
        try {
            addanimal.start(stage);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void goEditAnimal(Stage stage){
        EditAnimal editAnimal = new EditAnimal();
        try {
            editAnimal.start(stage);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void displayAllAnimals(Stage stage){
        for(int i=0;i<ArrayKeeper.Data.get(ArrayKeeper.getCurrentUser()).animals.size();i++){
            Label label = new Label(ArrayKeeper.Data.get(ArrayKeeper.getCurrentUser()).animals.get(i).getName());
            label.setOnMouseClicked(E->{
                goEditAnimal(stage);
            });
            label.relocate(100, plaats);
            plaats = plaats+35;
            liveS.getChildren().add(label);
        }
    }
}

