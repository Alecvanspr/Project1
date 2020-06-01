package sample.educative.read.tenseScreens.IrregularWords;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PastParticipleReader {
    private static final String filename = "/_txtfiles/IrregularVerbsPastParticiple.txt";

    private ArrayList<String> words = new ArrayList<String>();

    public PastParticipleReader(){
        try(InputStream in = getClass().getResourceAsStream(filename);
            BufferedReader bf = new BufferedReader(new InputStreamReader(in))){
            String line = "";
            while((line = bf.readLine()) != null)
                words.add(line);
        }
        catch(Exception e){
            System.out.println("Couldn't find/read file: "+filename);
            System.out.println("Error message: "+e.getMessage());
        }
    }

    public ArrayList<String> getWords() {
        return words;
    }

    public String getRandomWord(){
        if(words.isEmpty()) return "NO-DATA";
        return words.get((int)(Math.random()*words.size()));
    }
}