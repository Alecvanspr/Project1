package sample.educative.read.tenseScreens;

import java.util.ArrayList;

public class TenseKeeper {
    public ArrayList<String> tensesExplained = new ArrayList<>();
    public ArrayList<String> tenseName = new ArrayList<>();
    public TenseKeeper(){
     makeTenses();
    }
    public void makeTenses(){
        makePastSimple();
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
}
