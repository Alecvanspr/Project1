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
import sample.ButtonSettings;
import sample.GoToScreens;
import sample.livestock.Livestock;
import javafx.scene.paint.Color;


public class MakeAuctionScreen extends Application {
    Scene MakeAuction;
    MarketplaceScreen marketplaceScreen = new MarketplaceScreen();
    ButtonSettings buttonSettings =ButtonSettings.getInstance();
    GoToScreens goToScreens = GoToScreens.getInstance();
    Pane makeAuction = new Pane();

    public void start(Stage stage) throws  Exception{
        makeLabels(stage);
        makeTextFields(stage);

        fin(stage);
    }
    public void fin(Stage stage){
        MakeAuction = new Scene(makeAuction, 800, 600);
        stage.setTitle("Make Auction");
        stage.setScene(MakeAuction);
        stage.show();
    }
    public void makeAuctionButtons(Stage stage){
        Button makeAuctionBtn = new Button("Make Auction");
        makeAuctionBtn.relocate(400, 250);
        makeAuctionBtn.setPrefWidth(150);
        makeAuction.getChildren().add(makeAuctionBtn);
        buttonSettings.onMouse(makeAuctionBtn);
        makeAuctionBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

            }
        });
    }
    public void makeButtonBack(Stage stage){
        Button backBtn = new Button("Back");
        backBtn.relocate(10, 565);
        makeAuction.getChildren().add(backBtn);
        buttonSettings.onMouse(backBtn);
        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                goToScreens.goMarketplace(stage);
            }
        });
    }
    public void makeLabels(Stage stage){
        firstLabel();
        secondLabel();
        makeThirtLabel(stage);
    }
    public void makeThirtLabel(Stage stage){
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
        setColorOnEntered(thirdLabel);
    }
    public void setColorOnEntered(Label label){
        label.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent MouseEvent) {
                label.setTextFill(Color.web("00FFFF"));
            }
        });
        label.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                label.setTextFill(Color.web("#000000"));
            }
        });
    }
    public void secondLabel(){
        Label secondLabel = new Label("For selling your animals go to your livestock");
        secondLabel.relocate(175, 50);
        secondLabel.setFont( Font.font("Arial", 15));
        makeAuction.getChildren().add(secondLabel);
    }
    public void firstLabel(){
        Label startLabel = new Label("Here you can make your own Auction");
        startLabel.relocate(175, 10);
        startLabel.setFont(Font.font("Arial", 30));
        makeAuction.getChildren().add(startLabel);
    }
    public void makeTextFields(Stage stage){
        makeTextFieldItem(stage);
        makeTextFieldHowMany(stage);
        makeTextFieldMinPrice(stage);
        makeTextFieldTimeField(stage);
    }
    public void makeTextFieldItem(Stage stage){
        TextField itemField = new TextField();
        itemField.setPrefWidth(150);
        itemField.relocate(220,100);
        Label itemLabel = new Label("Item: ");
        itemLabel.relocate(100,101);
        makeAuction.getChildren().add(itemField);
        makeAuction.getChildren().add(itemLabel);
    }
    public void makeTextFieldHowMany(Stage stage){
        TextField manyField = new TextField();
        manyField.setPrefWidth(150);
        manyField.relocate(220, 150);
        Label manyLabel = new Label("How many: ");
        manyLabel.setPrefWidth(150);
        manyLabel.relocate(100,151);
        makeAuction.getChildren().add(manyField);
        makeAuction.getChildren().add(manyLabel);
    }
    public void makeTextFieldMinPrice(Stage stage){
        TextField priceField = new TextField();
        priceField.setPrefWidth(150);
        priceField.relocate(220, 200);
        Label priceLabel = new Label("Min price: ");
        priceLabel.setPrefWidth(150);
        priceLabel.relocate(100, 201);
        makeAuction.getChildren().add(priceField);
        makeAuction.getChildren().add(priceLabel);
    }
    public void makeTextFieldTimeField(Stage stage){
        TextField timerField = new TextField();
        timerField.setPrefWidth(150);
        timerField.relocate(220, 250);
        Label timerLabel = new Label("how long (hours per item):");
        timerLabel.setPrefWidth(150);
        timerLabel.relocate(20, 251);
        makeAuction.getChildren().add(timerField);
        makeAuction.getChildren().add(timerLabel);
    }
}
