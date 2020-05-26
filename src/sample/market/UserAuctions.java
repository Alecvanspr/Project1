package sample.market;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.ArrayKeeper;

import java.util.ArrayList;

public class UserAuctions extends Application{
    Scene userAuctions;
    Marketplace marketPlace = new Marketplace();
    ScrollPane scrollPane = new ScrollPane();
    @Override
    public void start(Stage stage) throws Exception{
        Pane userAuctionsPane = new Pane();
        Button btnBack = new Button("Back");
        btnBack.relocate(10, 565);
        userAuctionsPane.getChildren().add(btnBack);
        printLines(userAuctionsPane);
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
        btnBack.setOnAction(E->{
            goBack(stage);
        });
        scrollPane.setContent(userAuctionsPane);

        userAuctions = new Scene(scrollPane, 800, 600);
        stage.setTitle("Your Auctions");
        stage.setScene(userAuctions);
        stage.show();
    }
    public void goBack(Stage stage){
        Marketplace marketplace = new Marketplace();
        try{
            marketplace.start(stage);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void printLines(Pane userAuctions){
        ArrayList<Auction> userAuctionsList = new ArrayList<>();
        for (int i = 0; i < Auction.getAuctionList().size();i++){
            if(Auction.getAuctionList().get(i).getUserId() == ArrayKeeper.getCurrentUser()){
                userAuctionsList.add(Auction.getAuctionList().get(i));
            }
        }
        for (int i = 0; i < userAuctionsList.size(); i++){
            Label userAuctionText = new Label("There are no bids yet");
            if(userAuctionsList.size()<=1){
                userAuctionText.setText(userAuctionsList.get(i).getForSale().getName() + " : Highest bid: " + userAuctionsList.get(i).getHighestBid().getAmount() + " from " + userAuctionsList.get(i).getHighestBid().getUser());
            }
            userAuctionText.setPrefWidth(300);
            userAuctionText.relocate(10, 50 + (30 * i));
            userAuctions.getChildren().add(userAuctionText);
        }
    }

}