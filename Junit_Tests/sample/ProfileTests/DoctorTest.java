/*package sample.ProfileTests;

import org.junit.Assert;
import org.junit.Test;
import sample.ArrayKeeper;
import sample.MedicalSection.Doctor;
import sample.MedicalSection.Specialty;
import sample.inlogScreen.PersonalData;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class  DoctorTest {
    ArrayKeeper arrayKeeper = new ArrayKeeper();
    //docter 1
    String[] marioData = {"mario","mario","sick","Sick","sick","sick"};
    //PersonalData personalData = new PersonalData(marioData);
    ArrayList<Specialty> specialties = new ArrayList<>();
    Specialty specialty1 = new Specialty("Eyes");
    Doctor doctor = new Doctor(marioData,specialties);
    //docter 2
    String[] stevenData = {"Strange","Steven Strange","When","yes","no","What"};
    PersonalData stevenDataPersonal = new PersonalData(stevenData);
    ArrayList<Specialty> specialties2 = new ArrayList<>();
    Specialty specialty2 = new Specialty("Eyes");
    Doctor drStrange = new Doctor(stevenData,specialties);

    public void makeDocter(){
        specialties.add(specialty1);
        specialties2.add(specialty2);
    }
    //deze test of hij docter1 kan krijgen
    @Test
    public void testGetDocter1(){
        makeDocter();
        Assert.assertEquals(ArrayKeeper.getDoctorsArrayList().get(0).getName(),"mario");
    }
    @Test
    public void TestGetNameDocter1(){
        Assert.assertEquals(ArrayKeeper.getDoctorsArrayList().get(1).getName(),"Steven Strange");
    }
    @Test
    public void TestGetBirthdayDocter1(){

    }
}*/
