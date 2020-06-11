package sample.MedicalSection;

import org.junit.Assert;
import org.junit.Test;
import sample.inlogScreen.PersonalData;

import java.time.LocalDate;
import java.util.ArrayList;

public class AppointmentTests {
    Specialty specialty1 = new Specialty("Eyes");
    Specialty specialty2 = new Specialty("Diabetus");
    ArrayList<Specialty> specialties = new ArrayList<>();
    Doctor doctor = new Doctor("Dr. Mario",0,specialties);
    LocalDate localDate = LocalDate.now();
    PersonalData patient = new PersonalData();
    Appointment appointment = new Appointment(doctor,localDate,"13:00",patient,"Diabetus");

    @Test
    public void testDing(){
        specialties.add(specialty1);
        Assert.assertTrue("Dr.Mario".equals(appointment.getDoctor().getDoctor().getName()));
    }
}
