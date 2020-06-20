package sample.educative.MathGame;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MathGameTest {
MathGame mathGame;
public void MakeNewMathGame(int operator){
    mathGame= new MathGame();
    mathGame.RandomOperator();
    mathGame.setRandOperator(operator);
}
    @Test
        public void testRandomCorrect1(){
            MakeNewMathGame(0);
            Assert.assertEquals(mathGame.getRandNumb1()+mathGame.getRandNumb2(),mathGame.getAnswer());
    }
    @Test
    public void testRandomCorrect2(){
        MakeNewMathGame(0);
        Assert.assertEquals(mathGame.getRandNumb1()+mathGame.getRandNumb2(),mathGame.getAnswer());
    }
    @Test
    public void testRandomCorrect3(){
        MakeNewMathGame(1);
        Assert.assertEquals(mathGame.getRandNumb1()-mathGame.getRandNumb2(),mathGame.getAnswer());
    }
}