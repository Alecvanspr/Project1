package sample.MedicalSection;

import sample.inlogScreen.PersonalData;

import java.time.LocalDate;

public class PastAppointment extends Appointment { //todo achteraf verwijderen als je dit niet gebruikt luie zak.
    private String notes;
    public PastAppointment(Doctor doctor, LocalDate date, String time, PersonalData patient, String specialty) {
        super(doctor, date, time, patient, specialty);
    }
    public String getNotes(){
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
}
