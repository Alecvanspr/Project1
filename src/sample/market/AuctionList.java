package sample.market;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.control.Alert.AlertType;
import sample.ArrayKeeper;


public class AuctionList extends Application {
    Scene AuctionList;
    Marketplace marketplace = new Marketplace();
    ScrollPane scrollPane = new ScrollPane();

    public void start(Stage stage) throws Exception{
        Pane auctionList = new Pane();

        //Button back
        Button btnBack = new Button("Back");
        btnBack.relocate(750, 565);
        auctionList.getChildren().add(btnBack);
        btnBack.setOnMouseEntered(E-> {
            btnBack.setScaleX(1.2);
            btnBack.setScaleY(1.2);
        });
        btnBack.setOnMouseExited(E-> {
            btnBack.setScaleX(1.0);
            btnBack.setScaleY(1.0);
        });
        btnBack.setOnAction(E-> {
            goBack(stage);
        });

        //Start Label
        Label startLabel = new Label("Here you can see all the auctions");
        startLabel.setFont(Font.font("Arial",30));
        startLabel.relocate(200,0);
        auctionList.getChildren().add(startLabel);

        printLines(auctionList);

        //Button to your bids
        Button btnToYourBids = new Button("To Your bids");
        btnToYourBids.relocate(650, 50);
        auctionList.getChildren().add(btnToYourBids);
        btnToYourBids.setOnMouseEntered(E->{
                btnToYourBids.setScaleX(1.0);
                btnToYourBids.setScaleY(1.0);
        });
        btnToYourBids.setOnMouseEntered(E-> {
                btnToYourBids.setScaleX(1.2);
                btnToYourBids.setScaleY(1.2);
        });
        btnToYourBids.setOnAction(E-> {
            goBidHistory(stage);
        });
        scrollPane.setContent(auctionList);
        AuctionList = new Scene(scrollPane, 800, 600);
        stage.setTitle("Auction list");
        stage.setScene(AuctionList);
        stage.show();
    }

    public double stringToDouble(String string){
        double d = Double.parseDouble(string);
        return d;
    }
    public static void main(String[] args) {

    }
    public String checkIfDouble(String string){
        if (!string.contains("\\.")){
            String correctString = string + ".0";
        }
        return string;
    }
    public void goBidHistory(Stage stage){
        BidHistory bidHistory = new BidHistory();
        try {
            bidHistory.start(stage);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void goBack(Stage stage){
        Marketplace marketplace = new Marketplace();
        try {
            marketplace.start(stage);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void makeBid(String bidAmount,Auction auction,TextField textField,Integer howMany,int x,TextField txtBidAmount){
        Double amount = stringToDouble(checkIfDouble(bidAmount));
        auction.makeBid(ArrayKeeper.Data.get(ArrayKeeper.getCurrentUser()).getUsername(), amount);
        textField.setText(auction.getForSale().getSpecies() + "  -  " + howMany.toString() + "  -  " + Auction.getAuctionList().get(x).getHighestBid().getAmount());

        if (auction.getAmountMustBeHigher(amount, auction.getHighestBid().getAmount())) {
            Alert bidIsToLow = new Alert(AlertType.ERROR);
            bidIsToLow.setContentText("Bid is to low! needs to be higher then " + Auction.getAuctionList().get(x).getHighestBid().getAmount());
            bidIsToLow.show();
        }else{
            Alert bidIsPlaced = new Alert(AlertType.INFORMATION);
            bidIsPlaced.setContentText("Bid of " + Auction.getAuctionList().get(x).getHighestBid().getAmount() + " has been placed!");
            bidIsPlaced.show();
        }
        txtBidAmount.setText("");
    }
    public void printLines(Pane auctionList){
        for(int i = 0; i < Auction.getAuctionList().size(); i++) {
            Auction auction = Auction.getAuctionList().get(i);
            Integer howMany = auction.getForSaleQueue().size() + 1; //De +1 is omdat de eerste animal van de auction niet in de queue komt
            TextField textField = new TextField(auction.getForSale().getSpecies() + "  -  " + howMany.toString() + "  -  " + Auction.getAuctionList().get(i).getHighestBid().getAmount());
            textField.relocate(10, 50 + (30 * i));
            auctionList.getChildren().add(textField);
            Button makeBid = new Button("MakeBid");
            makeBid.relocate(470, 50 + (30 * i));
            auctionList.getChildren().add(makeBid);
            TextField bidAmount = new TextField();
            bidAmount.relocate(250, 50 + (30 * i));
            auctionList.getChildren().add(bidAmount);
            Integer x = i;

            makeBid.setOnAction(E -> {
                makeBid(bidAmount.getText(), auction, textField, howMany, x, bidAmount);
            });
        }
    }
}
