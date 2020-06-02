package sample;


import sample.MedicalSection.Doctor;
import sample.MedicalSection.Specialty;
import sample.inlogScreen.PersonalData;
import sample.livestock.Animal;
import sample.livestock.Species;

import java.util.ArrayList;

public class ArrayKeeper {
    public static ArrayList<PersonalData> Data = new ArrayList<>();
    public static ArrayList<Specialty> specialtiesArrayList = new ArrayList<>();
    public static ArrayList<Doctor> doctorsArrayList = new ArrayList<>();
    private static int currentUser;

    public ArrayKeeper(){
    }

    public void SignUpData(String name,String password,String birth, String security,String securityQ,Boolean isDoctor){
        PersonalData personalData = new PersonalData();
        personalData.setUserName(name);
        personalData.setPassword(password);
        personalData.setBirthDate(birth);
        personalData.setSecurtityQuestion(securityQ);
        personalData.setSecurityAnswer(security);
        personalData.setIsDocter(isDoctor);
        Data.add(personalData);
        currentUser++;
    }
    public void makeSpecialties(){
        Specialty diabetes = new Specialty("Diabetes");
        Specialty ears = new Specialty("Ears");
        Specialty eyes = new Specialty("Eyes");
        Specialty skin = new Specialty("Skin");
        Specialty general = new Specialty("General");
        addSpecialty(diabetes);
        addSpecialty(eyes);
        addSpecialty(ears);
        addSpecialty(skin);
        addSpecialty(general);
    }
    public ArrayList<Specialty> getSpecialtiesArrayList(){
        return this.specialtiesArrayList;
    }
    public void addSpecialty(Specialty specialty){
        specialtiesArrayList.add(specialty);
    }
    public ArrayList<Doctor> getDoctorsArrayList(){
        return this.doctorsArrayList;
    }
    public void addDoctor(Doctor doctor){
        doctorsArrayList.add(doctor);
    }

    public void changePassword(int user,String password){
        Data.get(user).setPassword(password);
    }

    public ArrayList<PersonalData> getPersonaldata(){
        return Data;
    }

    public void setCurrentUser(int currentUser){
        this.currentUser = currentUser;
    }

    public static int getCurrentUser() {
        return currentUser;
    }


    public PersonalData getData(int user) {
        return Data.get(user);
    }
}