package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Addanimal extends Application {
    Scene animalScene;

    @Override
    public void start(Stage stage) throws Exception{
        Pane animal = new Pane();
        animalScene = new Scene(animal,800,600);
        Button btnAdd = new Button("Add");
        Label lblname = new Label("Name Animal");
        Label lblgender = new Label("Gender Animal");
        Label lblspiecies = new Label("Type animal");
        TextField txtname = new TextField();
        TextField txtGender = new TextField();
        TextField textSpieses = new TextField();
        btnAdd.relocate(300,500);
        lblname.relocate(100,100);
        txtname.relocate(100,135);
        lblgender.relocate(100,170);
        txtGender.relocate(100,205);
        lblspiecies.relocate(100,240);
        textSpieses.relocate(100,275);

        Animal newAminal = new Animal();

        btnAdd.setOnAction(E-> {
                    newAminal.setName(txtname.getText());
                    newAminal.setGender(txtGender.getText());
                    newAminal.setSpecies(textSpieses.getText());
                    ArrayKeeper.Data.get(ArrayKeeper.getCurrentUser()).animals.add(newAminal);
                    goBack(stage);
                });

        animal.getChildren().addAll(btnAdd,lblname,lblgender,lblspiecies,txtname,txtGender,textSpieses);
        stage.setTitle("Add animal");
        stage.setScene(animalScene);
        stage.show();
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
