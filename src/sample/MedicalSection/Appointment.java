package sample.MedicalSection;

import sample.ArrayKeeper;
import sample.inlogScreen.PersonalData;

import java.sql.Time;
import java.util.Date;

public class Appointment {
    private Date appointmentDate;
    private Time appointmentTime;
    private String user;
    private int userInt;
    private String notes;


    public Appointment(Date date){
        this.userInt = ArrayKeeper.getCurrentUser();
        this.appointmentDate = date;
        this.user = ArrayKeeper.Data.get(userInt).getName();
    }
    public Date getAppointmentDate(){
        return this.appointmentDate;
    }
    public Time getAppointmentTime(){
        return this.appointmentTime;
    }
    public String getUser(){
        return this.user;
    }
    public int getUserInt(){
        return this.userInt;
    }
    public String getNotes(){
        return this.notes;
    }
    public void setAppointmentTime(Time time){
        this.appointmentTime = time;
    }
    public void setAppointmentDate(Date date){
        this.appointmentDate = date;
    }
    public void setNotes(String notes){
        this.notes = notes;
    }
}



