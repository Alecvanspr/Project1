package sample.livestock;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.ArrayKeeper;
import sample.inlogScreen.PersonalData;

import java.util.ArrayList;

public class EditAnimal extends Application {
    Scene editscene;
    int currentAnimal;
    int currentUser = ArrayKeeper.getCurrentUser();
    ArrayKeeper arrayKeeper = new ArrayKeeper();

    @Override
    public void start(Stage stage) throws Exception{
        Pane pane = new Pane();
        Button btnBack = new Button("Back");
        Label nameAnimal = new Label("Animal name "+ arrayKeeper.getPersonaldata().get(currentUser).getAnimals().get(currentAnimal).getName());
        Label ageAnimal = new Label("Animal Age " + arrayKeeper.getPersonaldata().get(currentUser).getAnimals().get(currentAnimal).getAge());
        Label SpiecesAminal = new Label("Animal Spied "+ arrayKeeper.getPersonaldata().get(currentUser).getAnimals().get(currentAnimal).getSpecies());

        btnBack.setOnAction(E-> {
            goBack(stage);
        });


        /*
        Hier moet een stuk code komen wat ervoor zorgt dat de current gebruiker,
        ook wel de i wordt meegegeven naar hier. Dan kan je daarmee in de array list.
        dan moet je ook nog een paar knoppen maken om die dingen te edditen.
        je kan dat denk ik doen door een 2de method die niet verbonden is aan de void start.
         */



        nameAnimal.relocate(100,100);
        ageAnimal.relocate(100,135);
        SpiecesAminal.relocate(100,170);

        pane.getChildren().addAll(nameAnimal,ageAnimal,SpiecesAminal,btnBack);

        editscene = new Scene(pane,800,600);
        stage.setTitle("Edit "); //+ArrayKeeper.Data.get(ArrayKeeper.getCurrentUser()).animals.get().getName()
        stage.setScene(editscene);
        stage.show();
    }
    public void setCurrentAnimal(int currentAnimal){
        this.currentAnimal = currentAnimal;
    }
    public void goBack(Stage stage){
        Livestock livestock = new Livestock();
        try {
            livestock.start(stage);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
