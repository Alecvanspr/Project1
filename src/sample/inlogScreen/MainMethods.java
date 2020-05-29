package sample.inlogScreen;

import sample.ArrayKeeper;
import sample.MedicalSection.Specialty;

import java.util.ArrayList;

public class MainMethods {
    ArrayKeeper arraykeeper = new ArrayKeeper();
    public boolean gegevensCheck(String password,String username){
        boolean ret = false;
        int s = 0;
        for(int i = 0;i<arraykeeper.Data.size();i++){
            if(ArrayKeeper.Data.get(i).getUsername().equals(username)){
                if(arraykeeper.Data.get(i).getPassword().equals(password)){
                    ret = true;
                    s = i;
                }
            }
        }
        arraykeeper.setCurrentUser(s);
        return ret;
    }
    public void delettis(){
        //dit is om te testen, dit moet achteraf verwijderd worden.
        arraykeeper.SignUpData("Admin","Admin","Yesterday","Bruh","You have to insert your username first", false);
        PersonalData Admin = new PersonalData();
        Admin.setUserName("admin");
        Admin.setPassword("admin");
        Admin.setBirthDate("admin");
        Admin.setSecurtityQuestion("Oh yeah, Mister crabs");
        Admin.setSecurityAnswer("dab");
        arraykeeper.Data.add(Admin);

        arraykeeper.SignUpData("dr","dr","dr","dr","dr",true);
        PersonalData DoctorMario = new PersonalData();
        DoctorMario.setUserName("mario");
        DoctorMario.setPassword("mario");
        DoctorMario.setBirthDate("mario");
        DoctorMario.setSecurtityQuestion("hahahaha");
        DoctorMario.setSecurityAnswer("mario");
        Specialty db = new Specialty("Diabetes");
        Specialty ey = new Specialty("Eyes");
        ArrayList<Specialty> specialtiesDoc1 = new ArrayList<Specialty>();
        specialtiesDoc1.add(db);
        specialtiesDoc1.add(ey);
        DoctorMario.makeDoctor("Dr. Mario", specialtiesDoc1);
        arraykeeper.Data.add(DoctorMario);

        arraykeeper.SignUpData("luigi","luigi","luigi","luigi","luigi",true);
        PersonalData DoctorLuigi = new PersonalData();
        DoctorLuigi.setUserName("luigi");
        DoctorLuigi.setPassword("luigi");
        DoctorLuigi.setBirthDate("luigi");
        DoctorLuigi.setSecurtityQuestion("luigi");
        DoctorLuigi.setSecurityAnswer("luigi");
        Specialty ear = new Specialty("Ears");
        Specialty skin = new Specialty("Skin");
        ArrayList<Specialty> specialtiesDoc2 = new ArrayList<>();
        specialtiesDoc2.add(ear);
        specialtiesDoc2.add(skin);
        DoctorLuigi.makeDoctor("Dr. Luigi", specialtiesDoc2);
        arraykeeper.Data.add(DoctorLuigi);
    }
}
