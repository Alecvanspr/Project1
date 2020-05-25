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

public class BidHistoryScreen extends Application {

    Scene bidHistory;
    BidHistory userBids = new BidHistory();
    AuctionListScreen auctionListScreen = new AuctionListScreen();
    @Override
    public void start(Stage stage) throws  Exception{
        Pane bidHistoryPane = new Pane();

        //Button back
        Button btnBack = new Button("Back");
        btnBack.relocate(10,565);
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
                btnBack.setScaleX(1.0);
                btnBack.setScaleY(1.0);
            }
        });
        bidHistoryPane.getChildren().add(btnBack);
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
        MarketplaceScreen marketplaceScreen = new MarketplaceScreen();
        try{
            marketplaceScreen.start(stage);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void printBidHistory(Pane bidHistoryPane){
        for (int i = 0; i < userBids.getUserBidHistoryList().size(); i++){
            Label bidLabel = new Label("Bid #"+(i+1)+": " +
                    userBids.getUserBidHistoryList().get(i).getDate() + " " +
                    userBids.getUserBidHistoryList().get(i).getTime() + "  -   Amount = "+
                    userBids.getUserBidHistoryList().get(i).getAmount()+"   -   Animal = "+
                    userBids.getUserBidHistoryList().get(i).getAnimal().getSpecies()
            );

            bidLabel.relocate(10,50+(30*i));
            bidHistoryPane.getChildren().add(bidLabel);
            bidLabel.setFont(Font.font("Arial", 20));
        }
    }

}