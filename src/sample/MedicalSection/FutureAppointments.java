package sample.MedicalSection;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import sample.ArrayKeeper;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

public class FutureAppointments extends ShowAppointmentsScreen {
    ArrayList<Appointment> futureAppointments = new ArrayList<>();
    ObservableList<String> appointmentsString = FXCollections.observableArrayList(futureAppointments.toString());
    ArrayKeeper arrayKeeper;
    MedicalSection medicalSection;


    public FutureAppointments(){
        fillFutureAppointments();
    }

    public ArrayList<Appointment> getFutureAppointments(){
        return this.futureAppointments;
    }

    public void fillFutureAppointments(){
        LocalDate dateNow = LocalDate.now();
        for(int i = 0; i < getUserAppointments().size(); i++){
            if(getUserAppointments().get(i).getAppointmentDate().getYear() >= dateNow.getYear()){
                if(getUserAppointments().get(i).getAppointmentDate().getDayOfMonth() >= dateNow.getDayOfMonth() && getUserAppointments().get(i).getAppointmentDate().getMonth().getValue() >= dateNow.getMonth().getValue()){
                    futureAppointments.add(getUserAppointments().get(i));
                    appointmentsString.add(getUserAppointments().get(i).getAppointmentDate().toString() + " - " + getFutureAppointments().get(i).getDoctor().getName() + " - " + getFutureAppointments().get(i).getAppointmentTime());
                }
            }
        }
    }

    public ArrayList<Appointment> getUserAppointments(){
        return ArrayKeeper.getPersonalData(ArrayKeeper.getCurrentUser()).getAppointments();
    }
}