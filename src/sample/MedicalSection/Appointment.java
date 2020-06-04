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


    public Appointment(Doctor doctor, LocalDate date, String time){
        this.userInt = ArrayKeeper.getCurrentUser();
        this.appointmentDate = date;
        this.appointmentTime = time;
        this.doctor = doctor;
        this.user = ArrayKeeper.Data.get(userInt).getName();
        doctor.getAppointments().add(this);
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
    public void setAppointmentTime(String time){
        this.appointmentTime = time;
    }
    public void setAppointmentDate(LocalDate date){
        this.appointmentDate = date;
    }
    public void setNotes(String notes){
        this.notes = notes;
    }
    public Doctor getDoctor(){
        return doctor;
    }
}



