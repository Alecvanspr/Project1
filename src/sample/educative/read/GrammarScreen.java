package sample.educative.read;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.GoToScreens;
import sample.educative.EducativeHomeScreen;
import sample.educative.GoToEducative;
import sample.educative.read.tenseScreens.ExplainTenseScreen;
import sample.educative.read.tenseScreens.IrregularWords.IrregularVerbs;
import sample.educative.read.tenseScreens.IrregularWords.IrregularVerbsScreen;

public class GrammarScreen  extends Application {
    GoToScreens goToScreens = new GoToScreens();
    GoToEducative goToEducative = new GoToEducative();
    Pane pane = new Pane();
    Scene scene;
    int pastX = 100;
    int presentX = 300;
    int futureX = 500;
    int pastY = 65;
    int presentY = 65;
    int futureY = 65;

    @Override
    public void start(Stage stage) throws Exception {
        Button btnFactors = new Button("Factors");
        makeButtons(stage);
        fin(stage);
    }

    public int getPastY() {
        this.pastY += 40;
        return pastY;
    }

    public int getPresentY() {
        this.presentY += 40;
        return presentY;
    }

    public int getFutureY() {
        this.futureY += 40;
        return futureY;
    }

    public void fin(Stage stage) {
        scene = new Scene(pane, 800, 600);
        stage.setTitle("Grammar screen");
        stage.setScene(scene);
        stage.show();
    }
    public void makeButtons(Stage stage){
        makeTenseButtons(stage);
        makeIrregualarVerb(stage);
        makeBtnBack(stage);
    }

    public void makeTenseButtons(Stage stage) {
        makeBtnSimplePast(stage);
        makeBtnPresentSimple(stage);
        makeBtnContinues(stage);
        makebtnPresentProgressive(stage);
        makeBtnPastPerfect(stage);
        makeBtnPastPerfectProgressive(stage);
        makeFutureWill(stage);
        makeBtnFutureGoingto(stage);
        makeBtnFutureProgressive(stage);
        makeBtnFuturePerfect(stage);
        makebtnPresentPerfectProgressive(stage);
        makebtnPastPerfectProgressive(stage);
    }
    public void makeIrregualarVerb(Stage stage){
        Button btnIrregularVerbs = new Button("Irregular verbs");
        btnIrregularVerbs.relocate(100, 400);
        btnIrregularVerbs.setOnAction(E -> {
            goToEducative.goIrregularVerbScreen(stage);
        });
        pane.getChildren().addAll (btnIrregularVerbs);
    }

    public void makeBtnBack(Stage stage) {
        Button btnBack = new Button("back");
        btnBack.relocate(0, 575);
        btnBack.setOnAction(E -> {
            goToScreens.goReadScreen(stage);
        });
        pane.getChildren().add(btnBack);
    }

    public void makeBtnSimplePast(Stage stage) {
        Button btnSimplePast = new Button("Past");
        btnSimplePast.setOnAction(E -> {
            goToEducative.goExplainTenseScreen(stage, 0);
        });
        btnSimplePast.relocate(pastX, getPastY());
        pane.getChildren().add(btnSimplePast);
    }

    public void makeBtnPresentSimple(Stage stage) {
        Button btnPresentSimple = new Button("Present");
        btnPresentSimple.relocate(presentX, getPresentY());
        pane.getChildren().add(btnPresentSimple);
    }

    public void makeBtnContinues(Stage stage) {
        Button btnContinues = new Button("Continues");
        btnContinues.setOnAction(E -> {
            goToEducative.goExplainTenseScreen(stage, 3);
        });
        btnContinues.relocate(presentX, getPresentY());
        pane.getChildren().add(btnContinues);
    }

    public void makebtnPresentProgressive(Stage stage){
    Button btnPresentProgressive = new Button("Present Progressive");
        btnPresentProgressive.relocate(presentX, getPresentY());
        pane.getChildren().add(btnPresentProgressive);
    }

    public void makeBtnPastPerfectProgressive(Stage stage) {
        Button btnPastProgressive = new Button("Past Progressive");
        btnPastProgressive.relocate(pastX, getPastY());
        pane.getChildren().add(btnPastProgressive);
    }

    public void makebuttonPresentPerfect(Stage stage){
        Button btnPresentPerfect = new Button("Present Perfect");
        btnPresentPerfect.relocate(presentX, getPresentY());
        pane.getChildren().add(btnPresentPerfect);
    }
    public void makebtnPresentPerfectProgressive(Stage stage) {
        Button btnPresentPerfectProgressive = new Button("Present Perfect Progressive");
        btnPresentPerfectProgressive.relocate(presentX, getPresentY());
        pane.getChildren().add(btnPresentPerfectProgressive);
    }
    public void makeBtnPastPerfect(Stage stage) {
        Button btnPastPerfect = new Button("Past perfect");
        btnPastPerfect.setOnAction(E -> {
            goToEducative.goExplainTenseScreen(stage, 1);
        });
        btnPastPerfect.relocate(pastX, getPastY());
        pane.getChildren().add(btnPastPerfect);
    }
    public void makebtnPastPerfectProgressive(Stage stage) {
        Button btnPastPerfectProgressive = new Button("Past pefect Progressive");
        btnPastPerfectProgressive.setOnAction(E -> {
            goToEducative.goExplainTenseScreen(stage, 2);
        });
        btnPastPerfectProgressive.relocate(pastX, getPastY());
        pane.getChildren().add(btnPastPerfectProgressive);
    }
    public void makeFutureWill(Stage stage) {
        Button btnFutureWill = new Button("Future will");
        btnFutureWill.relocate(futureX, getFutureY());
        pane.getChildren().add(btnFutureWill);
    }
    public void makeBtnFutureGoingto(Stage stage) {
        Button btnFutureGoingTo = new Button("Future going to");
        btnFutureGoingTo.relocate(futureX, getFutureY());
        pane.getChildren().add(btnFutureGoingTo);
    }
    public void makeBtnFutureProgressive(Stage stage) {
        Button btnFutureProgressive = new Button("Future progressive");
        btnFutureProgressive.relocate(futureX, getFutureY());
        pane.getChildren().add(btnFutureProgressive);
    }
    public void makeBtnFuturePerfect(Stage stage) {
        Button btnFuturePerfect = new Button("Future perfect");
        btnFuturePerfect.relocate(futureX, getFutureY());
        pane.getChildren().add(btnFuturePerfect);
    }
}