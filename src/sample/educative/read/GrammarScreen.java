package sample.educative.read;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.educative.EducativeHomeScreen;
import sample.educative.read.tenseScreens.ExplainTenseScreen;

public class GrammarScreen  extends Application {
    Pane pane = new Pane();
    Scene scene;
    int pastY = 65;
    int presentY = 65;
    int futureY = 65;

    @Override
    public void start(Stage stage) throws Exception {
        int pastX = 100;
        int presentX = 300;
        int futureX = 500;

        Button btnBack = new Button("back");
        //these are all tenses
        Button btnSimplePast = new Button("Past");
        Button btnPresentSimple = new Button("Present");
        Button btnContinues = new Button("Continues");
        Button btnPresentProgressive = new Button("Present Progressive");
        Button btnPastProgressive = new Button("Past Progressive");
        Button btnPresentPerfect = new Button("Present Perfect");
        Button btnPresentPerfectProgressive = new Button("Present Perfect Progressive");
        Button btnPastPerfect = new Button("Past perfect");
        Button btnPastPerfectProgressive = new Button("Past pefect Progressive");
        Button btnFutureWill = new Button("Future will");
        Button btnFutureGoingTo = new Button("Future going to");
        Button btnFutureProgressive = new Button("Future progressive");
        Button btnFuturePerfect = new Button("Future perfect");

        Button btnFactors = new Button("Factors");

        btnSimplePast.relocate(pastX,getPastY());
        btnPresentSimple.relocate(presentX,getPresentY());
        btnContinues.relocate(presentX,getPresentY());
        btnPresentProgressive.relocate(presentX,getPresentY());
        btnPastProgressive.relocate(pastX,getPastY());
        btnPresentPerfect.relocate(presentX,getPresentY());
        btnPresentPerfectProgressive.relocate(presentX,getPresentY());
        btnPastPerfect.relocate(presentX,getPresentY());
        btnPastPerfectProgressive.relocate(pastX,getPastY());
        btnFutureWill.relocate(futureX,getFutureY());
        btnFutureGoingTo.relocate(futureX,getFutureY());
        btnFutureProgressive.relocate(futureX,getFutureY());
        btnFuturePerfect.relocate(futureX,getFutureY());

        btnBack.relocate(0,575);
        btnBack.setOnAction(E->{
            goEducativeScreen(stage);
        });

        btnSimplePast.setOnAction(E->{
            goExplainTenseScreen(stage,0);
        });



        pane.getChildren().addAll(btnBack,btnSimplePast,btnPresentSimple,btnContinues,
                btnPresentProgressive,btnPastProgressive,btnPresentPerfect,btnPastPerfectProgressive,
                btnPresentPerfectProgressive,btnPastPerfect,btnFutureWill,btnFutureGoingTo,
                btnFutureProgressive,btnFuturePerfect
                );

        scene = new Scene(pane, 800, 600);
        stage.setTitle("Grammar screen");
        stage.setScene(scene);
        stage.show();
    }
    public void goEducativeScreen(Stage stage){
        ReadScreen readScreen = new ReadScreen();
        try {
            readScreen.start(stage);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public int getPastY(){
        this.pastY+=40;
        return pastY;
    }
    public int getPresentY(){
        this.presentY+=40;
        return presentY;
    }
    public int getFutureY(){
        this.futureY+=40;
        return futureY;
    }
    public void goExplainTenseScreen(Stage stage,int tense){
        ExplainTenseScreen explainTenseScreen = new ExplainTenseScreen(tense);
        try {
            explainTenseScreen.start(stage);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}