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
import sample.livestock.Animal;

public class Marketplace extends Application {
    Scene marktScene;
    Homescreen homescreen = new Homescreen();
    @Override
    public void start(Stage stage) throws Exception{
        Font CfontArial = new Font("Arial", 50);
        Font fontArial = new Font("Arial", 11);
        Label startLabel = new Label("Welcome to the auction page");
        startLabel.setFont(CfontArial);
        startLabel.relocate(75,25);
        Pane market = new Pane();
        market.getChildren().add(startLabel);

        //Go back button
        Button btnBack = new Button("Back");
        btnBack.relocate(10,565);
        market.getChildren().add(btnBack);
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
        btnBack.setOnAction(e -> {
            goBack(stage);
        });

        //go to the Auctions of the user
        Button yourAuctionBtn = new Button("your Auctions");
        yourAuctionBtn.relocate(500, 400);
        yourAuctionBtn.setPrefWidth(100);
        yourAuctionBtn.setPrefHeight(100);
        yourAuctionBtn.setFont(fontArial);
        market.getChildren().add(yourAuctionBtn);
        yourAuctionBtn.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                yourAuctionBtn.setScaleX(1.2);
                yourAuctionBtn.setScaleY(1.2);
            }
        });
        yourAuctionBtn.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                yourAuctionBtn.setScaleX(1.0);
                yourAuctionBtn.setScaleY(1.0);
            }
        });
        yourAuctionBtn.setOnAction(E-> {
            goYourAuction(stage);
        });
        //button to go to BidHistory
        Button bidHistoryBtn = new Button("your bid history");
        bidHistoryBtn.setPrefHeight(100);
        bidHistoryBtn.setPrefWidth(100);
        bidHistoryBtn.setFont(fontArial);
        bidHistoryBtn.relocate(200, 400);
        market.getChildren().add(bidHistoryBtn);
        bidHistoryBtn.setOnMouseEntered((new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                bidHistoryBtn.setScaleX(1.2);
                bidHistoryBtn.setScaleY(1.2);
            }
        }));
        bidHistoryBtn.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                bidHistoryBtn.setScaleX(1.0);
                bidHistoryBtn.setScaleY(1.0);
            }
        });
        bidHistoryBtn.setOnAction(E->{
            goBidHistory(stage);
        });


        //button to go to auctionButton
        Button auctionButton = new Button("To Auction");
        auctionButton.setFont(fontArial);
        auctionButton.relocate(200,200);
        auctionButton.setPrefHeight(100);
        auctionButton.setPrefWidth(100);
        market.getChildren().add(auctionButton);
        auctionButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                auctionButton.setScaleX(1.2);
                auctionButton.setScaleY(1.2);
            }
        });
        auctionButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                auctionButton.setScaleX(1.0);
                auctionButton.setScaleY(1.0);
            }
        });


        auctionButton.setOnAction(E->{
                Animal animal = new Animal("Jasper","man", 18, "Human","Human",80.0, "healthy");
                createNewAution(animal,1000.00); //ik heb een method gemaakt van de aution,die het automatisch in de Queue zet.
                Animal animal2 = new Animal("Jasper","man", 18, "Kip","Kip",80.0, "healthy");
                createNewAution(animal2,500);
                goAutionlist(stage);
        });
        marktScene = new Scene(market,800,600);
        stage.setTitle("Market place");
        stage.setScene(marktScene);
        stage.show();
    }
public void createNewAution(Animal animal,double minPrice) {
    Auction auction = new Auction(animal, minPrice);
    auction.addAnimalToQueue(animal);
    }
    public void goAutionlist(Stage stage){
        AuctionList auctionList = new AuctionList();
        try {
            auctionList.start(stage);
        }   catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void goBack(Stage stage){
        Homescreen homescreen = new Homescreen();
        try {
            homescreen.start(stage);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void goBidHistory(Stage stage){
        BidHistory bidHistory = new BidHistory();
        try{
            bidHistory.start(stage);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void goYourAuction(Stage stage){
        UserAuctions userAuctions = new UserAuctions();
        try{
            userAuctions.start(stage);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
