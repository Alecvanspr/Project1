package sample.market;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import sample.ArrayKeeper;

import javax.print.DocFlavor;

public class AuctionList{
    Scene AuctionList;
    Marketplace marketplace = new Marketplace();

    public void start(Stage stage) throws Exception{
        Button btnBack = new Button("Back");
        btnBack.relocate(10, 565);
        Pane auctionList = new Pane();
        auctionList.getChildren().add(btnBack);
        Label startLabel = new Label("Here you can see all the auctions");
        startLabel.setFont(Font.font("Arial",30));
        startLabel.relocate(200,0);
        auctionList.getChildren().add(startLabel);

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
                btnBack.setScaleX(1.0);
                btnBack.setScaleY(1.0);
            }
        });

        btnBack.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Marketplace markerplace = new Marketplace();
                try {
                    markerplace.start(stage);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });
        for(int i = 0; i < Auction.getAuctionList().size(); i++){
            Auction auction = Auction.getAuctionList().get(i);
            Integer howMany = auction.getForSaleQueue().size() +1 ; //De +1 is omdat de eerste animal van de auction niet in de queue komt
            TextField textField = new TextField(auction.getForSale().getSpecies() + "  -  " + howMany.toString() + "  -  " + Auction.getAuctionList().get(i).getHighestBid().getAmount());
            textField.relocate(10, 50+(30*i));
            auctionList.getChildren().add(textField);
            Button makeBid = new Button("MakeBid");
            makeBid.relocate(420, 50+(30*i));
            auctionList.getChildren().add(makeBid);
            TextField bidAmount = new TextField();
            bidAmount.relocate(200,50+(30*i));
            auctionList.getChildren().add(bidAmount);
            Integer x = i;
            makeBid.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {

                    Double amount = stringToDouble(checkIfDouble(bidAmount.getText()));
                    auction.makeBid(ArrayKeeper.Data.get(ArrayKeeper.getCurrentUser()).getUsername(), amount);
                    textField.setText(auction.getForSale().getSpecies() + "  -  " + howMany.toString() + "  -  " + Auction.getAuctionList().get(x).getHighestBid().getAmount());

                    if (auction.getAmountMustBeHigher()) {
                        Alert bidIsToLow = new Alert(AlertType.ERROR);
                        bidIsToLow.setContentText("Bid is to low! needs to be higher then " + Auction.getAuctionList().get(x).getHighestBid().getAmount());
                        bidIsToLow.show();
                    }else{
                        Alert bidIsPlaced = new Alert(AlertType.INFORMATION);
                        bidIsPlaced.setContentText("Bid of " + Auction.getAuctionList().get(x).getHighestBid().getAmount() + " has been placed!");
                        bidIsPlaced.show();
                    }
                    bidAmount.setText("");
                }
            });

        }


        AuctionList = new Scene(auctionList, 800, 600);
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
}
