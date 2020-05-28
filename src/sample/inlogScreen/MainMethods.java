package sample.inlogScreen;

import sample.ArrayKeeper;

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
    }
}
