package sample.MedicalSection;

import javafx.scene.control.Alert;
import sample.inlogScreen.PersonalData;

import java.sql.Time;
import java.time.LocalTime;
import java.time.LocalDate;
import java.util.ArrayList;

public class Doctor extends PersonalData {
    private String name;
    private int age;
    private int userInt;
    private ArrayList<Specialty> specialties = new ArrayList<>();
    private ArrayList<Appointment> appointments = new ArrayList<>();
    private static ArrayList<Doctor> doctors = new ArrayList<>();

    public Doctor(String name, int age, int userInt) {
        this.name = name;
        this.age = age;
        this.userInt = userInt;
        doctors.add(this);
    }
    public ArrayList<Appointment> getAppointments(){
        return this.appointments;
    }
    public String getName() {
        return this.name;
    }

    public int getUserInt(){
        return this.userInt;
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

    public static ArrayList<Doctor> getDoctors(){
        return doctors;
    }

    public void addSpecialties(Specialty specialty) {
        if (checkSpecialty(specialty)) {
            this.specialties.add(specialty);
        } else {
            Alert doctorAlreadyHasSpecialty = new Alert(Alert.AlertType.ERROR);
            doctorAlreadyHasSpecialty.setContentText("This Doctor already has this specialty");
            doctorAlreadyHasSpecialty.show();
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
