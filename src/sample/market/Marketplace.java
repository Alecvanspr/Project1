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
        auctionButton.relocate(200,200);
        btnBack.relocate(10,565);
        auctionButton.setPrefHeight(100);
        auctionButton.setPrefWidth(100);


        Button yourAuctionBtn = new Button("To your Auctions");
        yourAuctionBtn.relocate(500, 200);
        yourAuctionBtn.setPrefWidth(100);
        yourAuctionBtn.setPrefHeight(100);
        yourAuctionBtn.setFont(Font.font("Arual", 10));
        market.getChildren().add(yourAuctionBtn);

        yourAuctionBtn.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                yourAuctionBtn.setScaleX(1.5);
                yourAuctionBtn.setScaleY(1.5);
            }
        });
        yourAuctionBtn.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                yourAuctionBtn.setScaleX(1.0);
                yourAuctionBtn.setScaleY(1.0);
            }
        });
        yourAuctionBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                UserAuctions userAuctions = new UserAuctions();
                try{
                    userAuctions.start(stage);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });
            auctionButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                auctionButton.setScaleX(1.5);
                auctionButton.setScaleY(1.5);
            }
        });
        auctionButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                auctionButton.setScaleX(1.0);
                auctionButton.setScaleY(1.0);
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
                Animal animal = new Animal("man", 18, "Jasper", "Human","Human",80.0, "healthy");
                Auction auction = new Auction(animal, 1000.0);
                Animal animal2 = new Animal("man", 18, "Jasper", "Kip","Kip",80.0, "healthy");
                auction.addAnimalToQueue(animal2);
                Auction auction2 = new Auction(animal, 500.0);
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

}
