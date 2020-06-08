package sample.MedicalSection;

import sample.ArrayKeeper;
import sample.inlogScreen.PersonalData;

public class Checks{
    public static boolean checkIfTimeAvailable(String time) {
        for(int i = 0; i < ArrayKeeper.getPersonalData(ArrayKeeper.getCurrentUser()).getAppointments().size(); i++){
            if(ArrayKeeper.getPersonalData(ArrayKeeper.getCurrentUser()).getAppointments().get(i).getAppointmentTime().equals(time)){
                return false;
            }
        }
        return true;
    }
}
