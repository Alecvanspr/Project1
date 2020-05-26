package sample.MedicalSection;

import javafx.scene.control.Alert;

import java.sql.Time;
import java.time.LocalTime;
import java.time.LocalDate;
import java.util.ArrayList;

public class Docter {
    private String name;
    private int age;
    private ArrayList<Specialty> specialties = new ArrayList<>();
    private ArrayList<Appointment> appointments = new ArrayList<>();

    public Docter(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public ArrayList<Appointment> getAppointments(){
        return this.appointments;
    }
    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public void setName(int age) {
        this.age = age;
    }

    public ArrayList<Specialty> getSpecialties() {
        return this.specialties;
    }

    public void addSpecialties(Specialty specialty) {
        if (checkSpecialty(specialty)) {
            this.specialties.add(specialty);
        } else {
            Alert docterAlreadyHasSpecialt = new Alert(Alert.AlertType.ERROR);
            docterAlreadyHasSpecialt.setContentText("This Doctor already has this specialty");
            docterAlreadyHasSpecialt.show();
        }
    }

    public Boolean checkSpecialty(Specialty specialty){
        for(int i = 0; i < specialties.size(); i++){
            if(specialties.get(i).equals(specialty)){
                return true;
            }
        }
        return false;
    }
}
