package sample.livestock;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.ImageInput;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.ArrayKeeper;
import sample.ButtonSettings;
import sample.GoToScreens;
import sample.inlogScreen.Main;

public class AddanimalScreen extends Application {
    ButtonSettings buttonSettings =ButtonSettings.getInstance();
    Scene animalScene;
    Main main = new Main();
    Pane animal = new Pane();
    GoToScreens goToScreens = new GoToScreens();
    TextField txtname = new TextField();
    TextField txtAge = new TextField("0");
    TextField txtGender = new TextField();
    TextField textSpieses = new TextField();
    TextField txtRace = new TextField();
    TextField txtWeight = new TextField("0.00");
    TextField txtHealth = new TextField();


    @Override
    public void start(Stage stage) throws Exception{
        makeTextFields();
        makeLabels();
        makeButtons(stage);
        fin(stage);
    }
    public void fin(Stage stage){
        animalScene = new Scene(animal,800,600);
        stage.setTitle("Add animal");
        stage.setScene(animalScene);
        stage.show();
    }
    public void makeTextFields(){
        txtname.relocate(300,100);
        txtAge.relocate(300,135);
        txtGender.relocate(300,170);
        textSpieses.relocate(300 ,205);
        txtRace.relocate(300,240);
        txtWeight.relocate(300,270);
        txtHealth.relocate(300,305);
        animal.getChildren().addAll(txtname,txtAge,txtGender,textSpieses,txtRace,txtWeight,txtHealth);
    }
    public void makeLabels(){
        Label lblname = new Label("Name animal");
        Label lblAge = new Label ("Age animal");
        Label lblgender = new Label("Gender animal");
        Label lblspiecies = new Label("Type animal");
        Label lblrace = new Label ("Race animal");
        Label lblweight = new Label("Weight animal");
        Label lblHealth = new Label("Current health situation animal");
        lblname.relocate(100,100);
        lblAge.relocate(100,135);
        lblgender.relocate(100,170);
        lblspiecies.relocate(100,205);
        lblrace.relocate(100,240);
        lblweight.relocate(100,270);
        lblHealth.relocate(100,305);
        animal.getChildren().addAll(lblname,lblAge,lblgender,lblspiecies,lblrace,lblweight,lblHealth);
    }
    public void makeButtons(Stage stage){
        btnBack(stage);
        btnAdd(stage);
    }
    public void btnAdd(Stage stage){
        Button btnAdd = new Button("Add");
        btnAdd.setOnAction(E-> {
            int intAge = Integer.parseInt(txtAge.getText());
            double doubleWeight = Double.parseDouble(txtWeight.getText());
            Object newAnimalData[]={txtname.getText(),txtGender.getText(),intAge,textSpieses.getText(),txtRace.getText(),doubleWeight,txtHealth.getText()};
            makeNewAnimal(newAnimalData);
            goToScreens.goLiveStock(stage);
        });
        buttonSettings.onMouse(btnAdd);
        btnAdd.relocate(300,500);
        animal.getChildren().add(btnAdd);
    }
    public void btnBack(Stage stage){
        Button btnBack = new Button("Back");
        buttonSettings.onMouse(btnBack);
        btnBack.setOnAction(E->{
            goToScreens.goLiveStock(stage);
        });
        btnBack.relocate(0,565);
        animal.getChildren().add(btnBack);
    }

    public void makeNewAnimal(Object newAnimalData[]){
        //String name,String gender, Integer age,  String species, String race, Double weight,String Health
        Animal newAminal = new Animal(newAnimalData);
        newAminal.setDateHealth(""+ java.time.LocalDate.now());
        main.arraykeeper.getData().get(ArrayKeeper.getCurrentUser()).getAnimals().add(newAminal);
    }
}
