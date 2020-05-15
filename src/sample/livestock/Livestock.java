package sample.livestock;

import javafx.application.Application;
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
        Label lblName = new Label("Name Animal");
        Label lblHealth = new Label("Last health");
        Label lblWeight = new Label("Last Weight");

        lblName.relocate(100,40);
        lblHealth.relocate(300,40);
        lblWeight.relocate(500,40);

        stage.setResizable(false);

        DisplayScreen(stage);

        btnAdd.relocate(100,10);

        ScrollBar scrollBar= new ScrollBar();
        scrollBar.setOrientation(Orientation.VERTICAL);
        scrollBar.setMinHeight(600);
        scrollBar.relocate(775,0);
        ScrollPane scrollPane = new ScrollPane(scrollBar);


        btnAdd.setOnAction(E->{
            goNewAnimal(stage);
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

        liveStockPane.getChildren().addAll(btnBack,btnAdd,lblName,lblHealth,lblWeight);
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

