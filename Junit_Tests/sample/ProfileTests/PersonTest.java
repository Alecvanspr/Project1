package sample.ProfileTests;

import org.junit.Assert;
import org.junit.Test;
import sample.ArrayKeeper;
import sample.inlogScreen.PersonalData;

public class PersonTest {
    ArrayKeeper arrayKeeper = new ArrayKeeper();
    int place = 1;
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
        testUserName(place,"legend27");
        testName(place,"Henk de Steen");
        testPassword(place,"wachtwoord");
        testBirthdate(place,"Yesterday");
        testSecurityQuestion(place,"What you egg?");
        testSecurityAnswer(place,"Stabs him");
    }
    @Test
    public void testSecondPerson(){
        place++;
        //testUserName(2,"Schilder123");
        testName(place,"Henk de Schilder");
        testPassword(place,"GooiInDeVerf");
        testBirthdate(place,"Vandaag");
        testSecurityQuestion(place,"Wat is je favorite kleur?");
        testSecurityAnswer(place,"verf");
    }
    @Test
    public void testLastPerson(){ //todo.
        place++;
        printNamesData();
        testUserName(place,"The_Chin");
        testName(place,"Karel V van Habsburg");
        testPassword(place,"Kin123");
        testBirthdate(place,"Morgen");
        testSecurityQuestion(place,"Hoe groot is je kin?");
        testSecurityAnswer(place,"mega");
    }
    public void printNamesData(){
        for(int i=0; i<ArrayKeeper.getData().size();i++){
            System.out.println(ArrayKeeper.getData().get(i).getName());
        }
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
