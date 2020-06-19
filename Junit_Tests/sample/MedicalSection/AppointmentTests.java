package sample.MedicalSection;

import org.junit.Assert;
import org.junit.Test;
import sample.inlogScreen.PersonalData;

import java.time.LocalDate;
import java.util.ArrayList;

public class AppointmentTests {
    ArrayList<Specialty> specialties = new ArrayList<>();
    Doctor doctor = new Doctor("test","test","test","k","k","k",specialties);
    LocalDate localDate = LocalDate.now();
    PersonalData patient = new PersonalData();
    String timeAndReasonOld[] = {"13:00", "diabetes"};
    Appointment appointment = new Appointment(doctor, localDate, timeAndReasonOld, patient);
    String timeAndReasonNew[] = {"16:00", "eyes"};

    @Test
    public void testEditAppointment(){
        appointment.EditAppointment(doctor, timeAndReasonNew, localDate);
        Assert.assertNotEquals(timeAndReasonOld, timeAndReasonNew);
        Assert.assertTrue(appointment.getAppointmentTime().equals(timeAndReasonNew[0]));
    }
}
