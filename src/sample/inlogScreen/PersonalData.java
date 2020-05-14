package sample.inlogScreen;

import sample.ArrayKeeper;
import sample.livestock.Animal;

import java.util.ArrayList;

public class PersonalData {
    ArrayList<Animal> animals= new ArrayList<>();
    private String Usernamename;
    private String name = "Not yet defined";
    private String password;
    private String birthDate;
    private String phoneNumber = "Not yet defined";
    private String email = "Not yet defined";
    private String gender = "Not yet defined";
    private String securtityQuestion;
    private String securityAnswer;
    public PersonalData(){
    }

    public String getSecurityAnswer() {
        return securityAnswer;
    }

    public void setSecurityAnswer(String securityAnswer) {
        this.securityAnswer = securityAnswer;
    }
    public void setSecurtityQuestion(String securtityQuestion){
        this.securtityQuestion = securtityQuestion;
    }
    public String getSecurtityQuestion() {
        return securtityQuestion;
    }

    public void setUserName(String name) {
        this.Usernamename = name;
    }

    public String getUsername() {
        return Usernamename;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return password;
    }
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(ArrayList<Animal> animals){
        this.animals = animals;
    }
}
