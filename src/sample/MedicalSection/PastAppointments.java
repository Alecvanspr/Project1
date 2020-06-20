package sample.MedicalSection;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.ArrayKeeper;
import sample.ButtonSettings;

import java.time.LocalDate;
import java.util.ArrayList;

public class PastAppointments{
    private static PastAppointments instance;
    private PastAppointments(){
    }
    public static PastAppointments getInstance(){
        if(instance==null) {
            instance=new PastAppointments();
        }
        return instance;
    }
    public ArrayList<Appointment> pastAppointments = new ArrayList<>();
    ObservableList<String> appointmentsString = FXCollections.observableArrayList(pastAppointments.toString());
    ArrayKeeper arrayKeeper;
    MedicalSection medicalSection;

    public ArrayList<Appointment> getPastAppointments(){
        return pastAppointments;
    }
    public void clearPastAppointments(){
        pastAppointments.clear();
    }

    public ArrayList<Appointment> fillPastAppointments(){ //todo deze returnt geen drol.
        //clearPastAppointments();
        LocalDate dateNow = LocalDate.now();
        System.out.println(getUserAppointments().size());
        for(int i = 0; i < getUserAppointments().size(); i++){
            if((getUserAppointments().get(i).getAppointmentDate().getYear() < dateNow.getYear())){ //todo hier ! voor zetten.
                if((getUserAppointments().get(i).getAppointmentDate().getDayOfMonth() < dateNow.getDayOfMonth() && getUserAppointments().get(i).getAppointmentDate().getMonth().getValue() < dateNow.getMonth().getValue())){
                    pastAppointments.add(getUserAppointments().get(i));
                    appointmentsString.add(getUserAppointments().get(i).getAppointmentDate().toString() + " - " + getPastAppointments().get(i).getDoctor().getName() + " - " + getPastAppointments().get(i).getAppointmentTime());
                }
            }
        }//todo delte this
        System.out.println(getUserAppointments().size()+"De size");
        return pastAppointments;
    }

    public ArrayList<Appointment> getUserAppointments(){
        return ArrayKeeper.getPersonalData(ArrayKeeper.getCurrentUser()).getAppointments();
    }
}