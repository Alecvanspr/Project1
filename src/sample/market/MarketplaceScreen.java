package sample.market;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import sample.ButtonSettings;
import sample.GoToScreens;
import sample.Homescreen;
import sample.livestock.Animal;

public class MarketplaceScreen extends Application {
    ButtonSettings buttonSettings = new ButtonSettings();
    Scene marktScene;
    Homescreen homescreen = new Homescreen();
    GoToScreens goToScreens = new GoToScreens();
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
        buttonSettings.onMouse(btnBack);
        btnBack.setOnAction(e -> {
            goToScreens.goHomeScreen(stage);
        });

        //go to the Auctions of the user
        Button yourAuctionBtn = new Button("Your auctions");
        yourAuctionBtn.relocate(500, 400);
        buttonSetLayout(yourAuctionBtn);
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
            goToScreens.goYourAuction(stage);
        });
        //button to go to BidHistory
        Button bidHistoryBtn = new Button("Your bid history");
        buttonSetLayout(bidHistoryBtn);
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
            goToScreens.goBidHistory(stage);
        });


        //button to go to auctionButton
        Button auctionButton = new Button("To Auction");
        auctionButton.setFont(fontArial);
        auctionButton.relocate(200,200);
        buttonSetLayout(auctionButton);
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

            goToScreens.goAutionlist(stage);
        });
        //Button to make Auction
        Button makeAuction = new Button("Make Auction");
        buttonSetLayout(makeAuction);
        makeAuction.relocate(500, 200);
        market.getChildren().add(makeAuction);
        makeAuction.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                makeAuction.setScaleX(1.0);
                makeAuction.setScaleY(1.0);
            }
        });
        makeAuction.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                makeAuction.setScaleX(1.2);
                makeAuction.setScaleY(1.2);
            }
        });
        makeAuction.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                goToScreens.goToMakeAuction(stage);
            }
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
    public void buttonSetLayout(Button button){
        button.setPrefWidth(100);
        button.setPrefHeight(100);
    }

}