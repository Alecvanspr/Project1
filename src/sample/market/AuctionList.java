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
import sample.Homescreen;
public class AuctionList{
    Scene AuctionList;
    Marketplace marketplace = new Marketplace();

    public void start(Stage stage) throws Exception{
        Button btnBack = new Button("Back");
        btnBack.relocate(10, 565);
        Pane auctionList = new Pane();
        auctionList.getChildren().add(btnBack);
        Label startLabel = new Label("Here you can see al the auctions");
        startLabel.setFont(Font.font("Arial",30));
        startLabel.relocate(200,0);
        auctionList.getChildren().add(startLabel);
        Label testLabel = new Label("TestLabel");
        testLabel.relocate(500, 500);
        auctionList.getChildren().add(testLabel);

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

        AuctionList = new Scene(auctionList, 800, 600);
        stage.setTitle("Auction list");
        stage.setScene(AuctionList);
        stage.show();
    }
}
