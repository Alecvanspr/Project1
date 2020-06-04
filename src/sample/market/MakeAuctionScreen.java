package sample.market;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import sample.GoToScreens;
import sample.livestock.Livestock;
import javafx.scene.paint.Color;


public class MakeAuctionScreen extends Application {
    Scene MakeAuction;
    MarketplaceScreen marketplaceScreen = new MarketplaceScreen();
    GoToScreens goToScreens = new GoToScreens();

    public void start(Stage stage) throws  Exception{
        Pane makeAuction = new Pane();
        //Start Labels
        Label startLabel = new Label("Here you can make your own Auction");
        startLabel.relocate(175, 10);
        startLabel.setFont(Font.font("Arial", 30));
        makeAuction.getChildren().add(startLabel);
        Label secondLabel = new Label("For selling your animals go to your livestock");
        secondLabel.relocate(175, 50);
        secondLabel.setFont( Font.font("Arial", 15));
        makeAuction.getChildren().add(secondLabel);
        Label thirdLabel = new Label("Click here to go to your livestock");
        thirdLabel.relocate(175, 75);
        thirdLabel.setFont(Font.font("Aral",15));
        makeAuction.getChildren().add(thirdLabel);
        thirdLabel.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                goToScreens.goLiveStock(stage);
            }
        });
        thirdLabel.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent MouseEvent) {
                thirdLabel.setTextFill(Color.web("00FFFF"));
            }
        });
        thirdLabel.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                thirdLabel.setTextFill(Color.web("#000000"));
            }
        });

        //Button Back
        Button backBtn = new Button("Back");
        backBtn.relocate(10, 565);
        makeAuction.getChildren().add(backBtn);
        backBtn.setOnMouseEntered(E-> {
            backBtn.setScaleX(1.2);
            backBtn.setScaleY(1.2);
        });
        backBtn.setOnMouseExited(E-> {
            backBtn.setScaleX(1.0);
            backBtn.setScaleY(1.0);
        });
        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                goToScreens.goMarketplace(stage);
            }
        });
        //TextField voor Item
        TextField itemField = new TextField();
        itemField.setPrefWidth(150);
        itemField.relocate(220,100);
        Label itemLabel = new Label("Item: ");
        itemLabel.relocate(100,101);
        makeAuction.getChildren().add(itemField);
        makeAuction.getChildren().add(itemLabel);

        //TextField voor de how many
        TextField manyField = new TextField();
        manyField.setPrefWidth(150);
        manyField.relocate(220, 150);
        Label manyLabel = new Label("How many: ");
        manyLabel.setPrefWidth(150);
        manyLabel.relocate(100,151);
        makeAuction.getChildren().add(manyField);
        makeAuction.getChildren().add(manyLabel);

        //TextField voor de minPrice
        TextField priceField = new TextField();
        priceField.setPrefWidth(150);
        priceField.relocate(220, 200);
        Label priceLabel = new Label("Min price: ");
        priceLabel.setPrefWidth(150);
        priceLabel.relocate(100, 201);
        makeAuction.getChildren().add(priceField);
        makeAuction.getChildren().add(priceLabel);

        //TextField voor de timer
        TextField timerField = new TextField();
        timerField.setPrefWidth(150);
        timerField.relocate(220, 250);
        Label timerLabel = new Label("how long (hours per item):");
        timerLabel.setPrefWidth(150);
        timerLabel.relocate(20, 251);
        makeAuction.getChildren().add(timerField);
        makeAuction.getChildren().add(timerLabel);

        Button makeAuctionBtn = new Button("Make Auction");
        makeAuctionBtn.relocate(400, 250);
        makeAuctionBtn.setPrefWidth(150);
        makeAuction.getChildren().add(makeAuctionBtn);
        makeAuctionBtn.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                makeAuctionBtn.setScaleY(1.2);
                makeAuctionBtn.setScaleX(1.2);
            }
        });
        makeAuctionBtn.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                makeAuctionBtn.setScaleX(1.0);
                makeAuctionBtn.setScaleY(1.0);
            }
        });
        makeAuctionBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
            }
        });
        MakeAuction = new Scene(makeAuction, 800, 600);
        stage.setTitle("Make Auction");
        stage.setScene(MakeAuction);
        stage.show();
    }
}
