package sample.MedicalSection;

import sample.ArrayKeeper;

import java.time.LocalDate;
import java.util.ArrayList;

public class PastAppointments{
    private ArrayList<Appointment> pastAppointments = new ArrayList<>();
    ArrayKeeper arrayKeeper;

    public PastAppointments(){
        fillPastAppointments();
    }

    public ArrayList<Appointment> getPastAppointments(){
        return pastAppointments;
    }

    public void fillPastAppointments(){
        LocalDate dateNow = LocalDate.now();
        for(int i = 0; i < getUserAppointments().size(); i++){
            if(getUserAppointments().get(i).getAppointmentDate().getYear() >= dateNow.getYear()){
                if(getUserAppointments().get(i).getAppointmentDate().getDayOfMonth() >= dateNow.getDayOfMonth() && getUserAppointments().get(i).getAppointmentDate().getMonth().getValue() >= dateNow.getMonth().getValue()){
                    pastAppointments.add(getUserAppointments().get(i));
                }
            }
        }
    }

    public ArrayList<Appointment> getUserAppointments(){
        return ArrayKeeper.getPersonalData(ArrayKeeper.getCurrentUser()).getAppointments();
    }
}
