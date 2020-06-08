package sample.educative.read;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Random;

public class StoryScreen extends Application {
    Pane pane = new Pane();
    Scene scene = new Scene(pane,800,600);
    Random random = new Random();
    int rng = random.nextInt(titles.size()-1);
    private static ArrayList<String> titles = new ArrayList<>();

    public void fillList(){
        titles.add("colourfulWorld.txt");
        titles.add("tortAndHare.txt");
    }

    @Override
    public void start(Stage stage) throws Exception {
        fillList();
        StoryReader sr = new StoryReader(titles.get(rng));
        Text text = new Text();

    }
}
