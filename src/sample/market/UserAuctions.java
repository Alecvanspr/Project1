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
import sample.ButtonSettings;
import sample.GoToScreens;

import java.util.ArrayList;

public class UserAuctions extends Application{
    Scene userAuctions;
    MarketplaceScreen marketPlace = new MarketplaceScreen();
    ScrollPane scrollPane = new ScrollPane();
    GoToScreens goToScreens = new GoToScreens();;
    Pane userAuctionsPane = new Pane();
    ButtonSettings buttonSettings =ButtonSettings.getInstance();

    @Override
    public void start(Stage stage) throws Exception{
        makeBtnBack(stage);
        printLines(userAuctionsPane);
    }
    public void fin(Stage stage){
        scrollPane.setContent(userAuctionsPane);
        userAuctions = new Scene(scrollPane, 800, 600);
        stage.setTitle("Your Auctions");
        stage.setScene(userAuctions);
        stage.show();
    }
    public void makeBtnBack(Stage stage){
        Button btnBack = new Button("Back");
        btnBack.relocate(10, 565);
        userAuctionsPane.getChildren().add(btnBack);
        btnBack.setOnAction(E->{
            goToScreens.goAutionlist(stage);
        });
        buttonSettings.onMouse(btnBack);
    }

    //deze wordt mischien fout gerekend
    public void printLines(Pane userAuctions){
        ArrayList<Auction> userAuctionsList = new ArrayList<>();
        makeUserAuctionList(userAuctionsList);
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

    public void makeUserAuctionList(ArrayList<Auction> userAuctionsList){
        for (int i = 0; i < Auction.getAuctionList().size();i++){
            if(Auction.getAuctionList().get(i).getUserId() == ArrayKeeper.getCurrentUser()){
                userAuctionsList.add(Auction.getAuctionList().get(i));
            }
        }
    }
}