package sample.MedicalSection;

import sample.ArrayKeeper;
import sample.inlogScreen.PersonalData;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;

public class Appointment {
    private LocalDate appointmentDate;
    private String appointmentTime;
    private String user;
    private int userInt;
    private String notes;
    private Doctor doctor;
    private PersonalData patient;
    ArrayKeeper arrayKeeper = new ArrayKeeper();


    public Appointment(Doctor doctor, LocalDate date, String time, PersonalData patient){
        this.userInt = ArrayKeeper.getCurrentUser();
        this.appointmentDate = date;
        this.appointmentTime = time;
        this.doctor = doctor;
        this.user = ArrayKeeper.getData().get(userInt).getName();
        this.patient = patient;

    }
    public LocalDate getAppointmentDate(){
        return appointmentDate;
    }
    public String getAppointmentTime(){
        return appointmentTime;
    }
    public String getUser(){
        return user;
    }
    public int getUserInt(){
        return userInt;
    }
    public String getNotes(){
        return notes;
    }
    public Doctor getDoctor(){
        return doctor;
    }
    public PersonalData getPatient(){
        return patient;
    }
    public void setAppointmentTime(String time){
        this.appointmentTime = time;
    }
    public void setAppointmentDate(LocalDate date){
        this.appointmentDate = date;
    }
    public void setNotes(String notes){
        this.notes = notes;
    }
}



