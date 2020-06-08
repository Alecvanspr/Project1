package sample.educative.read;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StoryReader {
    private static final String filename = "/_txtfiles/";

    public StoryReader(String story) throws FileNotFoundException {
        File file = new File(filename+story);
        Scanner scanner = new Scanner(file);

        while(scanner.hasNextLine()){
            System.out.println(scanner.nextLine());
        }
    }

}
