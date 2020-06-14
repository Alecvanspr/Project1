package sample.MedicalSection;

import javafx.scene.control.Alert;
import sample.ArrayKeeper;
import sample.inlogScreen.PersonalData;
import java.time.LocalDate;
import java.util.ArrayList;

public class Doctor extends PersonalData {
    ArrayKeeper arraykeeper = new ArrayKeeper();
    private ArrayList<Specialty> specialties;
    private ArrayList<Dates> dates = new ArrayList<>();
    private ArrayList<PersonalData> patients = new ArrayList<>();

    public Doctor(String username, String name, String password, String dateOfBirth, String securityQuestion, String securityAnswer, ArrayList<Specialty> specialties){
        this.setUserName(username);
        this.setName(name);
        this.setPassword(password);
        this.setDateOfBirth(dateOfBirth);
        this.setSecurityQuestion(securityQuestion);
        this.setSecurityAnswer(securityAnswer);
        this.specialties = specialties;
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
        dates.add(date);
    }

    public ArrayList<Dates> getLocalDate(){
        return dates;
    }

    public ArrayList<Specialty> getSpecialties() {
        return specialties;
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

    public ArrayList<PersonalData> getPatients(){
        return patients;
    }

    public boolean checkHasPatient(PersonalData currentUser){
        for(int i = 0; i < patients.size(); i++){
            if(patients.get(i).equals(currentUser)){
                return true;
            }
        }
        return false;
    }

    public void addPatient(){
        if(!checkHasPatient(ArrayKeeper.getPersonalData(ArrayKeeper.getCurrentUser()))){
            getPatients().add(ArrayKeeper.getPersonalData(ArrayKeeper.getCurrentUser()));
        }
    }

    public static void makeDoctor(String textFieldUsername, String doctorNameText, String passwordField, String textFieldBirth, String securityQuestion, String securityAnswer, ArrayList<Specialty> specialties){
        Doctor newDoctor = new Doctor(textFieldUsername,doctorNameText,passwordField, textFieldBirth,securityQuestion, securityAnswer, specialties);
    }
}