package sample.inlogScreen;

import sample.MedicalSection.Appointment;
import sample.ArrayKeeper;
import sample.MedicalSection.Doctor;
import sample.MedicalSection.Specialty;
import sample.livestock.Animal;
import sample.livestock.Species;

import java.util.ArrayList;

public class PersonalData {
    ArrayList<Animal> animals= new ArrayList<>();
    ArrayKeeper arrayKeeper = new ArrayKeeper();
    static ArrayList<Species> species= new ArrayList<>();
    private ArrayList<Appointment> appointments = new ArrayList<>();
    private String Usernamename;
    private String name = "Not yet defined";
    private String password;
    private String birthDate;
    private String phoneNumber = "Not yet defined";
    private String email = "Not yet defined";
    private String gender = "Not yet defined";
    private String securtityQuestion;
    private String securityAnswer;
    private Boolean isDocter = false;
    private Doctor doctor;

    public PersonalData(){
    }

    public Boolean getIsDocter(){
        return this.isDocter;
    }

    public void setIsDocter(Boolean isDocter){
        this.isDocter = isDocter;
    }

    public void makeDoctor(String name, ArrayList<Specialty> specialties) {
        Doctor doctor = new Doctor(name, ArrayKeeper.getCurrentUser(), specialties);
        this.doctor = doctor;
        setIsDocter(true);
    }

    public Doctor getDoctor(){
        return this.doctor;
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

    public ArrayList<Appointment> getAppointments(){
        return appointments;
    }

    public void addAppointment(Appointment appointment){
        this.appointments.add(appointment);}
}

