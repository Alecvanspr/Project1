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
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.ArrayKeeper;
import sample.ButtonSettings;
import sample.GoToScreens;
import sample.inlogScreen.PersonalData;
import sample.market.Auction;

public class ShowAnimalsBySpeciesScreen extends Application {
    ButtonSettings buttonSettings =ButtonSettings.getInstance();
    ArrayKeeper arrayKeeper = new ArrayKeeper();
    ShowAnimalsBySpecies showAnimalsBySpecies = new ShowAnimalsBySpecies();
    GoToScreens goToScreens = GoToScreens.getInstance();
    Scene scene;
    Pane pane = new Pane();

    @Override
    public void start(Stage stage) throws Exception {
        printAllAnimals(stage);
        makeLabels();
        makeButtongoBack(stage);
        fin(stage);
    }
    public void fin(Stage stage){
        scene = new Scene(pane,800,600);
        stage.setTitle("Show Animals by spieces");
        stage.setScene(scene);
        stage.show();
    }
    public void makeButtongoBack(Stage stage){
        Button btnBack = new Button("Back");
        buttonSettings.onMouse(btnBack);
        btnBack.relocate(750,565);
        pane.getChildren().add(btnBack);
        btnBack.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                goToScreens.goLiveStock(stage);
            }
        });
    }
    public void makeLabels(){
        Label label2 = new Label("how many do you want to sale?");
        label2.relocate(200, 25);
        pane.getChildren().add(label2);
        Label label3 = new Label("Minimum price");
        label3.relocate(400, 25);
        pane.getChildren().add(label3);
    }
    public void printAllAnimals(Stage stage){
        for(int i = 0; i < PersonalData.getSpecies().size(); i++){
            Label label = new Label("You got " + PersonalData.getSpecies().get(i).getArrayListOfSpecies().size() + " animals of " + PersonalData.getSpecies().get(i).getSpecies());
            label.relocate(10, 50+(25*i));
            TextField textField = makeTextField(i);
            TextField textField1 = makeTextField2(i);
            Button makeAuction = makeButton(i);
            pane.getChildren().addAll(makeAuction,textField,textField1,label);
            Integer x = i;
            makeAuction.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    Object object[] = {Integer.valueOf(textField.getText()), Double.valueOf(textField1.getText()), x};
                    showAnimalsBySpecies.displayBidFields(stage,object);
                }
            });
        }
    }
    public TextField makeTextField(int location){
        TextField textField = new TextField("");
        textField.relocate(250, 50+(25*location));
        textField.setPrefWidth(50);
       return textField;
    }
    public TextField makeTextField2(int location){
        TextField textField1 = new TextField("");
        textField1.relocate(400, 50+(25*location));
        textField1.setPrefWidth(75);
        return textField1;
    }
    public void playError(){
        Alert toMany = new Alert(Alert.AlertType.ERROR);
        toMany.setContentText("You dont have that many Animals!");
        toMany.show();
    }
    public Button makeButton(int location){
        Button makeAuction = new Button("Make auction");
        buttonSettings.onMouse(makeAuction);
        makeAuction.relocate(500, 50+(25*location));
        makeAuction.setPrefWidth(100);
        return  makeAuction;
    }
}



