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
    private Specialty specialty;
    ArrayKeeper arrayKeeper = new ArrayKeeper();

// String time,String specialty
    public Appointment(Doctor doctor,LocalDate date, PersonalData patient, String object[]){
        this.userInt = ArrayKeeper.getCurrentUser();
        this.appointmentDate = date;
        this.appointmentTime = object[0];
        this.doctor = doctor;
        this.user = ArrayKeeper.getData().get(userInt).getName();
        this.patient = patient;
        this.specialty = getSpecialtyClass(object[1]);
    }
    public Specialty getSpecialtyClass(String specialtyString){
        for (int i = 0; i < arrayKeeper.getSpecialtiesArrayList().size(); i++){
            if(arrayKeeper.getSpecialtiesArrayList().get(i).getName().equalsIgnoreCase(specialtyString)){
                return arrayKeeper.getSpecialtiesArrayList().get(i);
            }
        }
        return null;
    }
    public void setSpecialty(String specialty){
        this.specialty = getSpecialtyClass(specialty);
    }
    public Specialty getSpecialty(){
        return this.specialty;
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
    public void setDoctor(Doctor doctor){
        this.doctor = doctor;
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
    public void setNotes(String notes) {
        this.notes = notes;
    }
    public void EditAppointment(String time, LocalDate date, String specialty, Doctor doctor){
        setAppointmentTime(time);
        setAppointmentDate(date);
        setSpecialty(specialty);
        setDoctor(doctor);
    }
}



