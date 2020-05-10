package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class EditAnimal extends Application {
    Scene editscene;
    Livestock livestock;
    @Override
    public void start(Stage stage) throws Exception{
        Pane pane = new Pane();
        Label nameAnimal = new Label();
        Label ageAnimal = new Label();
        Label SpiecesAminal = new Label();

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

}
