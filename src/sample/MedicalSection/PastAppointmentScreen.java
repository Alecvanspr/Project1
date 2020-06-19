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
    Button editAppointment = new Button("Edit appointment");
    Button buttonBack = new Button("Back");
    Button deleteAppointment = new Button("Cancel appointment");

    Label title = new Label("Your appointments");
    @Override
    public void start(Stage stage) throws  Exception{
        makeButton(stage);
        makeLabels();
        pane.getChildren().addAll(buttonBack, editAppointment, deleteAppointment,title);
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
        for(int i =0; i < getFutureAppointments().size(); i++){
            Label appointmentLabel = new Label("On " + getFutureAppointments().get(i).getAppointmentDate().toString() + " you have an appointment with " + getFutureAppointments().get(i).getDoctor().getName() +".");
            Label timeLabel = new Label("You're expected at the time of: " + getFutureAppointments().get(i).getAppointmentTime());
            appointmentLabel.relocate(100, 100+(50*i));
            timeLabel.relocate(100, 125+(50*i));

            pane.getChildren().addAll(appointmentLabel, timeLabel);
        }
    }
    public void makeButton(Stage stage){
        makeBtnEditAppointment(stage);
        makeExitButton(stage);
        makeCancelButton(stage);
        makeShowPastAppointmentScreen(stage);
    }
    public void makeShowPastAppointmentScreen(Stage stage){
        Button btnGoPastAppointment  = new Button("Show past Appointment");
        btnGoPastAppointment.setOnAction(E->{
            goToScreens.goShowPastAppointments(stage);
        });
        pane.getChildren().add(btnGoPastAppointment);
    }
    public void makeCancelButton(Stage stage){
        deleteAppointment.relocate(500, 250);
        deleteAppointment.setPrefWidth(125);
        deleteAppointment.setPrefHeight(100);
        buttonSettings.onMouse(deleteAppointment);
        deleteAppointment.setOnAction(E-> {
            goToScreens.goCancelAppointments(stage);
        });
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
        editAppointment.setPrefWidth(125);
        editAppointment.setPrefHeight(100);
        editAppointment.setOnAction(E-> {
            goToScreens.goEditAppointment(stage);
        });
    }
    public ArrayList<Appointment> getFutureAppointments(){
        FutureAppointments futureAppointments = new FutureAppointments();
        return futureAppointments.getFutureAppointments();
    }


    public void fin(Stage stage){
            scene = new Scene(pane,800,600);
            stage.setTitle("Your patients");
            stage.setScene(scene);
            stage.show();
    }
}
