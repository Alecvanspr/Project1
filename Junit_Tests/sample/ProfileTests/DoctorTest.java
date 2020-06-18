package sample.ProfileTests;

import org.junit.Test;
import sample.MedicalSection.Doctor;
import sample.MedicalSection.Specialty;
import sample.inlogScreen.PersonalData;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class  DoctorTest {
    String[] marioData = {"mario"};
    PersonalData personalData = new PersonalData(marioData);
    ArrayList<Specialty> specialties = new ArrayList<>();
    Specialty specialty1 = new Specialty("Eyes");
    Doctor doctor = new Doctor(marioData,specialties);
    public void makeDocter(){
        specialties.add(specialty1);
    }
    @Test
    public void testGetDocter1(){
        makeDocter();

    }
}
