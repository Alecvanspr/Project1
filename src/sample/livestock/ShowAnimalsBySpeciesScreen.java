package sample.livestock;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.ArrayKeeper;
import sample.GoToScreens;
import sample.inlogScreen.PersonalData;
import sample.market.Auction;

public class ShowAnimalsBySpeciesScreen extends Application {
    ArrayKeeper arrayKeeper = new ArrayKeeper();
    ShowAnimalsBySpecies showAnimalsBySpecies = new ShowAnimalsBySpecies();
    GoToScreens goToScreens = new GoToScreens();
    Scene scene;
    @Override
    public void start(Stage stage) throws Exception {
        Pane pane = new Pane();
        for(int i = 0; i < PersonalData.getSpecies().size(); i++){
            Label label = new Label("You got " + PersonalData.getSpecies().get(i).getArrayListOfSpecies().size() + " animals of " + PersonalData.getSpecies().get(i).getSpecies());
            label.relocate(10, 50+(25*i));
            pane.getChildren().add(label);

            TextField textField = new TextField("");
            textField.relocate(250, 50+(25*i));
            textField.setPrefWidth(50);
            pane.getChildren().add(textField);

            TextField textField1 = new TextField("");
            textField1.relocate(400, 50+(25*i));
            textField1.setPrefWidth(75);
            pane.getChildren().add(textField1);

            Button makeAuction = new Button("Make auction");
            makeAuction.relocate(500, 50+(25*i));
            makeAuction.setPrefWidth(100);
            pane.getChildren().add(makeAuction);

            Integer x = i;
            makeAuction.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    showAnimalsBySpecies.displayBidFields(stage,Integer.valueOf(textField.getText()), Double.valueOf(textField1.getText()),x);
                }
            });
        }

        Label label2 = new Label("how many do you want to sale?");
        label2.relocate(200, 25);
        pane.getChildren().add(label2);
        Label label3 = new Label("Minimum price");
        label3.relocate(400, 25);
        pane.getChildren().add(label3);
        Button btnBack = new Button("Back");
        btnBack.relocate(750,565);
        pane.getChildren().add(btnBack);
        btnBack.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                goToScreens.goLiveStock(stage);
            }
        });

        scene = new Scene(pane,800,600);
        stage.setTitle("Show Animals by spieces");
        stage.setScene(scene);
        stage.show();
    }
        public void playError(){
            Alert toMany = new Alert(Alert.AlertType.ERROR);
            toMany.setContentText("You dont have that many Animals!");
            toMany.show();
        }

    }



