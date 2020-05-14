package sample.market;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import sample.Homescreen;

public class Marketplace extends Application {
    Scene marktScene;
    Homescreen homescreen = new Homescreen();
    @Override
    public void start(Stage stage) throws Exception{
        Button btnBack = new Button("Back");
        Button auctionButton = new Button("To Auction");
        Label startLabel = new Label("Welcome to the auction page");
        startLabel.setFont(Font.font ("Arial", 30));
        startLabel.relocate(200,0);
        Pane market = new Pane();
        market.getChildren().add(btnBack);
        market.getChildren().add(auctionButton);
        market.getChildren().add(startLabel);
        auctionButton.relocate(600,200);
        btnBack.relocate(10,565);
        auctionButton.setScaleX(2.0);
        auctionButton.setScaleY(2.0);
        auctionButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                auctionButton.setScaleX(2.2);
                auctionButton.setScaleY(2.2);
            }
        });
        auctionButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                auctionButton.setScaleX(2.0);
                auctionButton.setScaleY(2.0);
            }
        });
        btnBack.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                btnBack.setScaleX(1.5);
                btnBack.setScaleY(1.5);

            }
        });
        btnBack.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                btnBack.setScaleX(1);
                btnBack.setScaleY(1);

            }
        });
        btnBack.setOnAction(e -> {
            Homescreen homescreen = new Homescreen();
            try {
                homescreen.start(stage);
            } catch (Exception ex){
                ex.printStackTrace();
            }
        });
        auctionButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                AuctionList auctionList = new AuctionList();
                try {
                    auctionList.start(stage);
                }   catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });
        marktScene = new Scene(market,800,600);
        stage.setTitle("Market place");
        stage.setScene(marktScene);
        stage.show();
    }
    public void goAuction(Stage stage){
        Marketplace markt = new Marketplace();
        try {
            markt.start(stage);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
