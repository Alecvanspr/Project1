package sample.educative.read.tenseScreens.IrregularWords;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TextReader {
    public ArrayList<String> TextReader(String fileName){
        ArrayList<String> arrayList = new ArrayList();
        makeArraylistFromText(arrayList,fileName);
        return arrayList;
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
}
