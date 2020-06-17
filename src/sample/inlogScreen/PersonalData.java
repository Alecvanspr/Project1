package sample.inlogScreen;

import sample.MedicalSection.Appointment;
import sample.ArrayKeeper;
import sample.MedicalSection.Complaint;
import sample.livestock.Animal;
import sample.livestock.Species;

import java.util.ArrayList;

public class PersonalData {
    ArrayList<Animal> animals= new ArrayList<>();
    ArrayKeeper arrayKeeper = new ArrayKeeper();
    static ArrayList<Species> species= new ArrayList<>();
    private ArrayList<Appointment> appointments = new ArrayList<>();
    private ArrayList<Complaint> complaints = new ArrayList<>();
    private String username, name = "Not yet defined", password, dateOfBirth, phoneNumber = "Not yet defined", email = "Not yet defined",
    gender = "Not yet defined", securityQuestion, securityAnswer;

    public PersonalData(){
        ArrayKeeper.getData().add(this);
    }
    //deze inkorten?
    //String username, String name, String password, String dateOfBirth, String securityQuestion, String securityAnswer
    public PersonalData(String[] data){
        this.username = data[0];
        this.name = data[1];
        this.password = data[2];
        this.dateOfBirth = data[3];
        this.securityQuestion = data[4];
        this.securityAnswer = data[5];
        ArrayKeeper.getData().add(this);
    }

    public ArrayList<Complaint> getComplaints(){
        return complaints;
    }

    public static ArrayList<Species> getSpecies(){
        return species;
    }

    public String getSecurityAnswer() {
        return securityAnswer;
    }

    public void setSecurityAnswer(String securityAnswer) {
        this.securityAnswer = securityAnswer;
    }

    public void setSecurityQuestion(String securityQuestion){
        this.securityQuestion = securityQuestion;
    }

    public String getSecurityQuestion() {
        return securityQuestion;
    }

    public void setUserName(String name) {
        this.username = name;
    }

    public String getUsername() {
        return username;
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

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
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

    public ArrayList<Appointment> getAppointments(){
        return appointments;
    }

    public void addAppointment(Appointment appointment){
        this.appointments.add(appointment);
    }
}

