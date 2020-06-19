package sample.MedicalSection;

import sample.inlogScreen.PersonalData;

import java.time.LocalDate;

public class PastAppointment extends Appointment{
    public PastAppointment(Doctor doctor, LocalDate date, String time, PersonalData patient, String specialty) {
        super(doctor, date, time, patient, specialty);
    }
}
