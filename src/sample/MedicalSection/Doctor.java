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
    private int userInt;
    ArrayKeeper arraykeeper = new ArrayKeeper();
    private ArrayList<Specialty> specialties = new ArrayList<>();
    private ArrayList<Dates> dates = new ArrayList<>();
    //String name, int userInt
    public Doctor(Object object[], ArrayList<Specialty> specialties) {
        this.name = object[0].toString();
        this.specialties = specialties;
        this.userInt = Integer.parseInt(object[1].toString());
        arraykeeper.addDoctor(this);
    }

    public Dates getDate(LocalDate date){
        for (int i =0; i < dates.size(); i++){
            if(dates.get(i).equals(date)){
                return dates.get(i);
            }
        }
        return dates.get(0);
    }

    public Boolean checkLocalDate(LocalDate date){
        for (int i = 0; i < dates.size(); i++){
            if(date.equals(dates.get(i).getDate())){
                return true;
            }
        }
        return false;
    }

    public void addLocalDate(Dates date){
        this.dates.add(date);
    }

    public ArrayList<Dates> getLocalDate(){
        return this.dates;
    }

    public String getName() {
        return this.name;
    }

    public int getUserInt(){
        return this.userInt;
    }

    public ArrayList<Specialty> getSpecialties() {
        return this.specialties;
    }

    public void addSpecialties(Specialty specialty) {
        if (checkSpecialty(specialty)) {
            this.specialties.add(specialty);
        }else{
            Alert doctorAlreadyHasSpecialt = new Alert(Alert.AlertType.ERROR);
            doctorAlreadyHasSpecialt.setContentText("This Doctor already has this specialty");
            doctorAlreadyHasSpecialt.show();
        }
    }

    public Specialty getSpecialty(String name){
        for(int i = 0; i < arraykeeper.getSpecialtiesArrayList().size(); i++){
            if(arraykeeper.getSpecialtiesArrayList().get(i).getName().equals(name)){
                return arraykeeper.getSpecialtiesArrayList().get(i);
            }
        }
        return arraykeeper.getSpecialtiesArrayList().get(0);
    }

    public Boolean checkSpecialty(Specialty specialty){
        for (int i = 0; i < specialties.size(); i++) {
            if (specialties.get(i).equals(specialty)) {
                return true;
            }
        }
        return false;
    }
}