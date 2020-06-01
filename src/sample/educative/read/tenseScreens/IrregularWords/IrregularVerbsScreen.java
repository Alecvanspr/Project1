package sample.educative.read.tenseScreens.IrregularWords;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class IrregularVerbsScreen extends Application {
    Pane pane = new Pane();
    PastWordReader pastWordReader = new PastWordReader();
    InfinitiveWordReader infinitiveWordReader = new InfinitiveWordReader();
    PastParticipleReader pastParticipleReader = new PastParticipleReader();
    int placementY = 100;
    @Override
    public void start(Stage stage) throws Exception {
        Button btnBack = new Button("Back");
        Button btnPractice = new Button("Practice");

        btnBack.relocate(100,0);
        btnPractice.relocate(300,0);

        PrintIrregularVerbs();


        pane.getChildren().addAll(btnBack,btnPractice);
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(pane);
        Scene scene = new Scene(scrollPane, 800, 600);
        stage.setTitle("Educative homescreen");
        stage.setScene(scene);
        stage.show();
    }
    /*
    ergens mis ik een redelijk rijtje met irregular verbs.
    je moet nog even kijken welke ik mis.
    https://engelslerenonline.com/werkwoorden/onregelmatige-werkwoorden/
    en mischien moeten we niet alles er in verwerken. dit is ok. ik maak er wel een leuke opdracht bij ofzo.
    maar claudio zij ook dat het anders te veel loos werk is.
    als we echt op een punt komen dat we alles hebben gedaan en dat we echt niks te doen hebben.is het mischien leuk om te doen.
    ok doei.
     */

    public void PrintIrregularVerbs(){
        for(int i = 0; infinitiveWordReader.getWords().size()>i;i++) {
            Label lblInfinitive = new Label(infinitiveWordReader.getWords().get(i));
            Label lblPast = new Label(pastWordReader.getWords().get(i));
            Label lblPastParticle = new Label(pastParticipleReader.getWords().get(i));

            lblPast.relocate(300,placementY);
            lblInfinitive.relocate(100,placementY);
            lblPastParticle.relocate(500,placementY);

            placementY+=35;

            pane.getChildren().addAll(lblInfinitive,lblPast,lblPastParticle);
        }
    }
}
