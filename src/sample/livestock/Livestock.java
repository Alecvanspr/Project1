package sample.livestock;

import javafx.application.Application;
import javafx.geometry.HorizontalDirection;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.ArrayKeeper;
import sample.Homescreen;
import sample.livestock.Addanimal;
import sample.livestock.EditAnimal;

public class Livestock extends Application {
    ArrayKeeper arrayKeeper = new ArrayKeeper();
    Scene stockScene;
    public int plaats = 75;
    ScrollPane liveStockScroll = new ScrollPane();
    Pane liveStockPane = new Pane();

    @Override
    public void start(Stage stage) throws Exception{
        Button btnBack = new Button("Back");
        Button btnAdd = new Button("Add animal");
        stage.setResizable(false);

        btnAdd.relocate(100,10);

        ScrollBar scrollBar= new ScrollBar();
        scrollBar.setOrientation(Orientation.VERTICAL);
        scrollBar.setMinHeight(600);
        scrollBar.relocate(775,0);
        ScrollPane scrollPane = new ScrollPane(scrollBar);

        displayAllAnimals(stage);

        btnAdd.setOnAction(E->{
            goNewAnimal(stage);
        });

        liveStockPane.getChildren().addAll(btnBack,btnAdd);
        btnBack.relocate(0,570);
        btnBack.setOnAction(e -> {
            returnHome(stage);
        });
        liveStockScroll.setContent(liveStockPane);
        stockScene = new Scene(liveStockScroll,800,600);
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
    public void goEditAnimal(Stage stage,int animal){
        EditAnimal editAnimal = new EditAnimal(animal,ArrayKeeper.getCurrentUser());
        try {
            editAnimal.start(stage);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void displayAllAnimals(Stage stage){
        for(int i = 0; i<arrayKeeper.getPersonaldata().get(ArrayKeeper.getCurrentUser()).getAnimals().size(); i++){
            System.out.println(ArrayKeeper.getCurrentUser());
            System.out.println(arrayKeeper.getPersonaldata().get(0).getAnimals().size());
            System.out.println(arrayKeeper.getPersonaldata().get(1).getAnimals().size());
            Label label = new Label(arrayKeeper.getPersonaldata().get(ArrayKeeper.getCurrentUser()).getAnimals().get(i).getName());
            int animal = i;
            label.setOnMouseClicked(E->{
                goEditAnimal(stage,animal);
            });
            label.relocate(100, plaats);
            plaats = plaats+35;
            liveStockPane.getChildren().add(label);
        }
    }
}

