package sample.educative.read;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StoryReader {
    private static final String filename = "/src/_txtfiles/stories/";
    private String content;

    public StoryReader(String story) throws FileNotFoundException {
        String path = System.getProperty("user.dir");
        File file = new File(path, filename+story);
        Scanner scanner = new Scanner(file);

        while(scanner.hasNextLine()){
            System.out.println(scanner.nextLine());
            setContent(scanner.nextLine());
        }
    }

    public void setContent(String content) {
        this.content = content.concat(content);
    }

    public String getContent(){
        return content;
    }

}
