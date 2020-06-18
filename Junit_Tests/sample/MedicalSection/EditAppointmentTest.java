package sample.MedicalSection;
import org.junit.Assert;
import org.junit.Test;
import sample.ArrayKeeper;
import sample.inlogScreen.PersonalData;

import java.time.LocalDate;
import java.util.ArrayList;

public class EditAppointmentTest {
    String object[] = {"Dr.Mario","Dr.Mario","m","m","m","m","m","m"};
    String object2[] = {"Dr.Luigi","Dr.Luigi","m","m","m","m","m","m"};

    PersonalData patient = new PersonalData();
    Specialty specialty1 = new Specialty("Diabetes");
    Specialty specialty2 = new Specialty("Eyes");
    Specialty specialty3 = new Specialty("Ears");
    Specialty specialty4 = new Specialty("Skin");
    Specialty specialty5 = new Specialty("General");
    ArrayList<Specialty> specialties1 = new ArrayList<>();
    ArrayList<Specialty> specialties2 = new ArrayList<>();
    ArrayKeeper arrayKeeper = new ArrayKeeper();
    public Doctor makeDoctor1(){
        specialties1.add(specialty1);
        specialties1.add(specialty2);
        specialties1.add(specialty5);
        arrayKeeper.getSpecialtiesArrayList().add(specialty1);
        arrayKeeper.getSpecialtiesArrayList().add(specialty2);
        arrayKeeper.getSpecialtiesArrayList().add(specialty3);
        arrayKeeper.getSpecialtiesArrayList().add(specialty4);
        arrayKeeper.getSpecialtiesArrayList().add(specialty5);

        Doctor doctorMario = new Doctor(object,specialties1);
        return doctorMario;
    }
    public Doctor makeDoctor2(){
        specialties2.add(specialty3);
        specialties2.add(specialty4);
        specialties2.add(specialty5);
        Doctor doctorLuigi = new Doctor(object2,specialties2);
        return doctorLuigi;

    }
    public Appointment makeAppointment(Doctor doctorMario){
        Appointment appointment = new Appointment(doctorMario, LocalDate.now(),"9:00", patient, "Diabetes");
        return appointment;
    }
    @Test       //test of je de tijd kan veranderen
    public void testEditAppointment1(){
        Appointment appointment = makeAppointment(makeDoctor1());
        String time = "11:00";
        String specialty = "Diabetes";
        LocalDate date = appointment.getAppointmentDate();
        appointment.EditAppointment(time, date, specialty,makeDoctor1());
        Assert.assertTrue(appointment.getAppointmentTime().equalsIgnoreCase(time));
    }
    @Test       //test of je de tijd kan veranderen
    public void testEditAppointment2(){
        Appointment appointment = makeAppointment(makeDoctor1());
        String time = "13:00";
        String specialty = "Diabetes";
        LocalDate date = appointment.getAppointmentDate();
        appointment.EditAppointment(time, date, specialty,makeDoctor1());
        Assert.assertTrue(appointment.getAppointmentTime().equalsIgnoreCase(time));
    }
    @Test       //test of je de datum kan veranderen
    public void testEditAppointment3(){
        Appointment appointment = makeAppointment(makeDoctor1());
        String time = "09:00";
        String specialty = "Diabetes";
        LocalDate date = appointment.getAppointmentDate().plusDays(1);
        appointment.EditAppointment(time, date, specialty,makeDoctor1());
        Assert.assertTrue(appointment.getAppointmentDate().equals(date));
    }
    @Test       //test of je de datum en tijd kan veranderen
    public void testEditAppointment4(){
        Appointment appointment = makeAppointment(makeDoctor1());
        String time = "12:00";
        String specialty = "Diabetes";
        LocalDate date = appointment.getAppointmentDate().plusDays(1);
        appointment.EditAppointment(time, date, specialty,makeDoctor1());
        Assert.assertTrue(appointment.getAppointmentTime().equalsIgnoreCase(time));
        Assert.assertTrue(appointment.getAppointmentDate().equals(date));
    }
    @Test       //test of je de datum en tijd kan veranderen
    public void testEditAppointment5(){
        Appointment appointment = makeAppointment(makeDoctor1());
        String time = "14:00";
        String specialty = "Diabetes";
        LocalDate date = appointment.getAppointmentDate().plusDays(1);
        appointment.EditAppointment(time, date, specialty,makeDoctor1());
        Assert.assertTrue(appointment.getAppointmentTime().equalsIgnoreCase(time));
        Assert.assertTrue(appointment.getAppointmentDate().equals(date));
    }
    @Test       //test of je de specialty kan veranderen
    public void testEditAppointment6(){
        Appointment appointment = makeAppointment(makeDoctor1());
        String time = "09:00";
        String specialty = "Eyes";
        LocalDate date = appointment.getAppointmentDate();
        appointment.EditAppointment(time, date, specialty,makeDoctor1());
        Assert.assertTrue(appointment.getSpecialty().getName().equalsIgnoreCase(specialty));
    }
    @Test       //Test specialty + tijd
    public void testEditAppointment7(){
        Appointment appointment = makeAppointment(makeDoctor1());
        String time = "11:00";
        String specialty = "Eyes";
        LocalDate date = appointment.getAppointmentDate();
        appointment.EditAppointment(time, date, specialty,makeDoctor1());
        Assert.assertTrue(appointment.getSpecialty().getName().equalsIgnoreCase(specialty));
        Assert.assertTrue(appointment.getAppointmentTime().equalsIgnoreCase(time));
    }
    @Test       //test specialty + tijd + datum
    public void testEditAppointment8(){
        Appointment appointment = makeAppointment(makeDoctor1());
        String time = "09:00";
        String specialty = "Eyes";
        LocalDate date = appointment.getAppointmentDate().plusDays(1);
        appointment.EditAppointment(time, date, specialty,makeDoctor1());
        Assert.assertTrue(appointment.getSpecialty().getName().equalsIgnoreCase(specialty));
        Assert.assertTrue(appointment.getAppointmentTime().equals(time));
        Assert.assertTrue(appointment.getAppointmentDate().equals(date));
    }
    @Test       //test dokter
    public void testEditAppointment9(){
        Appointment appointment = makeAppointment(makeDoctor1());
        Doctor doctor = makeDoctor2();
        String time = "09:00";
        String specialty = "Diabetes";
        LocalDate date = appointment.getAppointmentDate();
        appointment.EditAppointment(time, date, specialty,doctor);
        Assert.assertTrue(appointment.getDoctor().getName().equalsIgnoreCase(doctor.getName()));
    }
    @Test       //test dokter + specialty
    public void testEditAppointment10(){
        Appointment appointment = makeAppointment(makeDoctor1());
        Doctor doctor = makeDoctor2();
        String time = "09:00";
        String specialty = "Eyes";
        LocalDate date = appointment.getAppointmentDate();
        appointment.EditAppointment(time, date, specialty,doctor);
        Assert.assertTrue(appointment.getDoctor().getName().equalsIgnoreCase(doctor.getName()));
        Assert.assertTrue(appointment.getSpecialty().getName().equalsIgnoreCase(specialty));
    }
    @Test       //test dokter+specialty+Date
    public void testEditAppointment11(){
        Appointment appointment = makeAppointment(makeDoctor1());
        Doctor doctor = makeDoctor2();
        String time = "09:00";
        String specialty = "Eyes";
        LocalDate date = appointment.getAppointmentDate().plusDays(1);
        appointment.EditAppointment(time, date, specialty,doctor);
        Assert.assertTrue(appointment.getDoctor().getName().equalsIgnoreCase(doctor.getName()));
        Assert.assertTrue(appointment.getSpecialty().getName().equalsIgnoreCase(specialty));
        Assert.assertTrue(appointment.getAppointmentDate().equals(date));
    }
    @Test       //test dokter + sspecialty + date + tijd
    public void testEditAppointment12(){
        Appointment appointment = makeAppointment(makeDoctor1());
        Doctor doctor = makeDoctor2();
        String time = "13:00";
        String specialty = "Eyes";
        LocalDate date = appointment.getAppointmentDate().plusDays(1);
        appointment.EditAppointment(time, date, specialty,doctor);
        Assert.assertTrue(appointment.getDoctor().getName().equalsIgnoreCase(doctor.getName()));
        Assert.assertTrue(appointment.getSpecialty().getName().equalsIgnoreCase(specialty));
        Assert.assertTrue(appointment.getAppointmentDate().equals(date));
        Assert.assertTrue(appointment.getAppointmentTime().equalsIgnoreCase(time));
    }
}
