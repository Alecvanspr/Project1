package sample.MedicalSection;
import org.junit.Assert;
import org.junit.Test;
import sample.inlogScreen.PersonalData;

import java.time.LocalDate;
import java.util.ArrayList;

public class EditAppointmentTest {
    String object[] = {"Dr. Mario","Dr.Mario","m","m","m","m","m","m"};
    PersonalData patient = new PersonalData();
    Specialty specialty1 = new Specialty("Diabetes");
    Specialty specialty2 = new Specialty("Eyes");
    Specialty specialty3 = new Specialty("Ears");
    Specialty specialty4 = new Specialty("Skin");
    Specialty specialty5 = new Specialty("General");
    ArrayList<Specialty> specialties1 = new ArrayList<>();
    ArrayList<Specialty> specialties2 = new ArrayList<>();
    public Doctor makeDoctors(){
        specialties1.add(specialty1);
        specialties1.add(specialty2);
        specialties1.add(specialty5);
        Doctor doctorMario = new Doctor(object,specialties1);
        return doctorMario;
    }
    public Appointment makeAppointment(Doctor doctorMario){
        Appointment appointment = new Appointment(doctorMario, LocalDate.now(),"9:00", patient, "Diabetes");
        return appointment;
    }
    @Test
    public void testEditAppointment1(){
        Appointment appointment = makeAppointment(makeDoctors());
        ArrayList<Specialty> specialties = new ArrayList<>();
        String time = "11:00";
        String specialty = "Diabetes";
        LocalDate date = appointment.getAppointmentDate();
        appointment.EditAppointment(time, date, specialty,makeDoctors());
        Assert.assertTrue(appointment.getAppointmentTime().equalsIgnoreCase(time));
    }
    @Test
    public void testEditAppointment2(){
        Appointment appointment = makeAppointment(makeDoctors());
        ArrayList<Specialty> specialties = new ArrayList<>();
        String time = "13:00";
        String specialty = "Diabetes";
        LocalDate date = appointment.getAppointmentDate();
        appointment.EditAppointment(time, date, specialty,makeDoctors());
        Assert.assertTrue(appointment.getAppointmentTime().equalsIgnoreCase(time));
    }
    @Test
    public void testEditAppointment3(){
        Appointment appointment = makeAppointment(makeDoctors());
        ArrayList<Specialty> specialties = new ArrayList<>();
        String time = "09:00";
        String specialty = "Diabetes";
        LocalDate date = appointment.getAppointmentDate().plusDays(1);
        appointment.EditAppointment(time, date, specialty,makeDoctors());
        Assert.assertTrue(appointment.getAppointmentDate().equals(date));
    }
    @Test
    public void testEditAppointment4(){
        Appointment appointment = makeAppointment(makeDoctors());
        ArrayList<Specialty> specialties = new ArrayList<>();
        String time = "12:00";
        String specialty = "Diabetes";
        LocalDate date = appointment.getAppointmentDate().plusDays(1);
        appointment.EditAppointment(time, date, specialty,makeDoctors());
        Assert.assertTrue(appointment.getAppointmentTime().equalsIgnoreCase(time));
        Assert.assertTrue(appointment.getAppointmentDate().equals(date));
    }
    @Test
    public void testEditAppointment5(){
        Appointment appointment = makeAppointment(makeDoctors());
        ArrayList<Specialty> specialties = new ArrayList<>();
        String time = "14:00";
        String specialty = "Diabetes";
        LocalDate date = appointment.getAppointmentDate().plusDays(1);
        appointment.EditAppointment(time, date, specialty,makeDoctors());
        Assert.assertTrue(appointment.getAppointmentTime().equalsIgnoreCase(time));
        Assert.assertTrue(appointment.getAppointmentDate().equals(date));
    }
    @Test
    public void testEditAppointment6(){
        Appointment appointment = makeAppointment(makeDoctors());
        ArrayList<Specialty> specialties = new ArrayList<>();
        String time = "09:00";
        String specialty = "Eyes";
        LocalDate date = appointment.getAppointmentDate();
        appointment.EditAppointment(time, date, specialty,makeDoctors());
        Assert.assertTrue(appointment.getSpecialty().getName().equalsIgnoreCase(specialty));
    }
}
