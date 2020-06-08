package sample.MedicalSection;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import sample.ArrayKeeper;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

public class FutureAppointments extends ShowAppointmentsScreen {
    ArrayList<Appointment> futureAppointments = new ArrayList<>();
    ArrayKeeper arrayKeeper;

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
                }
            }
        }
    }

    public ArrayList<Appointment> getUserAppointments(){
        return ArrayKeeper.getPersonalData(ArrayKeeper.getCurrentUser()).getAppointments();
    }
}
