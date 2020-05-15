package sample.market;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MakeAuction extends Application {
    Scene MakeAuction;
    Marketplace marketplace = new Marketplace();

    public void start(Stage stage) throws  Exception{
        Pane makeAuction = new Pane();

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
                goBack(stage);
            }
        });
        MakeAuction = new Scene(makeAuction, 800, 600);
        stage.setTitle("Make Auction");
        stage.setScene(MakeAuction);
        stage.show();
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
