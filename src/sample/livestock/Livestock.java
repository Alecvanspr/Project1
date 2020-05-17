package sample.livestock;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import sample.market.AuctionList;


public class Livestock extends Application {
    ArrayKeeper arrayKeeper = new ArrayKeeper();
    Scene stockScene;
    private int placeName = 75;
    private int placeHealth = 75;
    private int plaaceWeight = 75;
    ScrollPane liveStockScroll = new ScrollPane();
    Pane liveStockPane = new Pane();
    int currentAnimal = 0;

    @Override
    public void start(Stage stage) throws Exception{
        Button btnBack = new Button("Back");
        Button btnAdd = new Button("Add animal");
        Button btnShowAnimalsBySpiecies = new Button("Sort by spiecies");
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

        liveStockPane.getChildren().addAll(btnBack,btnAdd,lblName,lblHealth,lblWeight,btnShowAnimalsBySpiecies);
        btnBack.relocate(10,565);
        btnBack.setOnAction(e -> {
            returnHome(stage);
        });
        btnBack.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                btnBack.setScaleX(1.0);
                btnBack.setScaleY(1.0);
            }
        });
        btnBack.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                btnBack.setScaleY(1.2);
                btnBack.setScaleX(1.2);
            }
        });

        //Button to go back to make auction
        Button toMakeAuction = new Button("Go to Auctions");
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
                AuctionList auctionList = new AuctionList();
                try {
                    auctionList.start(stage);
                } catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });

        //Button to make Auction for your animals
        Button makeAuction = new Button("Make Auction of animals");
        makeAuction.relocate(575, 400);
        makeAuction.setPrefWidth(150);
        makeAuction.setPrefHeight(50);
        liveStockPane.getChildren().add(makeAuction);
        makeAuction.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ShowAnimalsBySpecies showAnimalsBySpecies = new ShowAnimalsBySpecies();
                try {
                    showAnimalsBySpecies.start(stage);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });
        makeAuction.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                makeAuction.setScaleX(1.2);
                makeAuction.setScaleY(1.2);
            }
        });
        makeAuction.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                makeAuction.setScaleY(1.0);
                makeAuction.setScaleX(1.0);
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
            currentAnimal = animal;
            label.setOnMouseClicked(E -> {
                goEditAnimal(stage, animal);
            });
            label.relocate(100, placeName);
            liveStockPane.getChildren().add(label);
            setPlaceName(getPlaats() + 35);
        }
    }
    public void displayHealth(Stage stage){
        for(int i = 0; i<arrayKeeper.getPersonaldata().get(ArrayKeeper.getCurrentUser()).getAnimals().size();i++){
            System.out.println(1-arrayKeeper.getPersonaldata().get(ArrayKeeper.getCurrentUser()).getAnimals().get(i).getHealth().size());
            int lastOne = (arrayKeeper.getPersonaldata().get(ArrayKeeper.getCurrentUser()).getAnimals().get(i).getHealth().size()-1);
            Label label = new Label(arrayKeeper.getPersonaldata().get(ArrayKeeper.getCurrentUser()).getAnimals().get(i).getHealth().get(lastOne));
            int animal = i;
            label.setOnMouseClicked(E -> {
                goDisplayHealth(stage, animal);
            });
            label.relocate(300, placeHealth);
            placeHealth = placeHealth + 35;
            liveStockPane.getChildren().add(label);
        }
    }
    public void displayWeight(Stage stage){
        for(int i = 0; i<arrayKeeper.getPersonaldata().get(ArrayKeeper.getCurrentUser()).getAnimals().size();i++){
            int lastOne = arrayKeeper.getPersonaldata().get(ArrayKeeper.getCurrentUser()).getAnimals().get(i).getWeight().size()-1;
            Label label = new Label("" + arrayKeeper.getPersonaldata().get(ArrayKeeper.getCurrentUser()).getAnimals().get(i).getWeight().get(lastOne));
            int animal = i;
            label.setOnMouseClicked(E -> {
                goDisplayWeight(stage, animal);
            });
            label.relocate(500, plaaceWeight);
            plaaceWeight = plaaceWeight + 35;
            liveStockPane.getChildren().add(label);
        }
    }
    public void setCurrentAnimal(int currentAnimal){
        this.currentAnimal = currentAnimal;
    }
    public void DisplayScreen(Stage stage){
        displayHealth(stage);
        displayWeight(stage);
        displayAllAnimals(stage);
    }
    public void setPlaceName(int place) {
        this.placeName = place;
    }
    public int getPlaats() {
        return placeName;
    }
}
