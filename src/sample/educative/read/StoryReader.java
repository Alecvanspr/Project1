package sample.educative.read;

import java.io.*;
import java.util.Scanner;

public class StoryReader {
    private static final String filename = "/src/_txtfiles/stories/";
    private String content;

    public StoryReader(String story){
        String line;
        String path = System.getProperty("user.dir");
        File file = new File(path, filename+story);
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            while((line = br.readLine()) != null){
                    content += line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getContent(){
        return this.content;
    }
}
