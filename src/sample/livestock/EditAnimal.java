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
    private int currentAnimal;
    int currentUser = ArrayKeeper.getCurrentUser();
    //Animal animal = ArrayKeeper.Data.get(currentUser).getAnimals().get(currentAnimal); //kijk of je dit later kan implementeren
    public EditAnimal(int currentAnimal){
        this.currentAnimal = currentAnimal;
    }

    @Override
    public void start(Stage stage) throws Exception{
        Pane pane = new Pane();
        Button btnBack = new Button("Back");
        Label nameAnimal = new Label("Animal name "+ ArrayKeeper.Data.get(currentUser).getAnimals().get(currentAnimal).getName());
        Label ageAnimal = new Label("Animal Age " + ArrayKeeper.Data.get(currentUser).getAnimals().get(currentAnimal).getAge());
        Label SpiecesAminal = new Label("Animal species "+ ArrayKeeper.Data.get(currentUser).getAnimals().get(currentAnimal).getSpecies());

        btnBack.setOnAction(E-> {
            goBack(stage);
        });

        nameAnimal.relocate(100,100);
        ageAnimal.relocate(100,135);
        SpiecesAminal.relocate(100,170);

        pane.getChildren().addAll(nameAnimal,ageAnimal,SpiecesAminal,btnBack);

        editscene = new Scene(pane,800,600);
        stage.setTitle("Edit "+ ArrayKeeper.Data.get(currentUser).getAnimals().get(currentAnimal).getName()); //+ArrayKeeper.Data.get(ArrayKeeper.getCurrentUser()).animals.get().getName()
        stage.setScene(editscene);
        stage.show();
    }
    public void setCurrentAnimal(int invoerAnimal){
        this.currentAnimal = invoerAnimal;
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
