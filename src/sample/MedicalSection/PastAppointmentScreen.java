package sample.MedicalSection;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import sample.ArrayKeeper;
import sample.ButtonSettings;
import sample.GoToScreens;
import sample.inlogScreen.Main;

import java.time.LocalDate;
import java.util.ArrayList;

public class PastAppointmentScreen extends Application {
    Pane pane = new Pane();
    Scene scene;
    ButtonSettings buttonSettings =ButtonSettings.getInstance();
    GoToScreens goToScreens = GoToScreens.getInstance();
    Main main;
    ArrayKeeper arrayKeeper;
    Button buttonBack = new Button("Back");

    Label title = new Label("Your past appointments");
    @Override
    public void start(Stage stage) throws  Exception{
        makeButton(stage);
        makeLabels();
        pane.getChildren().addAll(buttonBack ,title);
        fin(stage);
    }
    public void makeLabels(){
        makeAppointmentLabels();
        makeTitleLabel();
    }
    public void makeTitleLabel(){
        title.relocate(100, 50);
        title.setFont(Font.font("Arial", 30));
    }
    public void makeAppointmentLabels(){
        for(int i =0; i < getPastAppointments().size(); i++){
            Label appointmentLabel = new Label("On " + getPastAppointments().get(i).getAppointmentDate().toString() + " you had an appointment with " + getPastAppointments().get(i).getDoctor().getName() +".");
            Label timeLabel = new Label("The appointment took place at: " + getPastAppointments().get(i).getAppointmentTime());
            appointmentLabel.relocate(100, 100+(50*i));
            timeLabel.relocate(100, 125+(50*i));

            pane.getChildren().addAll(appointmentLabel, timeLabel);
        }
    }
    public void makeButton(Stage stage){
        makeExitButton(stage);
    }

    public void makeExitButton(Stage stage){
        buttonBack.relocate(10,565);
        buttonSettings.onMouse(buttonBack);
        buttonBack.setOnAction(E-> {
            goToScreens.goMedicalSection(stage);
        });

    }

    public ArrayList<Appointment> getPastAppointments(){
        PastAppointments pastAppointments = new PastAppointments();
        return pastAppointments.getPastAppointments();
    }


    public void fin(Stage stage){
            scene = new Scene(pane,800,600);
            stage.setTitle("Your past appointments");
            stage.setScene(scene);
            stage.show();
    }
}
