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
import sample.ButtonSettings;
import sample.GoToScreens;

public class BidHistoryScreen extends Application {
    ButtonSettings buttonSettings =ButtonSettings.getInstance();
    Scene bidHistory;
    BidHistory userBids = new BidHistory();
    AuctionListScreen auctionListScreen = new AuctionListScreen();
    GoToScreens goToScreens = GoToScreens.getInstance();
    Pane bidHistoryPane = new Pane();

    @Override
    public void start(Stage stage) throws  Exception{
        makeBtnBack(stage);
        printBidHistory(bidHistoryPane);
        fin(stage);
    }
    public void fin(Stage stage){
        bidHistory = new Scene(bidHistoryPane, 800, 600);
        stage.setTitle("Bid History");
        stage.setScene(bidHistory);
        stage.show();
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
    public void makeBtnBack(Stage stage){
        Button btnBack = new Button("Back");
        btnBack.relocate(10,565);
        bidHistoryPane.getChildren().add(btnBack);
        btnBack.setOnAction(E->{
            goToScreens.goMarketplace(stage);
        });
        buttonSettings.onMouse(btnBack);
    }

}