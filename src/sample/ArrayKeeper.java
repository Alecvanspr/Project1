package sample;

import java.util.ArrayList;

public class ArrayKeeper {
    public static ArrayList<PersonalData> Data = new ArrayList<>();
    private static int currentUser;

    public void SignUpData(String name,String password,String birth, String security){
        PersonalData personalData = new PersonalData();
        personalData.setName(name);
        personalData.setPassword(password);
        personalData.setBirthDate(birth);
        personalData.setSecurityAnswer(security);
        Data.add(personalData);
        currentUser++;
    }

    public ArrayList<PersonalData> getPersonaldata(){
        return Data;
    }
    public void setCurrentUser(int currentUser){
        this.currentUser = currentUser;
    }

    public static int getCurrentUser() {
        return currentUser;
    }
}