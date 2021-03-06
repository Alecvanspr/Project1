package sample.educative;

import javafx.stage.Stage;
import sample.educative.read.GrammarScreen;
import sample.educative.read.tenseScreens.ExplainTenseScreen;
import sample.educative.read.tenseScreens.IrregularWords.IrregularVerbsScreen;
import sample.educative.read.tenseScreens.IrregularWords.PracticeScreen;

public class GoToEducative {
    public void goGrammar(Stage stage){
        GrammarScreen grammarScreen = new GrammarScreen();
        try {
            grammarScreen.start(stage);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void goIrregularVerbScreen(Stage stage){
        IrregularVerbsScreen irregularVerbsScreen = new IrregularVerbsScreen();
        try {
            irregularVerbsScreen.start(stage);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void goExplainTenseScreen(Stage stage,int tense){
        ExplainTenseScreen explainTenseScreen = new ExplainTenseScreen(tense);
        try {
            explainTenseScreen.start(stage);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void goPractice(Stage stage){
        PracticeScreen practiceScreen = new PracticeScreen();
        try {
            practiceScreen.start(stage);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
