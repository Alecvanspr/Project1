package sample.ProfileTests;

import org.junit.Assert;
import org.junit.Test;
import sample.ArrayKeeper;
import sample.MedicalSection.Doctor;
import sample.MedicalSection.Specialty;
import sample.inlogScreen.PersonalData;

import java.util.ArrayList;

public class  DoctorTest {
    ArrayKeeper arrayKeeper = new ArrayKeeper();
    //doctor 1
    String[] marioData = {"mario","Dr. Mario","sick","Sick","sick","sick"};
    //PersonalData personalData = new PersonalData(marioData);
    ArrayList<Specialty> specialties = new ArrayList<>();
    Specialty specialty1 = new Specialty("Eyes");
    Doctor doctor = new Doctor(marioData,specialties);
    //doctor 2
    String[] stevenData = {"Strange","Steven Strange","When","yes","no","What"};
    PersonalData stevenDataPersonal = new PersonalData(stevenData);
    ArrayList<Specialty> specialties2 = new ArrayList<>();
    Specialty specialty2 = new Specialty("Eyes");
    Doctor drStrange = new Doctor(stevenData,specialties);

    public void makeDoctor(){
        specialties.add(specialty1);
        specialties2.add(specialty2);
    }

    //deze test of hij doctor1 kan krijgen
    @Test
    public void testGetDoctor1(){
        makeDoctor();
        Assert.assertEquals(ArrayKeeper.getDoctorsArrayList().get(0).getName(),"Dr. Mario");
    }

    @Test
    public void testGetNameDoctor1(){
        Assert.assertEquals(ArrayKeeper.getDoctorsArrayList().get(1).getName(),"Steven Strange");
    }

    //Deze test is om te kijken of een dokter wel daadwerkelijk als dokter wordt aangemaakt
    @Test
    public void testIsDoctor(){
        Assert.assertTrue(doctor instanceof Doctor);
    }

    //In deze test wordt gekeken of de specialties wel goed worden opgeslagen
    @Test
    public void testSpecialties(){
        doctor.getSpecialties().add(specialty1);
        Assert.assertTrue(doctor.getSpecialties().get(0).equals(specialty1));
        doctor.getSpecialties().add(specialty2);
        Assert.assertTrue(doctor.getSpecialties().get(0).equals(specialty1) && doctor.getSpecialties().get(1).equals(specialty2));
        doctor.getSpecialties().remove(specialty1);
        Assert.assertTrue(doctor.getSpecialties().get(0).equals(specialty2));
    }

    @Test
    public void testPatients(){
        Assert.assertTrue(doctor.getPatients().size() == 0);
        Assert.assertFalse(doctor.checkHasPatient(stevenDataPersonal));
        doctor.getPatients().add(stevenDataPersonal);
        Assert.assertTrue(doctor.getPatients().get(0).equals(stevenDataPersonal) && doctor.getPatients().size() == 1);
        if(!doctor.checkHasPatient(stevenDataPersonal)){
            doctor.getPatients().add(stevenDataPersonal);
        }
        Assert.assertTrue(doctor.getPatients().get(0).equals(stevenDataPersonal) && doctor.getPatients().size() == 1);
    }
}
