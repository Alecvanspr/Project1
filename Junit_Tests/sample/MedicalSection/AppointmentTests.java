package sample.MedicalSection;

import org.junit.Assert;
import org.junit.Test;
import sample.ArrayKeeper;
import sample.inlogScreen.PersonalData;

import java.time.LocalDate;
import java.util.ArrayList;

public class AppointmentTests {
    ArrayKeeper arrayKeeper = new ArrayKeeper();
    Specialty specialty1 = new Specialty("Eyes");
    Specialty specialty2 = new Specialty("Diabetes");
    //mario
    ArrayList<Specialty> marioSpecialties = new ArrayList<>();
    String marioString[] = {"Dr. Mario","Dr.Mario","m","m","m","m","m","m"};
    Doctor doctor = new Doctor(marioString, marioSpecialties);
    LocalDate localDate = LocalDate.now();
    PersonalData patient = new PersonalData();
    String string[] ={"13:00","Diabetes"};
    Appointment appointment = new Appointment(doctor,localDate,string[0],patient,string[1]);
    //StevenStrange
    ArrayList<Specialty> stevenSpecialties = new ArrayList<>();
    String stevenString[] = {"Dr.Strange","Dr.Strange","m","m","m","m","m","m"};
    Doctor stevenDocter = new Doctor(stevenString, stevenSpecialties);
    PersonalData patientSteven = new PersonalData();
    String stevenAppointment2[] ={"9:00","Eyes"};
    Appointment stevenAppointment = new Appointment(stevenDocter,localDate,stevenAppointment2[0],patientSteven,stevenAppointment2[1]);
    public void makeMario(){
        marioSpecialties.add(specialty1);
        arrayKeeper.getSpecialtiesArrayList().add(specialty1);
        arrayKeeper.getSpecialtiesArrayList().add(specialty2);
    }
    public void makeSteven(){
        stevenSpecialties.add(specialty2);
        arrayKeeper.getSpecialtiesArrayList().add(specialty1);
        arrayKeeper.getSpecialtiesArrayList().add(specialty2);
    }

    @Test
    public void testMarioName(){
        makeMario();
        marioSpecialties.add(specialty1);
        Assert.assertTrue("Dr.Mario".equals(appointment.getDoctor().getName()));
    }
    @Test
    public void testStevenName(){
        makeSteven();
        stevenSpecialties.add(specialty2);
        Assert.assertEquals("Dr.Strange", stevenAppointment.getDoctor().getName());
    }
    @Test
    public void testMarioSpecialties1(){
        makeMario();
        marioSpecialties.add(specialty1);
        Assert.assertEquals("Eyes",(appointment.getDoctor().getSpecialties().get(0).getName()));
    }
    @Test
    public void testStevenSpecialties1(){
        makeSteven();
        stevenSpecialties.add(specialty2);
        Assert.assertEquals("Diabetes", stevenAppointment.getDoctor().getSpecialties().get(0).getName());
    }
    @Test
    public void testMarioSpecialties2(){
        makeMario();
        marioSpecialties.add(specialty2);
        Assert.assertEquals("Diabetes",(appointment.getDoctor().getSpecialties().get(1).getName()));
    }
    @Test
    public void testStevenSpecialties2(){
        makeSteven();
        stevenSpecialties.add(specialty1);
        Assert.assertEquals("Eyes", stevenAppointment.getDoctor().getSpecialties().get(1).getName());
    }
    @Test
    public void testMarioAppointmentTime(){
        makeMario();
        Assert.assertEquals("13:00",appointment.getAppointmentTime());
    }
    @Test
    public void testStevenAppointmentTime(){
        makeSteven();
        Assert.assertEquals("9:00",stevenAppointment.getAppointmentTime());
    }
    @Test
    public void testMarioSpecialtyReason(){ //dezelfde error door null
        makeMario();
        marioSpecialties.add(specialty2);
        Assert.assertEquals("Diabetes",appointment.getSpecialty().getName());
    }

    @Test
    public void testStevenSpecialtyReason() {
        makeSteven();
        stevenSpecialties.add(specialty1);
        Assert.assertEquals("Eyes", stevenAppointment.getSpecialty().getName());
    }
}
