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
public class UserAuctions extends Application{
    Scene userAuctions;
    Marketplace marketPlace = new Marketplace();
    @Override
    public void start(Stage stage) throws Exception{
        Pane userAuctionsPane = new Pane();
        Button btnBack = new Button("Back");
        btnBack.relocate(10, 565);
        userAuctionsPane.getChildren().add(btnBack);
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

        userAuctions = new Scene(userAuctionsPane, 800, 600);
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
}
