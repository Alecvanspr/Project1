package sample.market;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Timer;
import java.util.TimerTask;

public class MakeAuction extends Application {
    Scene MakeAuction;
    Marketplace marketplace = new Marketplace();

    public void start(Stage stage) throws  Exception{
        Pane makeAuction = new Pane();

        //Button Back
        Button backBtn = new Button("Back");
        backBtn.relocate(10, 565);
        makeAuction.getChildren().add(backBtn);
        backBtn.setOnMouseEntered(E-> {
            backBtn.setScaleX(1.2);
            backBtn.setScaleY(1.2);
        });
        backBtn.setOnMouseExited(E-> {
            backBtn.setScaleX(1.0);
            backBtn.setScaleY(1.0);
        });
        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                goBack(stage);
            }
        });
        //TextField voor Animal
        TextField animalField = new TextField();
        animalField.setPrefWidth(150);
        animalField.relocate(220,100);
        Label animalLabel = new Label("Animal: ");
        animalLabel.relocate(100,101);
        makeAuction.getChildren().add(animalField);
        makeAuction.getChildren().add(animalLabel);

        //TextField voor de how many
        TextField manyField = new TextField();
        manyField.setPrefWidth(150);
        manyField.relocate(220, 150);
        Label manyLabel = new Label("How many: ");
        manyLabel.setPrefWidth(150);
        manyLabel.relocate(100,151);
        makeAuction.getChildren().add(manyField);
        makeAuction.getChildren().add(manyLabel);

        //TextField voor de minPrice
        TextField priceField = new TextField();
        priceField.setPrefWidth(150);
        priceField.relocate(220, 200);
        Label priceLabel = new Label("Min price: ");
        priceLabel.setPrefWidth(150);
        priceLabel.relocate(100, 201);
        makeAuction.getChildren().add(priceField);
        makeAuction.getChildren().add(priceLabel);

        //TextField voor de timer
        TextField timerField = new TextField();
        timerField.setPrefWidth(150);
        timerField.relocate(220, 250);
        Label timerLabel = new Label("how long (hours per animal):");
        timerLabel.setPrefWidth(150);
        timerLabel.relocate(25, 251);
        makeAuction.getChildren().add(timerField);
        makeAuction.getChildren().add(timerLabel);

        MakeAuction = new Scene(makeAuction, 800, 600);
        stage.setTitle("Make Auction");
        stage.setScene(MakeAuction);
        stage.show();
    }
    public void makeAuction(){

    }
    public void goBack(Stage stage){
        Marketplace marketplace = new Marketplace();
        try {
            marketplace.start(stage);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }



}
