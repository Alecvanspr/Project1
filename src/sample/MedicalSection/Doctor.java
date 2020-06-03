package sample.MedicalSection;

import javafx.scene.control.Alert;
import sample.ArrayKeeper;
import sample.inlogScreen.PersonalData;

import java.sql.Time;
import java.time.LocalTime;
import java.time.LocalDate;
import java.util.ArrayList;

public class Doctor extends PersonalData {
    private String name;
    private String age;
    private int userInt;
    ArrayKeeper arraykeeper = new ArrayKeeper();
    private ArrayList<Specialty> specialties = new ArrayList<>();
    private ArrayList<Appointment> appointments = new ArrayList<>();
    private ArrayList<Dates> dates = new ArrayList<>();

    public Doctor(String name, int userInt, ArrayList<Specialty> specialties) {
        this.name = name;
        this.specialties = specialties;
        this.userInt = userInt;
        arraykeeper.addDoctor(this);

    }
    public void addLocalDate(Dates date){
        this.dates.add(date);
    }
    public ArrayList<Dates> getLocalDate(){
        return this.dates;
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


    public void setName(String age) {
        this.age = age;
    }

    public ArrayList<Specialty> getSpecialties() {
        return this.specialties;
    }

    public void addSpecialties(Specialty specialty) {
        if (checkSpecialty(specialty)) {
            this.specialties.add(specialty);
        } else {
            Alert doctorAlreadyHasSpecialt = new Alert(Alert.AlertType.ERROR);
            doctorAlreadyHasSpecialt.setContentText("This Doctor already has this specialty");
            doctorAlreadyHasSpecialt.show();
        }
    }
    public Specialty getSpecialty(String name){
        for(int i = 0; i < arraykeeper.specialtiesArrayList.size(); i++){
            if(arraykeeper.specialtiesArrayList.get(i).getName().equals(name)){
                return arraykeeper.specialtiesArrayList.get(i);
            }
        }
        return arraykeeper.specialtiesArrayList.get(0);
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
