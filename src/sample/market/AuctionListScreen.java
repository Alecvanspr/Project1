package sample.market;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import sample.ButtonSettings;
import sample.GoToScreens;


public class AuctionListScreen extends Application {
    ButtonSettings buttonSettings =ButtonSettings.getInstance();
    Scene AuctionList;
    MarketplaceScreen marketplaceScreen = new MarketplaceScreen();
    ScrollPane scrollPane = new ScrollPane();
    AuctionList auctionListClass = new AuctionList();
    GoToScreens goToScreens = GoToScreens.getInstance();
    Pane auctionList = new Pane();

    public void start(Stage stage) throws Exception{
        makeButtons(stage);

        auctionListClass.printLines(auctionList);
        makeLabels();
        fin(stage);
    }
    public void fin(Stage stage){
        scrollPane.setContent(auctionList);
        AuctionList = new Scene(scrollPane, 800, 600);
        stage.setTitle("Auction list");
        stage.setScene(AuctionList);
        stage.show();
    }
    public void makeButtons(Stage stage){
        makeButtonBack(stage);
        makeToYourBids(stage);
    }
    public void makeLabels(){
        makeStartLabel();
    }
    public void makeStartLabel(){
        Label startLabel = new Label("Here you can see all the auctions");
        startLabel.setFont(Font.font("Arial",30));
        startLabel.relocate(200,0);
        auctionList.getChildren().add(startLabel);
    }
    public void  makeButtonBack(Stage stage){
        Button btnBack = new Button("Back");
        btnBack.relocate(750, 565);
        auctionList.getChildren().add(btnBack);
        buttonSettings.onMouse(btnBack);
        btnBack.setOnAction(E-> {
            goToScreens.goMarketplace(stage);
        });
    }

    public void makeToYourBids(Stage stage){
        Button btnToYourBids = new Button("To Your bids");
        btnToYourBids.relocate(650, 50);
        auctionList.getChildren().add(btnToYourBids);
        buttonSettings.onMouse(btnToYourBids);
        btnToYourBids.setOnAction(E-> {
            goToScreens.goBidHistory(stage);
        });
    }
}
