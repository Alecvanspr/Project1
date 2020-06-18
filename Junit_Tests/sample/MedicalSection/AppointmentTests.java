package sample.MedicalSection;

import org.junit.Assert;
import org.junit.Test;
import sample.inlogScreen.PersonalData;

import java.time.LocalDate;
import java.util.ArrayList;

public class AppointmentTests { //todo deze tests mooier maken enzo
    Specialty specialty1 = new Specialty("Eyes");
    Specialty specialty2 = new Specialty("Diabetus");
    ArrayList<Specialty> specialties = new ArrayList<>();
    String object[] = {"Dr. Mario","Dr.Mario","m","m","m","m","m","m"};
    Doctor doctor = new Doctor(object,specialties);
    LocalDate localDate = LocalDate.now();
    PersonalData patient = new PersonalData();
    String string[] ={"13:00","Diabetus"};
    Appointment appointment = new Appointment(doctor,localDate,string[0],patient,string[1]);

    @Test
    public void testDing(){
        specialties.add(specialty1);
        System.out.println(appointment.getDoctor().getName());
        Assert.assertTrue("Dr.Mario".equals(appointment.getDoctor().getName()));
    }
    @Test
    public void testEdit(){
        String string2[] ={"14:00", "Diabetus"};
        appointment.EditAppointment(string2[0],localDate, string2[1], doctor);
        Assert.assertTrue("14:00".equals(appointment.getAppointmentTime()));
    }
    @Test
    public void testSpecialty(){
        doctor.addSpecialties(specialty1);
        doctor.addSpecialties(specialty2);
        Assert.assertFalse(specialty1.getName().equalsIgnoreCase(doctor.getSpecialties().get(1).getName()));
        Assert.assertTrue(specialty2.getName().equalsIgnoreCase(doctor.getSpecialties().get(1).getName()));
    }
}
