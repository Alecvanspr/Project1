package sample.educative.read.tenseScreens.IrregularWords;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PastParticipleReader {
    private static final String fileSentence = "/_txtfiles/SentensePastParticle.txt";
    private static final String fileWords = "/_txtfiles/IrregularVerbsPastParticiple.txt";

    private ArrayList<String> words = new ArrayList<String>();
    private ArrayList<String> sentences = new ArrayList<String>();

    public PastParticipleReader(){
        makeArraylistFromText(words,fileWords);
        makeArraylistFromText(sentences,fileSentence);
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