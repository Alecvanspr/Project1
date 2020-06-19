package sample.educative;

import java.io.File;

public class WordWithAudio {

    private String text;
    private File audio;

    public WordWithAudio(String line, File audio){
        this.text = line;
        this.audio = audio;
    }

    public String getWord() {
        return text;
    }

    public File getAudio() {
        return audio;
    }
}
