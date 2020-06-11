package sample.educative.MathGame;

import java.util.Random;

public class MathGame {
    private Random random = new Random();
    private int randNumb1 = random.nextInt(50);
    private int randNumb2 = random.nextInt(50);
    private int randButNumb = random.nextInt(4);
    private int randOperator = random.nextInt(4);
    private String operator;
    private Boolean game = false;
    private Boolean startBtn = false;
    private int wrongAnswers = 0;
    private int wrightAnswers = 0;
    private int randAnswer1;
    private int randAnswer2;
    private int randAnswer3;
    private int randAnswer4;
    private int numberBound;
    private int answer;

    public void setGame(Boolean game) {
        this.game = game;
        this.startBtn = true;
    }
    public int ButtonNumber1(){
        if(randButNumb == 0) {
            return answer;
        }else{
            return randAnswer1;
        }
    }
    public int ButtonNumber2(){
        if(randButNumb == 1) {
            return answer;
        }else{
            return randAnswer2;
        }
    }
    public int ButtonNumber3(){
        if(randButNumb == 2) {
            return answer;
        }else{
            return randAnswer3;
        }
    }
    public int ButtonNumber0(){
        if(randButNumb == 3) {
            return answer;
        }else{
            return randAnswer4;
        }
    }
    public void setRandNumb() {
        this.randNumb1 = random.nextInt(50);
        this.randNumb2 = random.nextInt(50);
        this.randButNumb = random.nextInt(3);
        this.randAnswer1 = random.nextInt(50);
        this.randAnswer2 = random.nextInt(50);
        this.randAnswer3 = random.nextInt(50);
        this.randAnswer4 = random.nextInt(50);
    }

    public Boolean getGame() {
        return game;
    }

    public Boolean getStartBtn() {
        return startBtn;
    }

    public int getRandNumb1() {
        return randNumb1;
    }

    public int getRandNumb2() {
        return randNumb2;
    }
    public int getAnswer() {
        return answer;
    }

    public int getWrongAnswers() {
        return wrongAnswers;
    }

    public void setWrongAnswers() {
        this.wrongAnswers +=1;
    }
    public int getWrightAnswers() {
        return wrightAnswers;
    }

    public void setWrightAnswers() {
        this.wrightAnswers +=1;
    }

    public String MathQuestion(){
        return getRandNumb1() + " " + operator + " " + getRandNumb2() + " = ?";
    }

    public void setRandOperator(int randOperator) {
        this.randOperator = randOperator;
    }

    public void setNumberBound(int numberBound) {
        this.numberBound = numberBound;
    }

    public void RandomOperator(){
        switch (randOperator){
            case 0: operator = "+";
                    answer = randNumb1 + randNumb2;
                break;
            case 1: operator = "-";
                    answer = randNumb1 - randNumb2;
                break;
            case 2: operator = "/";
                    answer = randNumb1 / randNumb2;
                break;
            case 3: operator = "*";
                    answer = randNumb1 * randNumb2;
        }
    }
}
