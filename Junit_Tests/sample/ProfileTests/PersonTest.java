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
        testPassword(1,"wachtwoord");
    }
    @Test
    public void testSecondPerson(){
        makeArraykeeper();
        testUserName(2,"legend27");
        testPassword(2,"wachtwoord");
    }
    @Test
    public void testLastPerson(){
        makeArraykeeper();
        testUserName(3,"legend27");
        testPassword(3,"wachtwoord");
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
    public void testBirthdate(int place,String expected){}
    public void testSecurityQuestion(int place, String expected){}
    public void textSecurityAnswer(int place, String expected){}
}
