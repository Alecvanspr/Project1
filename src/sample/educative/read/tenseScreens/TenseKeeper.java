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
                makeButtonsPastSimple();
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
        makeButtonsPastPerfect();
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
        makeButtonsPastPerfectProgressive();
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
        makeButtonPastContinious();
    }

    public void makePresentSimple(){
        tensesExplained.add("The present simple is something that is happening right now\n" +
                "For example: \n I walk to the store.\n They eat ice cream together\n" +
                " She goes to the doctor\n I look at it now\n We dance to the music\n He makes a sandcastle\n" +
                "You make these verbs by taking the base form and adding 's' or 'es' " +
                "depending on the subject");
        tenseName.add("Present Simple");
    }
    //present continuous en present progressive zijn het zelfde
    public void makePresentContinuous(){
        tensesExplained.add("The present continuous is used to show that the action is still going on right now.\n" +
                "For example:\n You are learning English now.\n I am sitting.\n They are watching television.\n " +
                "Are you sleeping?\n We are going home" +
                "You create the present continuous by using the correct form of to be followed by a verb ending in 'ing'");
        tenseName.add("Present continuous");
    }

    public void makePresentPerfect(){
        tensesExplained.add("The present perfect is used to talk about experiences or changes that have taken place.\n" +
                "For example:\n I have seen that movie twenty times.\n People have traveled to the moon.\n " +
                "I have been to France.\n Joan has studied two foreign languages.\n" +
                " Our son has learned how to read.\n" +
                "To make the present perfect, you first use has/have depending on the subject.\n" +
                "You follow this with the past participle");
        tenseName.add("Present Perfect");
    }

    public void makePresentPerfectProgressive(){
        tensesExplained.add("The present perfect progressive (Also known as present perfect continuous) is used to show\n" +
                " that an action has started in the past and still continues in the current moment.\n" +
                "For example:\n They have been talking for the last hour.\n She has been working at that company for three years\n" +
                " We have been waiting here for over two hours!\n To create the present perfect progressive, you first use the right form of to have depending on subject.\n" +
                "This will be followed by 'been' followed by the present participle");
        tenseName.add("Present Perfect PRogressive");
    }

    public void makeFutureGoingTo(){
        tensesExplained.add("When talking about the future, you can use 'going to' to talk about a plan or a prediction.\n" +
                "For example:\n He is going to spend his vacation on Hawaii.\n I'm going to be an actor when i grow up.\n" +
                " The year 2020 is going to be a very unfortunate year.\n The next president is going to make the country better\n" +
                "To make a future form using goign to, you start with the correct form of to be followed by going to followed by the base form of another verb.");
        tenseName.add("Future Going To");
    }

    public void makeFutureWill(){
        tensesExplained.add("Using will for sentences talking about the future is very similar to 'going to'. However there is a slight difference in meaning.\n" +
                "Whereas 'going to' is mostly used for plans or predictions. Will is used for promises or voluntary actions.\nFor example:\n " +
                "I will get the package from the post office.\n Will you make dinner?\n I will not tell anyone your secret.\n" +
                " We will go to the mall together.\nTo make a sentence using will, you start with 'will' and follow it up by a verb in the present participle.");
        tenseName.add("Future Will");
    }

    public void makeFuturePerfect(){
        tensesExplained.add("The future perfect is very similar to the present perfect.\nFor example:\n " +
                "You will have perfect your English by the time you come back from the U.S.\n In November, I will have received my promotion.\n " +
                "She will have been in London for six months by the time she leaves.\n" +
                "To create the future perfect you start with 'will have', followed by a verb in the past participle.");
        tenseName.add("Future Perfect");
    }

    public void makeFutureProgressive(){
        tensesExplained.add("The future progressive is used to specify an interrupted action in the future.\nFor example:\n " +
                "I will be watching TV when she arrives tonight.\n At midnight tonight, we will still be driving through the desert.\n" +
                "To construct a sentence with the future progressive you start with 'will be' followed by a verb in the present participle");
        tenseName.add("Future progressive");
    }

    public void makeButtonsPastSimple(){
        Button button = new Button("Practice Past simple");
        button.relocate(400,400);
        button.setOnAction(E->{
        goToEducative.goSimplePastScreen(stage);
        buttons.add(button);
        });
    }
    public void makeButtonsPastPerfect(){
        Button button = new Button("Practice Past perfect");
        button.relocate(400,400);
        button.setOnAction(E->{
            goToEducative.goPastPerfect(stage);
        });
        buttons.add(button);
    }
    public void makeButtonsPastPerfectProgressive(){
        Button button = new Button("Practice Past Progressive ");
        button.relocate(400,400);
        button.setOnAction(E->{
            goToEducative.goPastProgressive(stage);
        });
        buttons.add(button);
    }
    public void makeButtonPastContinious(){
        Button button = new Button("Practice Past continious");
        button.relocate(400,400);
        button.setOnAction(E->{
            PastProgressiveScreen pastProgressiveScreen = new PastProgressiveScreen();
            try {
                pastProgressiveScreen.start(stage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        buttons.add(button);
    }
}
