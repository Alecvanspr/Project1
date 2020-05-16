package sample.livestock;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.ArrayKeeper;

public class ShowAnimalsBySpecies extends Application {
    ArrayKeeper arrayKeeper = new ArrayKeeper();
    Scene scene;
    @Override
    public void start(Stage stage) throws Exception {
        Pane pane = new Pane();
        Label lblChicken = new Label("Chickens");
        Label lblChickenTotal = new Label(checkForAminal("Chicken")+"");//here comes the size.
        Label lblGoat = new Label("Goats");
        Label lblGoatsTotal = new Label("5");//here comes the size

        lblChicken.relocate(100,50);
        lblGoat.relocate(100,85);
        lblChickenTotal.relocate(300,50);
        lblGoat.relocate(300,85);


        pane.getChildren().addAll(lblChicken,lblGoat,lblChickenTotal,lblGoatsTotal);
        scene = new Scene(pane,800,600);
        stage.setTitle("Show Animals by spieces");
        stage.setScene(scene);
        stage.show();
    }
    public int checkForAminal(String species){
        int ret = 0;
        for(int i=0; i<arrayKeeper.getData(ArrayKeeper.getCurrentUser()).getAnimals().size();i++) {
            if(arrayKeeper.getData(ArrayKeeper.getCurrentUser()).getAnimals().get(i).getSpecies().equalsIgnoreCase(species)){
                ret++;
            }
        }
        return ret;
    }
}
