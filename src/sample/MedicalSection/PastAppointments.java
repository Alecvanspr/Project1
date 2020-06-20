package sample.MedicalSection;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.ArrayKeeper;

import java.time.LocalDate;
import java.util.ArrayList;

public class PastAppointments extends PastAppointmentScreen{
    ArrayList<PastAppointment> pastAppointments = new ArrayList<>();
    ObservableList<String> appointmentsString = FXCollections.observableArrayList(pastAppointments.toString());
    ArrayKeeper arrayKeeper;
    MedicalSection medicalSection;

    public PastAppointments(){
        fillPastAppointments();
    }

    public ArrayList<PastAppointment> getPastAppointments(){
        return pastAppointments;
    }

    public void fillPastAppointments(){
        LocalDate dateNow = LocalDate.now();
        for(int i = 0; i < getUserAppointments().size(); i++){
            if(!(getUserAppointments().get(i).getAppointmentDate().getYear() < dateNow.getYear())){
                if(!(getUserAppointments().get(i).getAppointmentDate().getDayOfMonth() < dateNow.getDayOfMonth() && getUserAppointments().get(i).getAppointmentDate().getMonth().getValue() < dateNow.getMonth().getValue())){
                    pastAppointments.add(makePastAppointment(getUserAppointments().get(i)));
                    appointmentsString.add(getUserAppointments().get(i).getAppointmentDate().toString() + " - " + getPastAppointments().get(i).getDoctor().getName() + " - " + getPastAppointments().get(i).getAppointmentTime());
                }
            }
        }
    }

    public ArrayList<Appointment> getUserAppointments(){
        return ArrayKeeper.getPersonalData(ArrayKeeper.getCurrentUser()).getAppointments();
    }
    public PastAppointment makePastAppointment(Appointment appointment){
        //doctor, localdate, string, personalData , string
        PastAppointment pastAppointment = new PastAppointment(appointment.getDoctor(),appointment.getAppointmentDate(),appointment.getAppointmentTime(),appointment.getPatient(),appointment.getSpecialty().getName());
        return pastAppointment;
    }
}
