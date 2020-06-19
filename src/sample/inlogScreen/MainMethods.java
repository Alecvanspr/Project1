package sample.inlogScreen;

import sample.ArrayKeeper;
import sample.MedicalSection.Doctor;
import sample.MedicalSection.Specialty;

import javax.print.Doc;
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
        if(!delettisHappened) {
            String[] adminData = {"admin","admin", "admin", "Yesterday", "Bruh", "You have to insert your username first"};
            arraykeeper.SignUpData(adminData);
            PersonalData admin = new PersonalData();
            admin.setUserName("admin");
            admin.setPassword("admin");
            admin.setDateOfBirth("admin");
            admin.setSecurityQuestion("Oh yeah, Mister crabs");
            admin.setSecurityAnswer("dab");

            String[] doctorMarioData = {"dr", "dr" ,"dr", "dr", "dr", "dr"};
            arraykeeper.SignUpData(doctorMarioData);
            String[] doctorMario = {"mario","mario","mario","Arg Arg Arg Arg","mario","dr Mario"};
            Specialty db = new Specialty("Diabetes");
            Specialty ey = new Specialty("Eyes");
            ArrayList<Specialty> specialtiesDoc1 = new ArrayList<Specialty>();
            specialtiesDoc1.add(db);
            specialtiesDoc1.add(ey);
            Doctor DoctorMario = new Doctor(doctorMario,specialtiesDoc1);

            Specialty ear = new Specialty("Ears");
            Specialty skin = new Specialty("Skin");
            ArrayList<Specialty> specialtiesDoc2 = new ArrayList<>();
            specialtiesDoc2.add(ear);
            specialtiesDoc2.add(skin);
            //name name password securityQuestionsecurityAnswer, thing
            String[] luigiData= {"luigi", "luigi", "konk", "back then", "WHY????", "because"};
            Doctor doctorLuigi = new Doctor(luigiData,specialtiesDoc2);
            delettisHappened = true;
        }
    }
}
