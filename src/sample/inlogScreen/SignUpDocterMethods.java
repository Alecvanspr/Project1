package sample.inlogScreen;

import javafx.scene.control.Alert;
import sample.ArrayKeeper;
import sample.MedicalSection.Specialty;

import java.util.ArrayList;

public class SignUpDocterMethods {
    ArrayKeeper arrayKeeper = new ArrayKeeper();
    Object[] specialty1;
    ArrayList<Specialty> specialties;
    ArrayList<Specialty> allSpecialties = arrayKeeper.getSpecialtiesArrayList();

    public void addsSpecialtybtn(ArrayList<Specialty> specialties,Object[] specialty1){
        this.specialties = specialties;
        this.specialty1 = specialty1;
        Boolean alreadyHave = false;
        if (specialties.size() == 0) {
            addsSpecialty();
        } else {
            makeError();
            saveData(alreadyHave);
        }
    }
    public void addsSpecialty(){
        for (int i = 0; i < allSpecialties.size(); i++) {
            if (specialty1[i].toString().equals(allSpecialties.get(i).getName())) {
                specialties.add(allSpecialties.get(i));
            }
        }
    }
    public void makeError() {
        for (int j = 0; j < specialties.size(); j++) {
            if (specialties.get(j).getName().equals(specialty1[j].toString())) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("You already have this specialty!");
                alert.show();
            }
        }
    }
    public void saveData(boolean alreadyHave){
        if (alreadyHave == false) {
            for (int i = 0; i < allSpecialties.size(); i++) {
                if (allSpecialties.get(i).getName().equals(specialty1[i])) {
                    specialties.add(allSpecialties.get(i));
                }
            }
        }
    }

}
