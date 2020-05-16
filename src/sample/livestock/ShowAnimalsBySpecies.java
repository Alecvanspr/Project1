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
import sample.inlogScreen.PersonalData;
import sample.inlogScreen.SignUpScreen;
import sample.market.Auction;

public class ShowAnimalsBySpecies extends Application {
    ArrayKeeper arrayKeeper = new ArrayKeeper();
    Scene scene;
    @Override
    public void start(Stage stage) throws Exception {
        Pane pane = new Pane();
        for(int i = 0; i < PersonalData.getSpecies().size(); i++){
            Label label = new Label("You got " + PersonalData.getSpecies().get(i).getArrayListOfSpecies().size() + " animals of " + PersonalData.getSpecies().get(i).getSpecies());
            label.relocate(10, 50+(20*i));
            pane.getChildren().add(label);

            TextField textField = new TextField("");
            textField.relocate(250, 50+(20*i));
            textField.setPrefWidth(50);
            pane.getChildren().add(textField);

            TextField textField1 = new TextField("");
            textField1.relocate(400, 50+(20*i));
            textField1.setPrefWidth(75);
            pane.getChildren().add(textField1);

            Button makeAuction = new Button("Make auction");
            makeAuction.relocate(500, 50+(20*i));
            makeAuction.setPrefWidth(100);
            pane.getChildren().add(makeAuction);

            Integer x = i;
            makeAuction.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    if (Integer.valueOf(textField.getText()) <= PersonalData.getSpecies().get(x).getArrayListOfSpecies().size()){
                        Auction auction = new Auction(PersonalData.getSpecies().get(x).arrayListOfSpecies.getArrayList().get(x), Double.valueOf(textField1.getText()));
                        for(int i = 0; i < Integer.valueOf(textField.getText()); i++){
                            auction.addAnimalToQueue(PersonalData.getSpecies().get(x).arrayListOfSpecies.getArrayList().get(i));
                        }

                        ShowAnimalsBySpecies showAnimalsBySpecies = new ShowAnimalsBySpecies();
                        try {
                            showAnimalsBySpecies.start(stage);
                        }catch (Exception ex){
                            ex.printStackTrace();
                        }
                    }else{
                        Alert toMany = new Alert(Alert.AlertType.ERROR);
                        toMany.setContentText("You dont have that many Animals!");
                        toMany.show();
                    }


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
                Livestock livestock = new Livestock();
                try {
                    livestock.start(stage);
                } catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });

        scene = new Scene(pane,800,600);
        stage.setTitle("Show Animals by spieces");
        stage.setScene(scene);
        stage.show();
    }
    public int checkForAminal(String species){
        int ret = 0;
        for(int i=0; i<arrayKeeper.getData(ArrayKeeper.getCurrentUser()).getAnimals().size();i++) {
            if(arrayKeeper.getData(ArrayKeeper.getCurrentUser()).getAnimals().get(i).getSpecies().equalsIgnoreCase(species)){
                ret++;
            }
        }
        return ret;
    }


}
