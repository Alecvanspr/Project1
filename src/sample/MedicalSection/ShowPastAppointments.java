package sample.MedicalSection;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.ArrayKeeper;
import sample.ButtonSettings;
import sample.GoToScreens;
import sample.inlogScreen.Main;

import java.time.LocalDate;
import java.util.ArrayList;

public class ShowPastAppointments extends Application{
    Pane pane = new Pane();
    Scene showPastAppointments;
    Main main;
    ArrayKeeper arrayKeeper = new ArrayKeeper();
    GoToScreens goToScreens = new GoToScreens();
    ButtonSettings buttonSettings = ButtonSettings.getInstance();
    Button exitButton = new Button("Back");
    ArrayList<Appointment> appointments = makeAppointmentArrayList();

    @Override
    public void start(Stage stage) throws Exception{
        getUserAppointmentLists(ArrayKeeper.getCurrentUser());
        makeButtons(stage);
        pane.getChildren().addAll(exitButton);
        fin(stage);
    }

    public ArrayList<Appointment> makeAppointmentArrayList(){
        ArrayList<Appointment> pastAppointments = new ArrayList<>();
        for(int i =0; i < getUserAppointmentLists(ArrayKeeper.getCurrentUser()).size(); i++){
            if(checkIfAppointmentIsInPast(getUserAppointmentLists(ArrayKeeper.getCurrentUser()).get(i))){
                pastAppointments.add(getUserAppointmentLists(ArrayKeeper.getCurrentUser()).get(i));
            }
        }
        return pastAppointments;
    }

    public void makeAppointmentLabelsOnScreen(){
        for(int i =0; i< appointments.size(); i++){
            Label label = makeAppointmentLabel(appointments.get(i));
            int x = 100 + (50*i);
            label.relocate(100, x);
            pane.getChildren().add(label);
        }
    }

    public Boolean checkIfAppointmentIsInPast(Appointment appointment){
        LocalDate date = appointment.getAppointmentDate();
        LocalDate dateNow = LocalDate.now();
        if(dateNow.getYear() > date.getYear()){
            return true;
        }
        else if(dateNow.getYear() == date.getYear()){
            if(dateNow.getMonthValue() > date.getMonthValue()){
                return true;
            }
            else if(dateNow.getMonthValue() == date.getMonthValue()){
                if(dateNow.getDayOfYear() > date.getDayOfYear()){
                    return true;
                }
                else{
                    return false;
                }
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }

    public ArrayList<Appointment> getUserAppointmentLists(int userInt){
        return ArrayKeeper.getData().get(userInt).getAppointments();
    }

    public Label makeAppointmentLabel(Appointment appointment){
        Label label = new Label("You had an appointment on the date " + appointment.getAppointmentDate().getYear()+"/"+ appointment.getAppointmentDate().getMonthValue()+"/"+appointment.getAppointmentDate().getDayOfMonth());
        return label;
    }

    public void makeExitButton(Stage stage){
        exitButton.relocate(10, 565);
        buttonSettings.onMouse(exitButton);
        exitButton.setOnAction(E-> {
            goToScreens.goMedicalSection(stage);
        });
    }

    public void makeButtons(Stage stage){
        makeExitButton(stage);
    }

    public void fin(Stage stage){
        showPastAppointments = new Scene(pane, 800, 600);
        stage.setTitle("Past appointments");
        stage.setScene(showPastAppointments);
        stage.show();
    }
}
