package sample.MedicalSection;


import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import sample.ArrayKeeper;
import javafx.application.Application;
import javafx.stage.Stage;
import sample.ButtonSettings;
import sample.GoToScreens;
import sample.inlogScreen.Main;

import java.util.ArrayList;


public class ShowAppointmentsScreen extends Application {
    Scene showAppointmentsScene;
    ButtonSettings buttonSettings = new ButtonSettings();
    GoToScreens goToScreens = new GoToScreens();
    Main main;
    ArrayKeeper arrayKeeper;
    Button editAppointment = new Button("Edit appointment");
    Button buttonBack = new Button("Go back");


    @Override
    public void start(Stage primaryStage) throws  Exception{
        Pane pane = new Pane();
        pane.setMinSize(800, 600);

        Scene scene1 = new Scene(pane);

        FutureAppointments futureAppointments = new FutureAppointments();
        for(int i =0; i < getFutureAppointments().size(); i++){
            Label appointmentLabel = new Label("On " + getFutureAppointments().get(i).getAppointmentDate().toString() + " you have an appointment with " + getFutureAppointments().get(i).getDoctor().getName() +".");
            Label timeLabel = new Label("You're expected at the time of: " + getFutureAppointments().get(i).getAppointmentTime());
            appointmentLabel.relocate(100, 100+(50*i));
            timeLabel.relocate(100, 125+(50*i));

            pane.getChildren().addAll(appointmentLabel, timeLabel);
        }


        pane.getChildren().addAll(buttonBack, editAppointment);
        primaryStage.setScene(scene1);
        primaryStage.setTitle("Your appointments");
        primaryStage.show();




    }
    public void makeButton(Stage stage){
        makeBtnEditAppointment(stage);
    }
    public void makeExitButton(Stage stage){
        buttonBack.relocate(10,565);
        buttonSettings.onMouse(buttonBack);
        buttonBack.setOnAction(E-> {
            goToScreens.goMedicalSection(stage);
        });

    }
    public void makeBtnEditAppointment(Stage stage){
        editAppointment.relocate(500, 100);
        buttonSettings.onMouse(editAppointment);
        editAppointment.setPrefWidth(100);
        editAppointment.setOnAction(E-> {
            goToScreens.goEditAppointment(stage);
        });
    }
    public ArrayList<Appointment> getFutureAppointments(){
        FutureAppointments futureAppointments = new FutureAppointments();
        return futureAppointments.getFutureAppointments();
    }


}
