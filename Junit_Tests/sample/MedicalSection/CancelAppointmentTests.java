package sample.MedicalSection;
import org.junit.Assert;
import org.junit.Test;
import sample.ArrayKeeper;
import sample.inlogScreen.PersonalData;
import java.time.LocalDate;
import java.util.ArrayList;
import sample.MedicalSection.CancelAppointments;
public class CancelAppointmentTests {
    String object[] = {"Dr.Mario","Dr.Mario","m","m","m","m","m","m"};
    PersonalData patient = new PersonalData();
    Specialty specialty1 = new Specialty("Diabetes");
    Specialty specialty2 = new Specialty("Eyes");
    Specialty specialty3 = new Specialty("Ears");
    ArrayList<Specialty> specialties1 = new ArrayList<>();
    CancelAppointments cancelAppointments = new CancelAppointments();
    ArrayKeeper arrayKeeper = new ArrayKeeper();
    public Doctor makeDoctor(){
        specialties1.add(specialty1);
        specialties1.add(specialty2);
        specialties1.add(specialty3);
        Doctor doctor = new Doctor(object,specialties1);
        arrayKeeper.addDoctor(doctor);
        return doctor;
    }
    public Appointment makeAppointment(){
        LocalDate date = LocalDate.now();
        String time = "9:00";
        String specialty = "Diabetes";
        Appointment appointment = new Appointment(makeDoctor(),date,time,patient,specialty);
        return appointment;
    }

    @Test
    public void testCancelAppointment(){
        Appointment appointment = makeAppointment();
        ArrayKeeper.getData().get(ArrayKeeper.getCurrentUser()).addAppointment(appointment);
        cancelAppointments.deleteAppointment(appointment.getAppointmentDate() + " " + appointment.getAppointmentTime());
        Assert.assertTrue(ArrayKeeper.getData().get(ArrayKeeper.getCurrentUser()).getAppointments().size()==0);
    }
}
