package sample.livestock;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HorizontalDirection;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.ArrayKeeper;
import sample.Homescreen;
import sample.livestock.Addanimal;
import sample.livestock.EditAnimal;
import sample.market.MakeAuction;

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
        Label lblName = new Label("Name Animal");
        Label lblHealth = new Label("Last health");
        Label lblWeight = new Label("Last Weight");
        lblName.relocate(100,40);
        lblHealth.relocate(300,40);
        lblWeight.relocate(500,40);

        stage.setResizable(false);

        btnAdd.relocate(100,10);

        ScrollBar scrollBar= new ScrollBar();
        scrollBar.setOrientation(Orientation.VERTICAL);
        scrollBar.setMinHeight(600);
        scrollBar.relocate(775,0);
        ScrollPane scrollPane = new ScrollPane(scrollBar);

        displayHealth(stage);
        displayWeight(stage);
        displayAllAnimals(stage);

        btnAdd.setOnAction(E->{
            goNewAnimal(stage);
        });

        liveStockPane.getChildren().addAll(btnBack,btnAdd,lblName,lblHealth,lblWeight);
        btnBack.relocate(0,570);
        btnBack.setOnAction(e -> {
            returnHome(stage);
        });
        //Button to go back to make auction
        Button toMakeAuction = new Button("Go to make Auction");
        toMakeAuction.relocate(575, 500);
        toMakeAuction.setPrefWidth(150);
        toMakeAuction.setPrefHeight(50);
        liveStockPane.getChildren().add(toMakeAuction);
        toMakeAuction.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                toMakeAuction.setScaleY(1.2);
                toMakeAuction.setScaleX(1.2);
            }
        });
        toMakeAuction.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                toMakeAuction.setScaleY(1.0);
                toMakeAuction.setScaleX(1.0);
            }
        });
        toMakeAuction.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                MakeAuction makeAuction = new MakeAuction();
                try {
                    makeAuction.start(stage);
                } catch (Exception ex){
                    ex.printStackTrace();
                }
            }
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
    public void goDisplayHealth(Stage stage,int animal){
        DisplayHealth displayHealth = new DisplayHealth(animal,ArrayKeeper.getCurrentUser());
        try {
            displayHealth.start(stage);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void goDisplayWeight(Stage stage,int animal){
        DisplayWeight displayWeight = new DisplayWeight(animal,ArrayKeeper.getCurrentUser());
        try {
            displayWeight.start(stage);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void displayAllAnimals(Stage stage){
        for(int i = 0; i<arrayKeeper.getPersonaldata().get(ArrayKeeper.getCurrentUser()).getAnimals().size(); i++){
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
    public void displayHealth(Stage stage){
        for(int i = 0; i<arrayKeeper.getPersonaldata().get(ArrayKeeper.getCurrentUser()).getAnimals().size();i++){
            Label label = new Label(arrayKeeper.getPersonaldata().get(ArrayKeeper.getCurrentUser()).getAnimals().get(i).getHealth().get(i));
            int animal = i;
            label.setOnMouseClicked(E->{
                goDisplayHealth(stage,animal);
            });
            label.relocate(300,plaats);
            liveStockPane.getChildren().add(label);
        }
    }
    public void displayWeight(Stage stage){
        for(int i = 0; i<arrayKeeper.getPersonaldata().get(ArrayKeeper.getCurrentUser()).getAnimals().size();i++){
            Label label = new Label(""+arrayKeeper.getPersonaldata().get(ArrayKeeper.getCurrentUser()).getAnimals().get(i).getWeight().get(i));
            int animal = i;
            label.setOnMouseClicked(E->{
                goDisplayWeight(stage,animal);
            });
            label.relocate(500,plaats);
            liveStockPane.getChildren().add(label);
        }
    }
}

