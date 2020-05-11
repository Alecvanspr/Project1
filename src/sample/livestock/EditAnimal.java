package sample.livestock;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class EditAnimal extends Application {
    Scene editscene;
    int currentAnimal;
    @Override
    public void start(Stage stage) throws Exception{
        Pane pane = new Pane();
        Button btnBack = new Button("Back");
        Label nameAnimal = new Label("Animal name ");
        Label ageAnimal = new Label();
        Label SpiecesAminal = new Label();

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

        pane.getChildren().addAll(nameAnimal,ageAnimal,SpiecesAminal);

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
