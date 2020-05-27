package sample.educative.MathGame;

import java.util.Random;

public class MathGame {
    static Random random = new Random();
    static int randNumb1 = random.nextInt(50);
    static int randNumb2 = random.nextInt(50);
    static int randButNumb = random.nextInt(3);

    Boolean game = true;
    int wrongAnswers = 0;
    static int answer = randNumb1 + randNumb2;
    static int randAnswer1 = random.nextInt(50);
    static int randAnswer2 = random.nextInt(50);
    static int randAnswer3 = random.nextInt(50);
    static int randAnswer4 = random.nextInt(50);

    public static String MathQuestion(){
        return randNumb1 + " + " + randNumb2 + " = ?";
    }
    public static int ButtonNumber1(){
        if(randButNumb == 0) {
            return answer;
        }else{
            return randAnswer1;
        }
    }
    public static int ButtonNumber2(){
        if(randButNumb == 1) {
            return answer;
        }else{
            return randAnswer2;
        }
    }
    public static int ButtonNumber3(){
        if(randButNumb == 2) {
            return answer;
        }else{
            return randAnswer3;
        }
    }
    public static int ButtonNumber0(){
        if(randButNumb == 3) {
            return answer;
        }else{
            return randAnswer4;
        }
    }

    public static void NextNumber(){
        randNumb1 = random.nextInt();
        randNumb2 = random.nextInt();
        randButNumb = random.nextInt();
        randAnswer1 = random.nextInt();
        randAnswer2 = random.nextInt();
        randAnswer3 = random.nextInt();
        randAnswer4 = random.nextInt();
    }

    public void CheckAnswer(){

    }

}
