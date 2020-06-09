package sample.educative.read.tenseScreens;

import javafx.scene.control.Button;
import javafx.stage.Stage;
import sample.educative.GoToEducative;
import sample.educative.read.GrammarScreen;

import java.util.ArrayList;

public class TenseKeeper {
    public ArrayList<String> tensesExplained = new ArrayList<>();
    public ArrayList<String> tenseName = new ArrayList<>();
    public ArrayList<Button> buttons = new ArrayList<>();
    GoToEducative goToEducative = new GoToEducative();
    Stage stage;
    public TenseKeeper(){
     makeTenses();
    }
    public void setStage(Stage stage){
        this.stage = stage;
    }
    public void makeTenses(){
        makePastSimple();
        makePastPerfect();
        makePastPerfectProgressive();
    }
    public void makePastSimple(){
        tensesExplained.add("The past simple is about something that already happened \n" +
                "For example: \n Yesterday,I walked to the store.\n  I looked at it an hour ago. \n Yesterday, I danced to the music\n" +
                "You make these words by taking the base word, and paste +ad behind it. \n " +
                "But there is one exeption, the irregular verbs\n" +
                "there is no rule for identifieng these words, you just need to learn them.\n" +
                "you can find those at the grammar page");
                tenseName.add("Past simple");
    }
    public void makePastPerfect(){
        tensesExplained.add("The past perfect is an event that happened before the past simple\n" +
                "For example:\n" +
                "Yesterday, I had played basketball before Mary came.\n"+
                "I had worked a few hours before i used to start\n" +
                "I had no idea where you talked about, until you mentioned it was a sport\n" +
                "Be aware that  if the word is an irregular verb, you should use the thirth row.\n" +
                "You can find that list of words on the grammar screen");
        tenseName.add("Past Perfect");
    }
    public void makePastPerfectProgressive(){
        tensesExplained.add("The past perfect progressive is almost like the past perfect. \n" +
                "The past perfect progressive is about a length of time that already happened.\n" +
                "For example:\n " +
                "I have been searching you for hours.\n" +
                "I have been running for 2 hours\n"+
                "The children had been collecting money all morning.\n" +
                "You can make the past perfect continues by adding the word been to the sentence");
        tenseName.add("Past perfect progressive");
    }
    public void makePastContinious(){
        tensesExplained.add("The past continuous is something that happened in the past.\n" +
                "it was happening at that moment.\n" +
                "for example: \n" +
                "I was reading when the book fell.\n" +
                "We were running when the car drove by\n" +
                "He was laughing after the joke was told\n\n" +
                "You use this tense by using the word 'was' or 'were'.\n" +
                "Then you use the verb and paste the letters 'ing' behind it \n" +
                "You use the word was if it is a single person, He, She, I.\n" +
                "You use were if it is about multiple persons like They, we, you");
        tenseName.add("Past continious");
    }
}
