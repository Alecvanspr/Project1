package sample.educative.MathGame;

import org.junit.Assert;
import org.junit.Test;



public class MathGameTest {
    MathGame mathGame;
    public void MakeNewMathGame(int operator){
        mathGame = new MathGame();
        mathGame.RandomOperator();
        mathGame.setRandOperator(operator);
    }
    @Test
    public void testRandomCorrect1(){
        MakeNewMathGame(0);
        Assert.assertEquals((mathGame.getRandNumb1() + mathGame.getRandNumb2()) < 1000, mathGame.getAnswer() < 1000);
    }
    @Test
    public void testRandomCorrect2(){
        MakeNewMathGame(1);
        Assert.assertEquals((mathGame.getRandNumb1() - mathGame.getRandNumb2()) < 1000, mathGame.getAnswer() < 1000);
    }
    @Test
    public void testRandomCorrect3(){
        MakeNewMathGame(2);
        Assert.assertEquals((mathGame.getRandNumb1() / mathGame.getRandNumb2()) < 1000, mathGame.getAnswer() < 1000);
    }
    @Test
    public void testRandomCorrect4(){
        MakeNewMathGame(3);
        Assert.assertEquals((mathGame.getRandNumb1() * mathGame.getRandNumb2()) < 1000, mathGame.getAnswer() < 1000);
    }
}
