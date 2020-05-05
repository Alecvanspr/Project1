package sample;

import java.util.ArrayList;

public class ArrayKeeper {
    public ArrayList<PersonalData> Data = new ArrayList<>();
    private int currentUser;

    public void SignUpData(String name,String password,String birth){
        PersonalData personalData = new PersonalData();
        personalData.setName(name);
        personalData.setPassword(password);
        personalData.setBirthDate(birth);
        Data.add(personalData);
    }

    public ArrayList<PersonalData> getPersonaldata(){
        return Data;
    }
    public void setCurrentUser(int currentUser){
        this.currentUser = currentUser;
    }

    public int getCurrentUser() {
        return currentUser;
    }
}
