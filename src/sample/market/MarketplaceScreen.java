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
    Pane market = new Pane();

    Font CfontArial = new Font("Arial", 50);
    Font fontArial = new Font("Arial", 11);

    @Override
    public void start(Stage stage) throws Exception{
        Label startLabel = new Label("Welcome to the auction page");
        startLabel.setFont(CfontArial);
        startLabel.relocate(75,25);
        market.getChildren().add(startLabel);

        makeButtons(stage);
        fin(stage);
    }
    public void fin(Stage stage){
        marktScene = new Scene(market,800,600);
        stage.setTitle("Market place");
        stage.setScene(marktScene);
        stage.show();
    }
    public void makeButtons(Stage stage){
        goBidHistory(stage);
        makeButtons(stage);
        makeBtnBack(stage);
        makeBtnAuction(stage);
        makeBtnYourAuction(stage);
        makeMakeAuction(stage);
    }
    public void createNewAution(Animal animal,double minPrice) {
        Auction auction = new Auction(animal, minPrice);
        auction.addAnimalToQueue(animal);
    }
    public void buttonSetLayout(Button button){
        button.setPrefWidth(100);
        button.setPrefHeight(100);
    }
    public void makeBtnAuction(Stage stage) {
        //button to go to auctionButton
        Button auctionButton = new Button("To Auction");
        auctionButton.setFont(fontArial);
        auctionButton.relocate(200,200);
        buttonSetLayout(auctionButton);
        market.getChildren().add(auctionButton);
        buttonSettings.onMouse(auctionButton);

        auctionButton.setOnAction(E->{
            goToScreens.goAutionlist(stage);
        });
    }
    public void makeMakeAuction(Stage stage){
        Button makeAuction = new Button("Make Auction");
        buttonSetLayout(makeAuction);
        makeAuction.relocate(500, 200);
        market.getChildren().add(makeAuction);
        buttonSettings.onMouse(makeAuction);
        makeAuction.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                goToScreens.goToMakeAuction(stage);
            }
        });
    }
    public void goBidHistory(Stage stage) {
        Button bidHistoryBtn = new Button("Your bid history");
        buttonSetLayout(bidHistoryBtn);
        bidHistoryBtn.setFont(fontArial);
        bidHistoryBtn.relocate(200, 400);
        market.getChildren().add(bidHistoryBtn);
        bidHistoryBtn.setOnAction(E->{
            goToScreens.goBidHistory(stage);
        });
    }
    public void makeBtnBack(Stage stage){
        //Go back button
        Button btnBack = new Button("Back");
        btnBack.relocate(10,565);
        market.getChildren().add(btnBack);
        buttonSettings.onMouse(btnBack);
        btnBack.setOnAction(e -> {
            goToScreens.goHomeScreen(stage);
        });
    }
    public void makeBtnYourAuction(Stage stage){
        //go to the Auctions of the user
        Button yourAuctionBtn = new Button("Your auctions");
        yourAuctionBtn.relocate(500, 400);
        buttonSetLayout(yourAuctionBtn);
        yourAuctionBtn.setFont(fontArial);
        market.getChildren().add(yourAuctionBtn);
        yourAuctionBtn.setOnAction(E-> {
            goToScreens.goYourAuction(stage);
        });

    }
}