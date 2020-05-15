package sample.market;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import sample.ArrayKeeper;
import sample.market.AuctionList;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BidHistory extends Application {

    Scene bidHistory;
    userBidHistory userBids = new userBidHistory();
    AuctionList auctionList = new AuctionList();
    @Override
    public void start(Stage stage) throws  Exception{
        Pane bidHistoryPane = new Pane();
        Button btnBack = new Button("Exit");
        btnBack.relocate(10,565);
        bidHistoryPane.getChildren().add(btnBack);
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
        btnBack.setOnAction(E->{
            goBack(stage);
        });

        printBidHistory(bidHistoryPane);

        bidHistory = new Scene(bidHistoryPane, 800, 600);
        stage.setTitle("Bid History");
        stage.setScene(bidHistory);
        stage.show();
    }
    public void goBack(Stage stage){
        AuctionList auctionList = new AuctionList();
        try{
            auctionList.start(stage);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void printBidHistory(Pane bidHistoryPane){
        for (int i = 0; i < userBids.getUserBidHistoryList().size(); i++){
            Label bidLabel = new Label("Bid #"+(i+1)+": " +
                    userBids.userBidHistoryList.get(i).getDate() + " " +
                    userBids.userBidHistoryList.get(i).getTime() + "  -   Amount = "+
                    userBids.getUserBidHistoryList().get(i).getAmount()+"   -   Animal = "+
                    userBids.userBidHistoryList.get(i).getAnimal().getSpecies()
            );

            bidLabel.relocate(10,50+(30*i));
            bidHistoryPane.getChildren().add(bidLabel);
            bidLabel.setFont(Font.font("Arial", 20));
        }
    }
    public class userBidHistory{
        private ArrayList<Bid> userBidHistoryList = new ArrayList<Bid>();
        private int userInt;
        public userBidHistory(){
            this.userInt = ArrayKeeper.getCurrentUser();
            ArrayList<Bid> temporarlyList = new ArrayList<>();
            for(int i = 0; i < Auction.getAuctionList().size(); i++){
                temporarlyList = Auction.getAuctionList().get(i).getBidHistory();
                for (int j = 0; j < temporarlyList.size(); j++){
                    if (this.userInt == temporarlyList.get(j).getUserInt()){
                        userBidHistoryList.add(temporarlyList.get(j));
                    }
                }
            }

        }

        public int getUserInt(){
            return userInt;
        }
        public ArrayList<Bid> getUserBidHistoryList(){
            return this.userBidHistoryList;
        }
    }
}



