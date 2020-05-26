package sample.MedicalSection;

import sample.ArrayKeeper;

import java.util.Date;

public class Appointment {
    private Date AppointmentDate;
    private String user;
    private int userInt;


    public Appointment(){
        this.userInt = ArrayKeeper.getCurrentUser();

    }
}
