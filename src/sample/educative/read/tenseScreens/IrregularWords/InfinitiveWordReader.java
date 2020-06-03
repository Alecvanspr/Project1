package sample.educative.read.tenseScreens.IrregularWords;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class InfinitiveWordReader {
    /*
    ik heb 2 verschillende dingen aangemaakt, dat heeft te maken met het open closed princaple,
    nu kan je makkelijk 2 dingen aanpassen zonder dat je alles moet veranderen.
     */
    private static final String fileWordsName = "/_txtfiles/IrregularVerbsInfinitive.txt";
    private static final String fileSentenceName = "/_txtfiles/SentenceInfinitive.txt";

    private ArrayList<String> words = new ArrayList<String>();
    private ArrayList<String> sentences = new ArrayList<String>();


    public InfinitiveWordReader(){
        makeArraylistFromText(words,fileWordsName);
        makeArraylistFromText(sentences,fileSentenceName);
    }
    public void makeArraylistFromText(ArrayList<String> arrayList,String filename){
        try(InputStream in = getClass().getResourceAsStream(filename);
            BufferedReader bf = new BufferedReader(new InputStreamReader(in))){
            String line = "";
            while((line = bf.readLine()) != null)
                arrayList.add(line);
        }
        catch(Exception e){
            System.out.println("Couldn't find/read file: "+filename);
            System.out.println("Error message: "+e.getMessage());
        }
    }
    public ArrayList<String> getWords() {
        return words;
    }
    public ArrayList<String> getSentences(){return sentences;}
}
