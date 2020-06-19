package sample.educative.read.tenseScreens.IrregularWords;


import sample.educative.WordWithAudio;

import java.util.ArrayList;


public class MakeArrayListsText {
    private static MakeArrayListsText instance;
    private MakeArrayListsText(){
        makeTextArrayLists();
    }
    public static MakeArrayListsText getInstance() {
        if(instance == null) {
        instance = new MakeArrayListsText();
        }
        return instance;
    }
    TextReader textReader = new TextReader();
    public static ArrayList<String> infinitiveWord;
    public static ArrayList<String> infinitiveSentense;
    public static ArrayList<String> pastWord;
    public static ArrayList<String> pastSentence;
    public static ArrayList<String> pastPrincaple;
    public static ArrayList<String> pastPrincapleSentence;


    public void makeTextArrayLists(){
        infinitiveWord = textReader.TextReader("/_txtfiles/IrregularVerbsInfinitive.txt");
        infinitiveSentense = textReader.TextReader("/_txtfiles/SentenceInfinitive.txt");
        pastWord = textReader.TextReader("/_txtfiles/IrregularVerbsPast.txt");;
        pastSentence= textReader.TextReader("/_txtfiles/SentencePast.txt");
        pastPrincaple  = textReader.TextReader("/_txtfiles/IrregularVerbsPastParticiple.txt");
        pastPrincapleSentence = textReader.TextReader("/_txtfiles/SentensePastParticle.txt");
    }
}
