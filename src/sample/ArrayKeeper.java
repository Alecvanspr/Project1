package sample;


import sample.MedicalSection.Doctor;
import sample.MedicalSection.Specialty;
import sample.inlogScreen.PersonalData;
import sample.livestock.Animal;
import sample.livestock.Species;

import java.util.ArrayList;

public class ArrayKeeper {
    private static ArrayList<PersonalData> Data = new ArrayList<>();
    private static ArrayList<Specialty> specialtiesArrayList = new ArrayList<>();
    private static ArrayList<Doctor> doctorsArrayList = new ArrayList<>();
    private static int currentUser;

    public ArrayKeeper(){
    }
    //String password,String PasswordConfig, String username,String birthday,String securityAnswer,String securityQuestions,boolean toDocter
    //String name,String password,String birth, String security,String securityQ, Boolean isDoctor
    public void SignUpData(Object object[]){
        PersonalData personalData = new PersonalData();
        personalData.setUserName(object[2].toString());
        personalData.setPassword(object[0].toString());
        personalData.setBirthDate(object[3].toString());
        personalData.setSecurtityQuestion(object[5].toString());
        personalData.setSecurityAnswer(object[4].toString());
        personalData.setIsDocter(Boolean.parseBoolean(object[6].toString()));
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

    public void setCurrentUser(int currentUser){
        this.currentUser = currentUser;
    }

    public static int getCurrentUser() {
        return currentUser;
    }

    public static ArrayList<PersonalData> getData(){
        return Data;
    }

    public static PersonalData getPersonalData(int user) {
        return Data.get(user);
    }

    public static Doctor findDoctor(String doctorName){
        for(int i = 0; i < ArrayKeeper.doctorsArrayList.size(); i++){
            if(ArrayKeeper.doctorsArrayList.get(i).getName().equals(doctorName)){
                return ArrayKeeper.doctorsArrayList.get(i);
            }
        }
        return null;
    }
}