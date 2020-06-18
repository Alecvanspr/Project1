package sample.educative;

import org.junit.Assert;
import org.junit.Test;
import sample.educative.read.WordReader;
import sample.educative.read.tenseScreens.IrregularWords.MakeArrayListsText;

public class educativeTests {
    MakeArrayListsText makeArrayListsText = MakeArrayListsText.getInstance();
    @Test
    public void getWordsTest1(){
        Assert.assertEquals("Arose",makeArrayListsText.pastWord.get(0));
    }
    @Test
    public void getWordsTest2(){
        Assert.assertEquals("Wrote",makeArrayListsText.pastWord.get(140));
    }
    @Test
    public void getWordsTest3(){
        Assert.assertEquals("Arise",makeArrayListsText.infinitiveWord.get(0));
    }
    @Test
    public void getWordsTest4(){
        Assert.assertEquals("Write",makeArrayListsText.infinitiveWord.get(140));
    }
    @Test
    public void getWordsTest5(){
        Assert.assertEquals("Arisen",makeArrayListsText.pastPrincaple.get(0));
    }
    @Test
    public void getWordsTest6(){
        Assert.assertEquals("Written",makeArrayListsText.pastPrincaple.get(140));
    }
    @Test
     public void matchWordsSentence1(){
        Assert.assertEquals("Yesterday, the sun ______ on the horison at 8:00.",makeArrayListsText.pastSentence.get(0));
        getWordsTest1();
    }
    @Test
    public void matchWordsSentence2(){
        Assert.assertEquals("Shakespear ________ amasing stories in his youth.",makeArrayListsText.pastSentence.get(140));
        getWordsTest1();
    }
    @Test
    public void matchWordsSentence3(){
        Assert.assertEquals("If you mix water and sand, mud will ____.",makeArrayListsText.infinitiveSentense.get(0));
        getWordsTest3();
    }
    @Test
    public void matchWordsSentence4(){
        Assert.assertEquals("Can you ____ that down?",makeArrayListsText.infinitiveSentense.get(140));
        getWordsTest3();
    }
    @Test
    public void matchWordsSentence5(){
        Assert.assertEquals("The sun has ______ from the horsizon",makeArrayListsText.pastPrincapleSentence.get(0));
        getWordsTest2();
    }
    @Test
    public void matchWordsSentence6(){
        Assert.assertEquals("This one is missing.",makeArrayListsText.pastPrincapleSentence.get(140));
        getWordsTest4();
    }
}
