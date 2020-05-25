package sample.MedicalSection;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.ArrayKeeper;
import sample.inlogScreen.Main;

public class MakeAppointment extends Application {
    Scene makeAppointmentScene;
    Main main;
    ArrayKeeper arrayKeeper;
    @Override
    public void start(Stage stage) throws Exception{
        Pane pane = new Pane();

        makeAppointmentScene = new Scene(pane, 800, 600);
        stage.setTitle("Make Appointment here");
        stage.setScene(makeAppointmentScene);
        stage.show();
    }
}
