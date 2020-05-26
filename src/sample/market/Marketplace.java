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
import sample.Homescreen;
import sample.livestock.Animal;

public class Marketplace extends Application {
    Scene marktScene;
    Homescreen homescreen = new Homescreen();
    int buttonNumber = 0;
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
        Button yourAuctionBtn = new Button("Your auctions");
        makeMenuButton(yourAuctionBtn, market);
        yourAuctionBtn.setOnAction(E-> {
            goYourAuction(stage);
        });
        //button to go to BidHistory
        Button bidHistoryBtn = new Button("Your bid history");
        makeMenuButton(bidHistoryBtn, market);
        bidHistoryBtn.setOnAction(E->{
            goBidHistory(stage);
        });


        //button to go to auctionButton
        Button auctionButton = new Button("To Auction");
        makeMenuButton(auctionButton,market);

        auctionButton.setOnAction(E->{

            goAutionlist(stage);
        });
        //Button to make Auction
        Button makeAuction = new Button("Make Auction");
        makeMenuButton(makeAuction, market);
        makeAuction.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                goToMakeAuction(stage);
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
    public void makeMenuButton(Button button, Pane pane){
        setButtonPosition(button, buttonNumber);
        buttonSetLayout(button);
        button.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setButtonScaleChange(button, 1.2);
            }
        });
        button.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setButtonScaleChange(button, 1.0);
            }
        });
        pane.getChildren().add(button);
    }
    public void setButtonScaleChange(Button button, Double scale){
        button.setScaleX(scale);
        button.setScaleY(scale);
    }

    public void setButtonPosition(Button button, int buttonNumber){
        if(buttonNumber == 0){
            button.relocate(200, 200);
        }else if(buttonNumber == 1){
            button.relocate(200,400);
        }else if(buttonNumber == 2){
            button.relocate(500, 200);
        }else{
            button.relocate(500, 400);
        }
        buttonNumber();
    }
    public void buttonNumber(){buttonNumber++;}
    public void buttonSetLayout(Button button){
        button.setPrefWidth(150);
        button.setPrefHeight(150);
    }
    public void goToMakeAuction(Stage stage){
        MakeAuction makeAuction = new MakeAuction();
        try {
            makeAuction.start(stage);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}