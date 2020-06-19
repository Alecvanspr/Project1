package sample.educative.read.tenseScreens.IrregularWords;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.ButtonSettings;
import sample.educative.GoToEducative;


public class IrregularVerbsScreen extends Application {
    GoToEducative goToEducative = new GoToEducative();
    Pane pane = new Pane();
    PastWordReader pastWordReader = new PastWordReader();
    TextReader textReader = new TextReader();
    ButtonSettings buttonSettings = ButtonSettings.getInstance();
    MakeArrayListsText makeArrayListsText = MakeArrayListsText.getInstance();
    int placementY = 100;
    @Override
    public void start(Stage stage) throws Exception {
        PrintIrregularVerbs();
        makeButtons(stage);
        fin(stage);
    }
    public void fin(Stage stage){
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(pane);
        Scene scene = new Scene(scrollPane, 800, 600);
        stage.setTitle("Educative homescreen");
        stage.setScene(scene);
        stage.show();
    }
    public void makeButtons(Stage stage){
        makeBtnBack(stage);
        makeBtnPractice(stage);
    }
    public void makeBtnBack(Stage stage){
        Button btnBack = new Button("Back");
        btnBack.setOnAction(E->{
            goToEducative.goGrammar(stage);
        });
        btnBack.relocate(100,0);
        buttonSettings.onMouse(btnBack);
        pane.getChildren().add(btnBack);
    }
    public void makeBtnPractice(Stage stage){
        Button btnPractice = new Button("Practice");
        btnPractice.relocate(300,0);
        btnPractice.setOnAction(E->{
            goToEducative.goPractice(stage);
        });
        pane.getChildren().addAll(btnPractice);
    }

    public void PrintIrregularVerbs(){

        for(int i = 0; MakeArrayListsText.infinitiveWord.size()>i; i++) {
            Label lblInfinitive = new Label(MakeArrayListsText.infinitiveWord.get(i));
            Label lblPast = new Label(pastWordReader.getWords().get(i));
            Label lblPastParticle = new Label(MakeArrayListsText.pastPrincaple.get(i));

            lblPast.relocate(300,placementY);
            lblInfinitive.relocate(100,placementY);
            lblPastParticle.relocate(500,placementY);
            placementY+=35;
            pane.getChildren().addAll(lblInfinitive,lblPast,lblPastParticle);
        }
    }
}
