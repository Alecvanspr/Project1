package sample.profileSettings;

import sample.ArrayKeeper;
import sample.inlogScreen.PersonalData;

import static sample.ArrayKeeper.getCurrentUser;

public class EditSettings {
    public void changeUsername(String newUsername){
        if(CheckFilled(newUsername)) {
            PersonalData personalData = new PersonalData();
            personalData = ArrayKeeper.Data.get(getCurrentUser());
            personalData.setUserName(newUsername);
            ArrayKeeper.Data.set(ArrayKeeper.getCurrentUser(), personalData);
        }
    }
    public void  changePassword(String newPassword,String confirmPassword){
        if(CheckFilled(newPassword)) {
            if (newPassword.equals(confirmPassword)) {
                PersonalData personalData = new PersonalData();
                personalData = ArrayKeeper.Data.get(getCurrentUser());
                personalData.setPassword(newPassword);
                ArrayKeeper.Data.set(getCurrentUser(), personalData);
            }
        }
    }
    public void changeName(String name){
        if (CheckFilled(name)) {
            PersonalData personalData = new PersonalData();
            personalData = ArrayKeeper.Data.get(getCurrentUser());
            personalData.setName(name);
            ArrayKeeper.Data.set(getCurrentUser(), personalData);
        }
    }
    public void changeBirthday(String birthday){
        if (CheckFilled(birthday)) {
            PersonalData personalData = new PersonalData();
            personalData = ArrayKeeper.Data.get(getCurrentUser());
            personalData.setBirthDate(birthday);
            ArrayKeeper.Data.set(getCurrentUser(), personalData);
        }
    }
    public void changePhone(String phoneNumber){
        if(CheckFilled(phoneNumber)) {
            PersonalData personalData = new PersonalData();
            personalData = ArrayKeeper.Data.get(getCurrentUser());
            personalData.setPhoneNumber(phoneNumber);
            ArrayKeeper.Data.set(getCurrentUser(), personalData);
        }
    }
    public void changeSecurityAnswer(String answer){
        if(CheckFilled(answer)) {
            PersonalData personalData = new PersonalData();
            personalData = ArrayKeeper.Data.get(getCurrentUser());
            personalData.setSecurityAnswer(answer);
            //personalData.setSecurtityQuestion();
            ArrayKeeper.Data.set(getCurrentUser(), personalData);
        }
    }
    public void changeGender(String gender){
        if(CheckFilled(gender)){
            PersonalData personalData = ArrayKeeper.Data.get(getCurrentUser());
            personalData.setGender(gender);
            ArrayKeeper.Data.set(getCurrentUser(), personalData);
        }
    }
    public boolean CheckFilled(String isempety){
        boolean ret = true;
        if(isempety.equals("")){
            ret = false;
        }
        return  ret;
    }
}
