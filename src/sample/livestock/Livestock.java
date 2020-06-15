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
import sample.ButtonSettings;
import sample.GoToScreens;
import sample.Homescreen;
import sample.market.AuctionListScreen;


public class Livestock extends Application {
    ArrayKeeper arrayKeeper = new ArrayKeeper();
    GoToScreens goToScreens = GoToScreens.getInstance();
    ButtonSettings buttonSettings =ButtonSettings.getInstance();
    Scene stockScene;
    private int placeName = 75;
    private int placeHealth = 75;
    private int plaaceWeight = 75;
    ScrollPane liveStockScroll = new ScrollPane();
    Pane liveStockPane = new Pane();
    int currentAnimal = 0;

    @Override
    public void start(Stage stage) throws Exception{
        makeLabels();
        stage.setResizable(false);
        makeBtnBack(stage);
        makeBtnAdd(stage);
        displayHealth(stage);
        displayWeight(stage);
        displayAllAnimals(stage);
        makeToMakeAuction(stage);
        makeMakeAuction(stage);
        fin(stage);
    }
    public void fin(Stage stage){
        liveStockScroll.setContent(liveStockPane);
        stockScene = new Scene(liveStockScroll,800,600);
        stage.setTitle("Livestock");
        stage.setScene(stockScene);
        stage.show();
    }
    public void makeLabels(){
        Label lblName = new Label("Name Animal");
        Label lblHealth = new Label("Last health");
        Label lblWeight = new Label("Last Weight");
        lblName.relocate(100,40);
        lblHealth.relocate(300,40);
        lblWeight.relocate(500,40);
        liveStockPane.getChildren().addAll(lblName,lblHealth,lblWeight);
    }
    public void makeMakeAuction(Stage stage){
        Button makeAuction = new Button("Make Auction of animals");
        makeAuction.relocate(575, 400);
        makeAuction.setPrefWidth(150);
        makeAuction.setPrefHeight(50);
        liveStockPane.getChildren().add(makeAuction);
        makeAuction.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                goToScreens.goShowAnimalsBySpiecies(stage);
            }
        });
        buttonSettings.onMouse(makeAuction);
    }
    public void makeToMakeAuction(Stage stage){
        Button toMakeAuction = new Button("Go to Auctions");
        toMakeAuction.relocate(575, 500);
        toMakeAuction.setPrefWidth(150);
        toMakeAuction.setPrefHeight(50);
        liveStockPane.getChildren().add(toMakeAuction);
        buttonSettings.onMouse(toMakeAuction);
        toMakeAuction.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                goToScreens.goAutionlist(stage);
            }
        });
    }
    public void displayAllAnimals(Stage stage){
        for(int i = 0; i<arrayKeeper.getPersonalData(ArrayKeeper.getCurrentUser()).getAnimals().size(); i++){
            Label label = new Label(arrayKeeper.getPersonalData(ArrayKeeper.getCurrentUser()).getAnimals().get(i).getName());
            int animal = i;
            currentAnimal = animal;
            label.setOnMouseClicked(E -> {
                goToScreens.goEditAnimal(stage, animal);
            });
            label.relocate(100, placeName);
            liveStockPane.getChildren().add(label);
            setPlaceName(getPlaats() + 35);
        }
    }
    public void makeBtnBack(Stage stage){
        Button btnBack = new Button("Back");
        btnBack.relocate(10,565);
        btnBack.setOnAction(e -> {
            goToScreens.goHomeScreen(stage);
        });
        buttonSettings.onMouse(btnBack);
        liveStockPane.getChildren().add(btnBack);
    }
    public void makeBtnAdd(Stage stage){
        Button btnAdd = new Button("Add animal");
        btnAdd.setOnAction(E->{
            goToScreens.goNewAnimal(stage);
        });
        btnAdd.relocate(100,10);
        liveStockPane.getChildren().add(btnAdd);
    }
    public void displayHealth(Stage stage){
        for(int i = 0; i<arrayKeeper.getPersonalData(ArrayKeeper.getCurrentUser()).getAnimals().size();i++){
            int lastOne = (arrayKeeper.getPersonalData(ArrayKeeper.getCurrentUser()).getAnimals().get(i).getHealth().size()-1);
            Label label = new Label(arrayKeeper.getPersonalData(ArrayKeeper.getCurrentUser()).getAnimals().get(i).getHealth().get(lastOne));
            int animal = i;
            label.setOnMouseClicked(E -> {
                goToScreens.displayHealth(stage, animal);
            });
            label.relocate(300, placeHealth);
            placeHealth = placeHealth + 35;
            liveStockPane.getChildren().add(label);
        }
    }
    public void displayWeight(Stage stage){
        for(int i = 0; i<arrayKeeper.getPersonalData(ArrayKeeper.getCurrentUser()).getAnimals().size();i++){
            int lastOne = arrayKeeper.getPersonalData(ArrayKeeper.getCurrentUser()).getAnimals().get(i).getWeight().size()-1;
            Label label = new Label("" + arrayKeeper.getPersonalData(ArrayKeeper.getCurrentUser()).getAnimals().get(i).getWeight().get(lastOne));
            int animal = i;
            label.setOnMouseClicked(E -> {
                goToScreens.displayWeight(stage, animal);
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
