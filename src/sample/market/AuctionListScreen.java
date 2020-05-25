package sample.market;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.text.Font;


public class AuctionListScreen extends Application {
    Scene AuctionList;
    Marketplace marketplace = new Marketplace();
    ScrollPane scrollPane = new ScrollPane();
    AuctionList auctionListClass = new AuctionList();

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

        auctionListClass.printLines(auctionList);

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

    public void goBidHistory(Stage stage){
        BidHistoryScreen bidHistoryScreen = new BidHistoryScreen();
        try {
            bidHistoryScreen.start(stage);
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

}
