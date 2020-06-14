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
    String object[] = {"Dr. Mario","Dr.Mario","m","m","m","m","m","m"};
    Doctor doctor = new Doctor(object,specialties);
    LocalDate localDate = LocalDate.now();
    PersonalData patient = new PersonalData();
    String string[] ={"13:00","diabetus"};
    Appointment appointment = new Appointment(doctor,localDate,string[0],patient,string[1]);

    @Test
    public void testDing(){
        specialties.add(specialty1);
        System.out.println(appointment.getDoctor().getName());
        Assert.assertTrue("Dr.Mario".equals(appointment.getDoctor().getName()));
    }
}
