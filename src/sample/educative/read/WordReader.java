package sample.educative.read;

import sample.educative.WordWithAudio;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class WordReader {
    private static final String filename = "/_txtfiles/words.txt";
    private static final String path = System.getProperty("user.dir");

    private ArrayList<WordWithAudio> words = new ArrayList<WordWithAudio>();

    public WordReader(){
        try(InputStream in = getClass().getResourceAsStream(filename);
                BufferedReader bf = new BufferedReader(new InputStreamReader(in))){
                    String line = "";
                    while((line = bf.readLine()) != null)
                        words.add(makeCombo(line, line));
        }
        catch(Exception e){
            System.out.println("Couldn't find/read file: "+filename);
            System.out.println("Error message: "+e.getMessage());
        }
    }

//    public WordWithAudio getRandomWord(){
//        return words.get((int)(Math.random()*words.size()));
//    }

    public ArrayList<WordWithAudio> getCombos(){
        return words;
    }

    public WordWithAudio makeCombo(String word, String audio){
        WordWithAudio wordCombo = new WordWithAudio(word,  new File(path, "/src/audio/"+audio+".mp3"));
        return wordCombo;
    }

}
