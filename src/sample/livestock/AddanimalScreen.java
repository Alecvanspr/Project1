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
    ButtonSettings buttonSettings = new ButtonSettings();
    Scene animalScene;
    Main main = new Main();
    GoToScreens goToScreens = new GoToScreens();

    @Override
    public void start(Stage stage) throws Exception{
        Pane animal = new Pane();
        animalScene = new Scene(animal,800,600);
        Button btnAdd = new Button("Add");
        Button btnBack = new Button("Back");
        Label lblname = new Label("Name animal");
        Label lblAge = new Label ("Age animal");
        Label lblgender = new Label("Gender animal");
        Label lblspiecies = new Label("Type animal");
        Label lblrace = new Label ("Race animal");
        Label lblweight = new Label("Weight animal");
        Label lblHealth = new Label("Current health situation animal");

        TextField txtname = new TextField();
        TextField txtAge = new TextField("0");
        TextField txtGender = new TextField();
        TextField textSpieses = new TextField();
        TextField txtRace = new TextField();
        TextField txtWeight = new TextField("0.00");
        TextField txtHealth = new TextField();

        btnAdd.relocate(300,500);
        lblname.relocate(100,100);
        txtname.relocate(300,100);
        lblAge.relocate(100,135);
        txtAge.relocate(300,135);
        lblgender.relocate(100,170);
        txtGender.relocate(300,170);
        lblspiecies.relocate(100,205);
        textSpieses.relocate(300 ,205);
        lblrace.relocate(100,240);
        txtRace.relocate(300,240);
        lblweight.relocate(100,270);
        txtWeight.relocate(300,270);
        lblHealth.relocate(100,305);
        txtHealth.relocate(300,305);
        btnBack.relocate(0,565);

        btnBack.setOnAction(E->{
            goToScreens.goLiveStock(stage);
        });

        btnAdd.setOnAction(E-> {
                    int intAge = Integer.parseInt(txtAge.getText());
                    double doubleWeight = Double.parseDouble(txtWeight.getText());
                    makeNewAnimal(txtname.getText(),txtGender.getText(),intAge,textSpieses.getText(),txtRace.getText(),doubleWeight,txtHealth.getText());
                    goToScreens.goLiveStock(stage);
                });
        buttonSettings.onMouse(btnAdd);
        buttonSettings.onMouse(btnBack);

        animal.getChildren().addAll(btnAdd,lblname,lblAge,lblgender,lblspiecies,lblrace,lblweight,lblHealth,txtname,txtAge,txtGender,textSpieses,txtRace,txtWeight,txtHealth,btnBack);
        stage.setTitle("Add animal");
        stage.setScene(animalScene);
        stage.show();
    }

    public void makeNewAnimal(String name,String gender,int age,String species,String race,double weight,String health){
        Animal newAminal = new Animal(name,gender,age,species,race,weight,health);
        newAminal.setDateHealth(""+ java.time.LocalDate.now());
        main.arraykeeper.getData().get(ArrayKeeper.getCurrentUser()).getAnimals().add(newAminal);
    }
}
