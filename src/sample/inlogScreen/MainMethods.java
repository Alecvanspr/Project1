package sample.inlogScreen;

import sample.ArrayKeeper;
import sample.MedicalSection.Doctor;
import sample.MedicalSection.Specialty;

import java.util.ArrayList;

public class MainMethods {
    private static boolean delettisHappened = false;
    ArrayKeeper arraykeeper = new ArrayKeeper();
    public boolean dataCheck(String password, String username){
        boolean ret = false;
        int s = 0;
        for(int i = 0;i<ArrayKeeper.getData().size();i++){
            if(ArrayKeeper.getData().get(i).getUsername().equals(username)){
                if(ArrayKeeper.getData().get(i).getPassword().equals(password)){
                    ret = true;
                    arraykeeper.setCurrentUser(i);
                }
            }
        }
        arraykeeper.makeSpecialties();
        return ret;
    }

    public void delettis(){
        //dit is om te testen, dit moet achteraf verwijderd worden.
        if(!delettisHappened){
            String[] adminInfo = {"admin", "admin", "Yesterday", "Bruh", "You have to insert your username first"};
            arraykeeper.signUpData(adminInfo);
            PersonalData admin = new PersonalData();
            admin.setUserName("admin");
            admin.setPassword("admin");
            admin.setDateOfBirth("admin");
            admin.setSecurityQuestion("Oh yeah, Mister crabs");
            admin.setSecurityAnswer("dab");

            Specialty db = new Specialty("Diabetes");
            Specialty ey = new Specialty("Eyes");
            ArrayList<Specialty> specialtiesDoc1 = new ArrayList<Specialty>();
            specialtiesDoc1.add(db);
            specialtiesDoc1.add(ey);
            String[] marioInfo = {"mario", "Dr. Mario", "issa me", "Back then", "where is the princess", "with bowser"};
            Doctor.makeDoctor(marioInfo, specialtiesDoc1);

            Specialty ear = new Specialty("Ears");
            Specialty skin = new Specialty("Skin");
            ArrayList<Specialty> specialtiesDoc2 = new ArrayList<>();
            specialtiesDoc2.add(ear);
            specialtiesDoc2.add(skin);
            String[] luigiInfo = {"luigi", "Dr. Luigi", "konk", "back then", "WHY????", "because"};
            Doctor.makeDoctor(luigiInfo, specialtiesDoc2);
            delettisHappened = true;
        }
    }
}
