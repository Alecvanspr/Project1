package sample.MedicalSection;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import sample.ArrayKeeper;

public class NotesScreen extends Application {
    Pane pane = new Pane();
    Appointment appointment = ArrayKeeper.getData().get(ArrayKeeper.getCurrentUser()).getAppointments().get(0);
    Scene scene;
    int currentAppointment;

    public NotesScreen(int currentAppointment){
        this.currentAppointment = currentAppointment;
    }
    @Override
    public void start(Stage stage) throws Exception {
        makeButtons();
        fin(stage);
    }
    public void fin(Stage stage){
        scene = new Scene(pane,800,600);
        stage.setTitle("Notes from your appointment");
        stage.setScene(scene);
        stage.show();
    }
    public void makeButtons(){
        makeBtnBack();
    }
    public void makeBtnBack(){
        Button btnBack = new Button("Back");
        btnBack.setOnAction(E->{

        });
        btnBack.relocate(0,565);
        pane.getChildren().add(btnBack);
    }
}
