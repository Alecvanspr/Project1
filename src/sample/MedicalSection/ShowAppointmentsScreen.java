package sample.MedicalSection;


import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import sample.ArrayKeeper;
import javafx.application.Application;
import javafx.stage.Stage;
import sample.inlogScreen.Main;

import java.util.ArrayList;


public class ShowAppointmentsScreen extends Application {
    Scene showAppointmentsScene;
    Main main;
    ArrayKeeper arrayKeeper;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        final int PaneWidth = 800;
        final int PaneHeight = 600;
        pane.setMinSize(PaneWidth, PaneHeight);

        Scene scene1 = new Scene(pane);

        Button buttonBack = new Button("Go back");
        buttonBack.relocate(10,565);
        FutureAppointments futureAppointments = new FutureAppointments();
        for(int i =0; i < getFutureAppointments().size(); i++){
            Label appointmentLabel = new Label("On " + getFutureAppointments().get(i).getAppointmentDate().toString() + " you have an appointment with " + getFutureAppointments().get(i).getDoctor().getName() +".");
            Label timeLabel = new Label("You're expected at the time of: " + getFutureAppointments().get(i).getAppointmentTime());
            appointmentLabel.relocate(100, 100+(50*i));
            timeLabel.relocate(100, 125+(50*i));

            pane.getChildren().addAll(appointmentLabel, timeLabel);
        }
        Button editAppointment = new Button("Edit appointment");
        editAppointment.relocate(400, 500);
        editAppointment.setPrefWidth(60);

        pane.getChildren().addAll(buttonBack, editAppointment);
        primaryStage.setScene(scene1);
        primaryStage.setTitle("Your appointments");
        primaryStage.show();



        buttonBack.setOnMouseClicked(E -> {
            MedicalSection medicalSection = new MedicalSection();
            try {
                medicalSection.start(primaryStage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }
    public ArrayList<Appointment> getFutureAppointments(){
        FutureAppointments futureAppointments = new FutureAppointments();
        return futureAppointments.getFutureAppointments();
    }


}
