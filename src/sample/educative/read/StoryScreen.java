package sample.educative.read;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import sample.ButtonSettings;
import sample.GoToScreens;
import java.util.ArrayList;

public class StoryScreen extends Application {
    Pane pane = new Pane();
    GoToScreens goToScreens = new GoToScreens();
    ButtonSettings buttonSettings = new ButtonSettings();
    StoryReader sr;
    Button btnStory1 = new Button("Colourful world");
    Button btnStory2 = new Button("The tortoise and the hare");
    Button btnBack = new Button("Back");
    ScrollPane scrollPane = new ScrollPane();
    Scene scene = new Scene(scrollPane,800,600);
    Label lblStory = new Label();

    private static ArrayList<String> titles = new ArrayList<>();

    public void fillList(){
        titles.add("colourfulWorld.txt");
        titles.add("tortAndHare.txt");
    }

    @Override
    public void start(Stage stage) throws Exception {
        fillList();
        makeBtnStory1(stage);
        makeBtnStory2(stage);
        makeBtnBack(stage);
        pane.getChildren().addAll(btnStory1,btnStory2,btnBack);
        scrollPane.setContent(pane);
        fin(stage);
    }

    public void makeBtnBack(Stage stage){
        btnBack.relocate(0,575);
        buttonSettings.onMouse(btnBack);
        btnBack.setOnAction(e->{
            goToScreens.goReadScreen(stage);
        });
    }
    public void makeBtnStory1(Stage stage){
        btnStory1.relocate(100,100);
        btnStory1.setOnAction(e->{
            pane.getChildren().remove(btnStory1);
            pane.getChildren().remove(btnStory2);
            makeLblStory(stage,0);
        });
    }
    public void makeBtnStory2(Stage stage){
        btnStory2.relocate(200,100);
        btnStory1.setOnAction(e->{
            pane.getChildren().remove(btnStory2);
            pane.getChildren().remove(btnStory1);
            makeLblStory(stage,1);
        });
    }

    public void makeLblStory(Stage stage, int i){
        sr = new StoryReader(titles.get(i));
        String text = sr.getContent();
        String textF = text.replaceAll("/", "\n");
        String textFormat = textF.replaceAll("null","");
        lblStory.setText(textFormat);
        lblStory.relocate(50,15);
        lblStory.setMaxWidth(600);
        lblStory.setFont(new Font("Comic Sans MS",15));
        pane.getChildren().add(lblStory);
    }

    public void fin (Stage stage){
        stage.setTitle("Story");
        stage.setScene(scene);
        stage.show();
    }
}
