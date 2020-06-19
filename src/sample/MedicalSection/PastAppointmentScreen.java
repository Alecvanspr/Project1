package sample.MedicalSection;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.ArrayKeeper;

import java.time.LocalDate;
import java.util.ArrayList;

public class PastAppointmentScreen extends Application {
    Pane pane = new Pane();
    Scene scene;

    @Override
    public void start(Stage stage) throws Exception {

        fin(stage);
    }

    public void fin(Stage stage){
            scene = new Scene(pane,800,600);
            stage.setTitle("Your patients");
            stage.setScene(scene);
            stage.show();
    }
}
