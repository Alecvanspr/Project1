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
    Object object[] = {"Dr. Mario",0};
    Doctor doctor = new Doctor(object,specialties);
    LocalDate localDate = LocalDate.now();
    PersonalData patient = new PersonalData();
    String string[] ={"13:00","diabetus"};
    Appointment appointment = new Appointment(doctor,localDate,patient,string);

    @Test
    public void testDing(){
        specialties.add(specialty1);
        Assert.assertTrue("Dr.Mario".equals(appointment.getDoctor().getDoctor().getName()));
    }
}
