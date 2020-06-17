package sample.ProfileTests;

import org.junit.Assert;
import org.junit.Test;
import sample.ArrayKeeper;
import sample.inlogScreen.PersonalData;

public class PersonTest {
    ArrayKeeper arrayKeeper = new ArrayKeeper();
    //String username, String name, String password, String dateOfBirth, String securityQuestion, String securityAnswer

    PersonalData personalData = new PersonalData();
    public void makeArraykeeper(){
        String[] gegevens = {"legend27","Henk de Steen","wachtwoord", "Yesterday", "What you egg?", "Stabs him"};
        String[] gegevens2 = {"Schilder123","Henk de Schilder", "GooiInDeVerf","Vandaag", "Wat is je favorite kleur?", "verf"};
        String[] gegevens3 = {"The_Chin","Karel V van Habsburg","Kin123" ,"Morgen", "Hoe groot is je kin?", "mega"};
        arrayKeeper.SignUpData(gegevens);
        arrayKeeper.SignUpData(gegevens2);
        arrayKeeper.SignUpData(gegevens3);
    }
    @Test
    public void testFirstPerson(){
        makeArraykeeper();
        testUserName(1,"legend27");
        testName(1,"Henk de Steen");
        testPassword(1,"wachtwoord");
        testBirthdate(1,"Yesterday");
        testSecurityQuestion(1,"What you egg?");
        testSecurityAnswer(1,"Stabs him");

    }
    @Test
    public void testSecondPerson(){
        testUserName(2,"Schilder123");
        testName(2,"Henk de Schilder");
        testPassword(2,"GooiInDeVerf");
        testBirthdate(2,"Vandaag");
        testSecurityQuestion(2,"Wat is je favorite kleur?");
        testSecurityAnswer(2,"verf");
    }
    @Test
    public void testLastPerson(){
        makeArraykeeper();
        testUserName(3,"The_Chin");
        testPassword(3,"Kin123");
    }
    public void testName(int place, String expected){
        Assert.assertEquals(ArrayKeeper.getData().get(place).getName(),expected);
    }
    public void testUserName(int place,String expected){
        Assert.assertEquals(ArrayKeeper.getData().get(place).getUsername(),expected);
    }
    public void testPassword(int place, String expected){
        Assert.assertEquals(ArrayKeeper.getData().get(place).getPassword(),expected);
    }
    public void testBirthdate(int place,String expected){
        Assert.assertEquals(ArrayKeeper.getData().get(place).getDateOfBirth(),expected);
    }
    public void testSecurityQuestion(int place, String expected){
        Assert.assertEquals(ArrayKeeper.getData().get(place).getSecurityQuestion(),expected);
    }
    public void testSecurityAnswer(int place, String expected){
        Assert.assertEquals(ArrayKeeper.getData().get(place).getSecurityAnswer(),expected);
    }
}
