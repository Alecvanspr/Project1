package sample;

import java.util.ArrayList;

public class ArrayKeeper {
    public static ArrayList<PersonalData> Data = new ArrayList<>();
    private static int currentUser;

    public void SignUpData(String name,String password,String birth, String security,String securityQ){
        PersonalData personalData = new PersonalData();
        personalData.setName(name);
        personalData.setPassword(password);
        personalData.setBirthDate(birth);
        personalData.setSecurtityQuestion(securityQ);
        personalData.setSecurityAnswer(security);
        Data.add(personalData);
        currentUser++;
    }
    public void changePassword(int user,String password){
        Data.get(user).setPassword(password);
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