package sample.MedicalSection;

import sample.ArrayKeeper;
import sample.inlogScreen.PersonalData;

import java.time.LocalDate;

public class Appointment {
    private LocalDate appointmentDate;
    private String appointmentTime;
    private String user;
    private String notes;
    private Doctor doctor;
    private PersonalData patient;
    private Specialty specialty;
    ArrayKeeper arrayKeeper = new ArrayKeeper();


    public Appointment(Doctor doctor, LocalDate date, String time, PersonalData patient, String specialty){
        this.appointmentDate = date;
        this.appointmentTime = time;
        this.doctor = doctor;
        this.user = ArrayKeeper.getPersonalData(ArrayKeeper.getCurrentUser()).getName();
        this.patient = patient;
        this.specialty = getSpecialtyClass(specialty);
        if(!doctor.checkHasPatient(ArrayKeeper.getPersonalData(ArrayKeeper.getCurrentUser()))){
            doctor.getPatients().add(ArrayKeeper.getPersonalData(ArrayKeeper.getCurrentUser()));
        }
    }

    public Specialty getSpecialtyClass(String specialtyString){ //todo fix dit
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